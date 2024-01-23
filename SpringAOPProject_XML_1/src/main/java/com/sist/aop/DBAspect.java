package com.sist.aop;
import com.sist.dao.*;
import java.util.*;

import org.aspectj.lang.ProceedingJoinPoint;
// DI => Injection => setter,������
// DI => Ŭ������ Ŭ������ ������� ���� 
/*
 *    aspect : �������� ���Ǵ� ����� ��Ƽ� ���� : ���� ��� 
 *    Advice
 *    ======
 *     PoinCut => � �޼ҵ忡 ����
 *     JoinPoint => ��ġ 
 *       = Before => �޼ҵ� ������
 *       = After => finally ����
 *       = After-Throwing => catch(���� �߻�)
 *       = After-Returning => return(���� ����)
 *       = Around => ���� 
 *       ========Around
 *         �ҽ�
 *       ========Around
 *   =====================================================
 *     �����ؼ� ���ο� ����� ����� (���� => Weaving) => Proxy���� (�븮��)
 *     
 *     PointCut : � �޼ҵ� ���� ���� 
 *       execution("* ��Ű����.Ŭ������.*()"
 *                 ===              === ��� �޼ҵ� �Ű������� ���� 
 *                 ������             �Ű����� ������� (..)
 *                                    (String),(String,int)
 *       ��� ��Ű���� �մ� ��� Ŭ������ ����
 *       => �α� 
 *       within("��Ű����.*")
 *       
 *       => ��� �� Ŭ���� => * ��Ű����.*Controller.*(..)
 */
public class DBAspect {
	private EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	// try ���� ��
	public void before()
	{
		dao.getConnection();
	}
	// finally
	public void after()
	{
		dao.disConnection();
	}
	
	// ������ ��� => After-Returning
	public void afterReturning(Object obj)
	{
		System.out.println("====== ����� �ڵ� ó�� ========");
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday()+" "
					+vo.getSal());
		}
	}
	// ���� => After-Throwing => catch
	public void afterThrowing(Throwable ex)
	{
		System.out.println("======= �����߻� ======");
		ex.printStackTrace();
		// Web => @ControllerAdvice : ���� ����ó��
	}
	// �ð� => Around => Ʈ����� / ����(�̹� AOP�� ���۵�) / �α�
	public Object around(ProceedingJoinPoint jp)
	throws Throwable
	{
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("ȣ��� �޼ҵ�:"+jp.getSignature().getName());
		// ����ڰ� ȣ���� �޼ҵ� 
		// �޼ҵ� ȣ��
		obj=jp.proceed();// dao.empListData() => invoke()
		long end=System.currentTimeMillis();
		System.out.println("����ð�:"+(end-start));
		
		return obj;
	}
}
