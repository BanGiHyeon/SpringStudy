package com.sist.main;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Sawon implements InitializingBean,DisposableBean,BeanNameAware{
	private int sabun;
	private String name;
	private String dept;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
	    System.out.println("setSabun() Call...");
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setName() Call...");
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		System.out.println("setDept() Call...");
		this.dept = dept;
	}
	
	public void print()
	{
		System.out.println("���:"+sabun);
		System.out.println("�̸�:"+name);
		System.out.println("�μ�:"+dept);
	}
	// init-method
	public void init()
	{
		System.out.println("=== ��� ���� =======");
	}
	// destroy-method
	public void destroy()
	{
		System.out.println("=== ��ü �Ҹ� ====");
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("�� �̸� ����=> Map�� ����");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Setter���� �Ϸ�");
	}
}
