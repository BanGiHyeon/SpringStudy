package com.sist.main;
import com.sist.dao.*;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
        CategoryDAO cDao=(CategoryDAO)app.getBean("cDao");
        FoodDAO fDao=(FoodDAO)app.getBean("fDao");
        List<CategoryVO> cList=cDao.foodCategoryData();
        for(CategoryVO vo:cList)
        {
        	System.out.println(vo.getCno()+"."+vo.getTitle());
        }
        System.out.println("==================");
        Scanner scan=new Scanner(System.in);
        System.out.print("ī�װ� ����(1~30)");
        int cno=scan.nextInt();
        List<FoodVO> fList=fDao.foodCategoryListData(cno);
        CategoryVO cvo=cDao.categoryInfoData(cno);
        System.out.println("==========================================");
        System.out.println(cvo.getTitle());
        System.out.println(cvo.getSubject());
        System.out.println("===========================================");
        for(FoodVO vo:fList)
        {
        	System.out.println(vo.getFno()+" "
        			+vo.getName()+" "
        			+vo.getAddress()+" "
        			+vo.getPhone()+" "
        			+vo.getType());
        }
        System.out.println("================");
        System.out.print("���� ����:");
        int fno=scan.nextInt();
        
        FoodVO vo=fDao.foodDetailData(fno);
        
        System.out.println("��ü��:"+vo.getName()+"("+vo.getScore()+")");
        System.out.println("�ּ�:"+vo.getAddress());
        System.out.println("��ȭ:"+vo.getPhone());
        System.out.println("���� ����:"+vo.getType());
        System.out.println("���ݴ�"+vo.getPrice());
        System.out.println("�����ð�:"+vo.getTime());
        System.out.println("����:"+vo.getParking());
        System.out.println("�޴�:"+vo.getMenu());
	}

}
