package com.sist.main;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.config.CustomerConfig;
import com.sist.config.DataBaseConfig;
import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class[] cls= {CustomerConfig.class,DataBaseConfig.class};
        //ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
        FoodDAO dao=(FoodDAO)app.getBean("fDao");
        Scanner scan=new Scanner(System.in);
        while(true)
        {
        	System.out.println("===== Menu =====");
        	System.out.println("1.�̸�");
        	System.out.println("2.�ּ�");
        	System.out.println("3.��������");
        	System.out.println("4.�̸�+�ּ�");
        	System.out.println("5.�̸�+��������");
        	System.out.println("6.�ּ�+��������");
        	System.out.println("7.�̸�+�ּ�+��������");
        	System.out.println("===================");
        	System.out.print("�޴� ����:");
        	int no=scan.nextInt();
        	String data="";
        	switch(no)
        	{
        	case 1: data="N";
        		break;
        	case 2: data="A";
        		break;
        	case 3: data="T";
        		break;
        	case 4: data="NA";
        		break;
        	case 5: data="NT";
        		break;
        	case 6: data="AT";
        		break;
        	case 7: data="NAT";
        		break;
        	default:
        		System.out.println("���α׷� ����");
        		System.exit(0);
        	}
        	String[] fsArr=data.split("");
        	Map map=new HashedMap();
        	System.out.print("�˻��� �Է�:");
        	String ss=scan.next();
        	map.put("fsArr", fsArr);
        	map.put("ss", ss);
        	List<FoodVO> list=dao.foodFindData(map);
        	for(FoodVO vo:list)
        	{
        		System.out.println(vo.getName()+" "
        				+vo.getAddress()+" "
        				+vo.getType());
        	}
	    }

     }
}