package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *    ֱ������״��
 *
 */
@SuppressWarnings("serial")
public class TxtLiveSale implements Serializable{
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
	private int liveId;
	/**
	 *    ��������ʱ��
	 */
	private String insertDate;
	public TxtLiveSale(int id, int userId, int teacherId, String orderCode,
			int liveId, String insertDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.teacherId = teacherId;
		this.orderCode = orderCode;
		this.liveId = liveId;
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
	public int getLiveId() {
		return liveId;
	}
	public void setLiveId(int liveId) {
		this.liveId = liveId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	
	

}
