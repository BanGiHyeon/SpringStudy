package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 *   DI �����ֱ�
 *   1. �����̳� ���� => ApplicationContext
 *   2. XML/Annotation => ����� (��ü ����) => � ��ü ���� 
 *      VO , MainClass => ����
 *   3. ���� (setter,constructor)
 *   4. �ʱ�ȭ �ݹ� => init-method
 *   5. ���α׷��Ӱ� ��� 
 *   6. �Ҹ� => �ݹ� destroy-method
 *   7. ������ ���� 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericApplicationContext app=new GenericXmlApplicationContext("app.xml");
		Sawon sa=(Sawon)app.getBean("sa");
		sa.print();
		app.close();
	}
}
