package com.sist.mapper;
/*
 *   1. web.xml
 *      DispatcherServlet ���
 *      �ѱ� ��ȯ
 *       = ���� ���
 *       = ���� ó��
 *   2. Ŭ���� ���� => �޸� �Ҵ� / ���� (****)
 *   3. Spring => xml�ڵ� ����
 *   4. mapper => dao => modeló�� (****)
 *   5. JSP���� (****)
 */
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.FoodVO;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+"FROM (SELECT fno,name,poster,rownum as num "
			+"FROM (SELECT fno,name,poster "
			+"FROM food_menu_house ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menu_house")
	public int foodTotalPage();
	/*
	 *   private int fno,hit;
		 private double score;
		 private String poster,name,type,address,phone,theme,price,time,seat,content;
	 */
	@Update("UPDATE food_menu_house SET "
			+"hit=hit+1 "
			+"WHERE fno=#{fno}")
	public void hitIncrement(int fno);
	
	@Select("SELECT fno,score,poster,name,type,address,"
			+"phone,theme,price,time,seat,content "
			+"FROM food_menu_house "
			+"WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	// �˻� => ��ü�� / �ּ� / ���� ���� 
	@Select("SELECT fno,name,poster,num "
			+"FROM (SELECT fno,name,poster,rownum as num "
			+"FROM (SELECT fno,name,poster "
			+"FROM food_menu_house "
			+"WHERE ${col_name} LIKE '%'||#{ss}||'%'"
			+"ORDER BY fno ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menu_house "
			+"WHERE ${col_name} LIKE '%'||#{ss}||'%'")
	public int foodFindTotalPage(Map map);
	
}
