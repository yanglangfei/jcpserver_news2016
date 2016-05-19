package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator     ------------�����Ѹ���
 *
 *    �۵�������Ϣ
 *
 */
@SuppressWarnings("serial")
public class IdeaSale implements Serializable{
	private int id;
	/**
	 *   �����û�id 
	 */
	private int userId;
	/**
	 *  ֱ����ʦid
	 */
	private int teacherId;
	/**
	 * ������
	 */
	private String orderCode;
	/**
	 *   ֱ��id
	 */
	private int logId;
	/**
	 *    ��������ʱ��
	 */
	private String insertDate;
	public IdeaSale(int id, int userId, int teacherId, String orderCode,
			int logId, String insertDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.teacherId = teacherId;
		this.orderCode = orderCode;
		this.logId = logId;
		this.insertDate = insertDate;
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
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getLogId() {
		return logId;
	}
	public void setLiveId(int logId) {
		this.logId = logId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	
	

}
