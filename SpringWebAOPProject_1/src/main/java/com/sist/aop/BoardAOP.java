package com.sist.aop;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;
import com.sist.dao.*;
@Aspect
@Component
/*
 *   1. ����͸� / �α� / �����˻� (ó��) / ���� �ľ� 
 *      => Ʈ����� , ���� , ��ȣȭ ��ȣȭ , ������ �б� => �м� 
 *   = ����� ����� �����ϴ� ��� 
 *   = �������� ������ ��Ƽ� ���� => �������� 
 *   = ���̺귯�� (Ʈ����� , ����)
 *   
 *   Spring FrameWork
 *    => DI
 *    => AOP
 *    => MVC
 *   -----------------
 *   
 *   1. � Ŭ������ �޼ҵ忡�� ����
 *      PointCut
 *      => execution()
 *      => within("��Ű����")
 *   2. �޼ҵ� ��ġ => JoinPoint
 *       = Before
 *       = After : finally
 *       = AfterReturning : ������� => return���� ���� �� �ִ� 
 *       = AfterThrowing : ����ó��
 *       = Around
 *   3. ���ͼ�Ʈ : �ڵ� �α��� , ID���� ...
 *      public String display()
 *      {
 *          before();
 *          try
 *          {
 *              ============ Around(SetAutoCommit(false))
 *               �ҽ��ڵ�
 *              ============ Around (commit())
 *          }catch(Exception e)
 *          {
 *              afterReturning(); => rollback
 *          }
 *          finally
 *          {
 *             after(); => setAutoCommit(true)
 *          }
 *          
 *          afterReturning();
 *          return "";
 *      }
 *      
 *      ��)
 *      @Before
 *       public void before()
 *       {
 *       }
 *      @After
 *       public void after()
 *       {
 *       }
 *      @AfterReturning
 *       public void afterReturning()
 *       {
 *       }
 *      @AfterThrowing
 *       public void afterThrowing()
 *       {
 *       }
 */
public class BoardAOP {
	@Autowired
	private BoardDAO dao;
	
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void after()
	{
		List<BoardVO> list=dao.boardTop5();
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("tList", list);
	}
}
