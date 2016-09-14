package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF     -----------------�����Ѹ���
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
	private int sortId;
	/**
	 *  �Ƿ�ɾ��    0��   1   ��
	 */
	private int isDel;
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
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
}
