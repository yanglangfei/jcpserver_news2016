package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ��ע��ʦ
 *
 */
@SuppressWarnings("serial")
public class TeacherAttention implements Serializable{
	/**
	 * ��ҳ��
	 */
	private int totlePage;
	/**
	 *  ��ǰҳ��
	 */
	private int page;
	/**
	 * ��עid
	 */
	private int id;
	/**
	 * ��ע�û�
	 */
	private int userId;
	/**
	 * ��ע�Ľ�ʦid
	 */
	private int teacherId;
	public TeacherAttention(int id, int userId, int teacherId) {
		super();
		this.id = id;
		this.userId = userId;
		this.teacherId = teacherId;
	}
	
	public int getTotlePage() {
		return totlePage;
	}

	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
	

}
