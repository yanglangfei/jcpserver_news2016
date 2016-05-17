package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ��ʦ��̬
 *
 */
@SuppressWarnings("serial")
public class TeacherDynamic implements Serializable{
	/**
	 *  ��ʦ��̬id
	 */
	private int id;
	/**
	 * ��ʦ����id ������־ID���ش�ID��ֱ������ID
	 */
	private int relateId;
	/**
	 * ��ʦ��������  0��ʾ����ֱ����1��ʾ������־��2��ʾ�ش�����
	 */
	private int relateType;
	/**
	 * ������̬ʱ��
	 */
	private String insertDate;
	
	public TeacherDynamic(int id, int relateId, int relateType,
			String insertDate) {
		this.id = id;
		this.relateId = relateId;
		this.relateType = relateType;
		this.insertDate = insertDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRelateId() {
		return relateId;
	}
	public void setRelateId(int relateId) {
		this.relateId = relateId;
	}
	public int getRelateType() {
		return relateType;
	}
	public void setRelateType(int relateType) {
		this.relateType = relateType;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	
	

}
