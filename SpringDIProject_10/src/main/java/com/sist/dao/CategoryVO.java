package com.sist.dao;
/*
 *   CNO                                       NOT NULL NUMBER(2)
	 TITLE                                     NOT NULL VARCHAR2(100)
	 SUBJECT                                   NOT NULL VARCHAR2(200)
	 POSTER                                    NOT NULL VARCHAR2(260)
	 LINK                                      NOT NULL VARCHAR2(100)
 */
public class CategoryVO {
	private int cno;
	private String title,subject;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
