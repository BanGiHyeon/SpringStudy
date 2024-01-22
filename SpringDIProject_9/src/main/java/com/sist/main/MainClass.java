package com.sist.main;
/*
 *    1. XML ���� =====> XML���� ����
 *    2. Annotation ===> ���������� ����� ����
 *       => �о�ȭ (���� ���� ���)
 *       Annotation
 *         => ����� ���� Ŭ����
 *         => ���̺귯�� Ŭ���� (������̼��� ����) => ���
 *    3. ����� Ŭ������ ������̼� �̿�
 *       ���̺귯�� Ŭ���� XML => ������
 *    =============================================
 *    4���� ���� => 5���� �������� (�ڹ�) => 6���� �л�ó�� 
 *                                      | MSA (Spring Cloud)
 *                =================================
 *                    | ���� (��� ���� => �ڹ�)
 *    ������ 
 *     => Ʋ (���α׷� ������ ���� => ��� �����ڰ� ������ ����)
 *        => ���� ���� (������ ����) => ������ ��ũ 
 *     => ���� ���� 
 *        1. DI => ��ü ���� 
 *                 ------- ��ü �����ÿ� �ʿ��� �����͸� ���� 
 *                         ������� �ʱ�ȭ
 *                         = setXxx()
 *                         = ������ 
 *                 ------- �����ڰ� ��� 
 *                 -------
 *                 ��ü �Ҹ� 
 *                 ============== �����̳� (����)
 *        2. �ߺ� �ڵ� 
 *             => OOP���� ���� (�ڵ� ȣ���� �ȵȴ�)
 *                => �ߺ� �ڵ� (�޼ҵ�,�޼ҵ� ������ => Ŭ����)
 *             => �ڵ� ȣ���� ���� 
 *             => AOP => �ܾ� 
 *                Before / After / After-Returning / After-Throwing
 *                ���� , JoinPointer , PointCut
 *                aaa()
 *                bbb()
 *                ccc()
 *                public void display()
 *                {
 *                    try
 *                    {
 *                        Before => aaa()
 *                    }carch(Exception ex)
 *                    {
 *                        @ After-Throwing ==> ccc()
 *                    }
 *                    finally
 *                    {
 *                        @ After ==> bbb()
 *                    }
 *                    @ After-Returning
 *                    return "";
 *                }
 *     ============================================================
 *     1. Application
 *     2. WebApplication (MVC)
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
        EmpDAO dao=(EmpDAO)app.getBean("empDAO");// DL/DI
        List<EmpVO> list=dao.empDeptJoinData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEmpno()+" "
        			+vo.getEname()+" "
        			+vo.getJob()+" "
        			+vo.getDbday()+" "
        			+vo.getSal()+" "
        			+vo.getDvo().getDname()+" "
        			+vo.getDvo().getLoc());
        }
	}

}







