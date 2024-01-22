package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
        SeoulDAO dao=(SeoulDAO)app.getBean("dao");
        
        List<SeoulVO> list=dao.natureListData();
        for(SeoulVO vo:list)
        {
        	System.out.println(vo.getNo()+"."+vo.getTitle());
        }
        System.out.println("=============================");
        Scanner scan=new Scanner(System.in);
        System.out.print("��ȣ �Է�:");
        int no=scan.nextInt();
        SeoulVO vo=dao.natureDetailData(no);
        System.out.println("��ȣ:"+vo.getNo());
        System.out.println("���:"+vo.getTitle());
        System.out.println("�ּ�:"+vo.getAddress());
        System.out.println("�Ұ�:"+vo.getMsg());
        System.out.println("=============================");
        System.out.println("�˻��� �Է�:");
        String title=scan.next();
        List<SeoulVO> fList=dao.natureFindData(title);
        for(SeoulVO fvo:fList)
        {
        	System.out.println(fvo.getNo()+"."+fvo.getTitle());
        }
	}

}
