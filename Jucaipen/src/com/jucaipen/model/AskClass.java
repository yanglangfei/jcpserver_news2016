package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * ���ʷ���
 */
@SuppressWarnings("serial")
public class AskClass implements Serializable{
	/**
	 * ����id
	 */
	private int id;
	/**
	 * ��������
	 */
	private String className;
	
	public AskClass(int id, String className) {
		super();
		this.id = id;
		this.className = className;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	

}
