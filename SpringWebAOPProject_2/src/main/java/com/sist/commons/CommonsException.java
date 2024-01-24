package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
/*
 *    AOP : ���� ��� (�������� ���Ǵ� �ҽ��� ��Ƽ� ����)
 *          ���� ���� , ����
 *          => OOP���� �Ұ����� ���� �߰��ؼ� ���� 
 *             ===
 *              | �ڵ� ȣ��(Callback) => �Ұ��� 
 *          => Callback => ���ϴ� ��ġ�� �����ϸ� ȣ���� ����
 *                         =========
 *                         1. �޼ҵ� ���� (������ �޼ҵ� => Target)
 *                         2. �޼ҵ��� ��ġ (JoinPint)
 *                            public void display()
 *                            {
 *                                @Before
 *                                => ������ �Լ� ȣ�� 
 *                                try
 *                                {
 *                                    => �α� / Ʈ�����
 *                                    ===============@Around
 *                                      �ٽ� 
 *                                    ===============@Around
 *                                }catch(Exception e)
 *                                {
 *                                    @AfterThrowing
 *                                    => @ControllerAdvice
 *                                }
 *                                finally
 *                                {
 *                                    @After
 *                                }
 *                                
 *                                return => @AfterReturning
 *                            }
 *                        PointCut+JoinPoint => Advice
 *                        Advice�� ������ => ���� ��� (Aspect)
 *     => PointCut : � �޼ҵ�
 *     => JoinPoint : �޼ҵ� ȣ�� ��ġ
 *     => Weaving : �����ش� (����)
 *     => Target : ��� �޼ҵ� 
 *     => Proxy : ������ �޼ҵ� ȣ�� (�븮��)
 *     => Advice : ���� ������
 *     => Aspect : ���� ��� 
 *     
 *     public void getConnection(){}
 *     public void disConnection(){}
 *     public void success(){}
 *     
 *     class A
 *     {
 *         public void list()
 *         {
 *             getConnection()
 *             ==============
 *              select���� �ҽ�
 *             ==============
 *             disConnection()
 *             success()
 *         }
 *         public void insert()
 *         {
 *             getConnection()
 *             ==============
 *              insert���� �ҽ�
 *             ==============
 *             disConnection()
 *             success()
 *         }
 *         public void update()
 *         {
 *             getConnection()
 *             ==============
 *              update���� �ҽ�
 *             ==============
 *             disConnection()
 *             success()
 *         }
 *     }
 */
@ControllerAdvice
public class CommonsException {
	
}
