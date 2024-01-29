package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
/*
 *                   
 *   *.do  ======= DispatcherServlet
 *                       | => preHandle() => �ڵ� �α��� / ID����
 *                       | HandlerMapping
 *                      @Controller / @RestController
 *                       | => postHandle()
 *                       | Model=request => ViewResolver
 *                       | => afterCompletion() => ����
 *                      JSP
 *   => AOP
 *      void aaa(); => Before
 *      void bbb(); => AfterThrowing
 *      void ccc(); => After
 *      void ddd(); => AfterReturning
 *      
 *      public String display()
 *      {
 *          aaa();
 *          try
 *          {   
 *              ===============
 *               �ٽ� �ҽ�
 *              ===============
 *          }catch(Exception e)
 *          {
 *              bbb();
 *          }
 *          finally
 *          {
 *              ccc();
 *          }
 *          ddd();
 *          return "";
 *      }
 *      
 *      JoinPoint : ȣ�� ��ġ 
 *      PoinCut :   ��� �޼ҵ�
 *      ===================== Advice
 *                            ====== ������ ��Ƽ� == Aspect
 *                              ���� ��� 
 *      => MVC
 *          | DI,AOP => Annotation , XML
 *            ==========================
 *            Annotation : ������ ���� (��ɺ�)
 *            XML : ���� ��� => ���̺귯�� ���� 
 */
@Repository
public class ReplyDAO {
	@Autowired
	private ReplyMapper mapper;
	
	public void replyInsert(ReplyVO vo)
	{
		mapper.replyInsert(vo);
	}
	public List<ReplyVO> replyListData(int fno)
	{
		return mapper.replyListData(fno);
	}
	public void replyUpdate(ReplyVO vo)
	{
		mapper.replyUpdate(vo);
	}
	public void replyDelete(int no)
	{
		mapper.replyDelete(no);
	}
}
