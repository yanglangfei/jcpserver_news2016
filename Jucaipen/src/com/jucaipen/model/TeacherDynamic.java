package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator   --------------�����Ѹ���
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
	 * ������־ID��ֱ���۵�ID��ش�����ID
	 */
	private int relateId;
	/**
	 * ��̬���ͣ�0������־��1����ֱ���۵㣬2�ش����⣩
	 */
	private int type;
	/**
	 * ������̬ʱ��
	 */
	private String insertDate;
	/**
	 * ��ʦid
	 */
	private int teacherId;
	
	public TeacherDynamic(int id, int relateId, int type, String insertDate,
			int teacherId) {
		this.id = id;
		this.relateId = relateId;
		this.type = type;
		this.insertDate = insertDate;
		this.teacherId = teacherId;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

}
