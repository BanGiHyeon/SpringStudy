package com.sist.main;
/*
 *   @Autowired : �ݵ�� ���������� �޸� �Ҵ��� �ؾ� �ڵ� ������ ����
 *   
 *   class A
 *   {
 *      @Autowired
 *      B b; ==> null
 *   }
 *   @Component
 *   class B
 *   {
 *      @Autowired
 *      A a; ==> �ּ�
 *   }
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.service.FoodService;
public class MainClass2 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("application-*.xml");
        //FoodDAO fDao=(FoodDAO)app.getBean("fDao");
        FoodService fDao=(FoodService)app.getBean("fs");
        Scanner scan=new Scanner(System.in);
        System.out.print("1.��ü��,2.�ּ�,3.�������� ����:");
        int col=scan.nextInt();
        String fd="";
        String[] temp={"","name","address","type"};
        fd=temp[col];
        System.out.print("�˻��� �Է�:");
        String ss=scan.next();
        
        Map map=new HashMap();
        map.put("col_name", fd);
        map.put("ss", ss);
        
        List<FoodVO> list=fDao.foodFindData(map);
        
        for(FoodVO vo:list)
        {
        	System.out.println(vo.getFno()+" "
                     +vo.getName()+" "
                     +vo.getAddress()+" "
                     +vo.getType());
        }
        System.out.println("=============================");
        List<FoodVO> list2=fDao.foodFindData2("��", "����");
        for(FoodVO vo:list2)
        {
        	System.out.println(vo.getFno()+" "
                     +vo.getName()+" "
                     +vo.getAddress());
        }
        
	}

}