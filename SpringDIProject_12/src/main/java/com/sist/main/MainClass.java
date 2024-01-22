package com.sist.main;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *    ������̼� 
 *     = �޸� �Ҵ�(������)
 *       => ���������� ��ɺ��� �����ؼ� ��� 
 *       @Component : �Ϲ� Ŭ���� => ~Manager , MainClass
 *       @Repository: ����� => ~DAO
 *       @Service : DAO�������� �����ؼ� ��� , BI
 *                  => ����� �����ؼ� ��� 
 *                  => �ǹ������� ���� ���� ���Ǵ� ������̼� 
 *                  => ~Service
 *       @Controller : Model (��Ʈ����: ~Action)
 *                  => BoardController 
 *       @RestController : Model => �ڹٹٽ�ũ��Ʈ�� ���� 
 *         => VueJS 
 *       @ControllerAdivce : ��� ModelŬ������ ����ó��
 *       
 *       @Configuration:application.xml => �ڹٷ� ���� 
 *     = DI
 *       @Autowired => �������� ���ؼ� �ڵ����� ��ü�ּҸ� ���� 
 *       @PostConstructor => init-method
 *       @PreDestory  => detory-method
 *     
 */
class A
{
	public void display()
	{
		System.out.println("A:display Call..");
	}
}
class B
{
	public void display()
	{
		System.out.println("B:display Call..");
	}
}
class C
{
	public void display()
	{
		System.out.println("C:display Call..");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}