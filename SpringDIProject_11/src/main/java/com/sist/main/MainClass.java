package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
@Component
/*
 *    @Component
 *      => ��� ��ġ ==> Ŭ�������� ���� 
 *    @Autowired ==> CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE
 *    
 *    class A
 *    {
 *       @
 *       B b
 *       @
 *       public A(){}
 *       @
 *       public void display(){}
 *       @
 *       public void A(B b){}
 *    }
 */
public class MainClass {
	// @Autowired + @Qualifier = @Resource(1.8)
	@Autowired
	@Qualifier("memberDAO")// Ư�� ��ü ���ý� ��� 
	private OracleDB ob;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
        MainClass mc=(MainClass)app.getBean("mainClass");
        mc.ob.display();
	}

}
