package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *    ���������Ϣ
 */
@SuppressWarnings("serial")
public class ExpressionType implements Serializable {
	/**
	 *   �������id
	 */
	private int id;
	/**
	 *  ��������
	 */
	private String className;
	/**
	 *  ����
	 */
	private int pxId;
	public ExpressionType() {
		super();
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
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	

}
