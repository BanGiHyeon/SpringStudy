package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.dao.*;
public interface BoardMapper {
	// 1. ��� ���
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,group_tab,num "
			+"FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
			+"FROM (SELECT no,subject,name,regdate,hit,group_tab "
			+"FROM springReplyBoard ORDER BY group_id DESC,group_step ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	// 1-1. �� ������
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springReplyBoard")
	public int boardTotalPage();
	// 2. �󼼺��� 
	@Update("UPDATE springReplyBoard SET "
			+"hit=hit+1 "
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,"
			+"TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
			+"FROM springReplyBoard "
			+"WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	// 3. �߰�
	@Insert("INSERT INTO springReplyBoard(no,name,subject,"
			+"content,pwd,group_id) "
			+"VALUES(sr_no_seq.nextval,#{name},"
			+"#{subject},#{content},#{pwd},"
			+"(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))")
	public void boardInsert(BoardVO vo);
	// 4. ����
	@Select("SELECT pwd FROM springReplyBoard "
			+"WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Update("UPDATE springReplyBoard SET "
			+"name=#{name},subject=#{subject},content=#{content} "
			+"WHERE no=#{no}")
	public void boardUpdate(BoardVO vo); 
	// 5. ���� => Ʈ����� ����
	// 6. �亯 => Ʈ����� ���� 
	// 7. ã�� => ���� ���� 
	// AOP => �ǽð� ���� (�α�) , �ǽð� �α� �Խù� 
}
