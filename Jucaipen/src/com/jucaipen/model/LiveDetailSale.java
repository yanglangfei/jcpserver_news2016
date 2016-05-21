package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator   ------------------------��������
 *
 *   ��������ֱ����Ϣ   JCP_LiveDetailSale
 */
@SuppressWarnings("serial")
public class LiveDetailSale implements Serializable{
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  FK_UserId
	 */
	private int userId;
	/**
	 * ������ʦ  FK_TearchId
	 */
	private int teacherId;
	/**
	 *  �������  OrderCode
	 */
	private String orderCode;
	/**
	 *   ֱ���۵�id  FK_LiveDetailId
	 */
	private int liveDetailId;
	/**
	 *  InsertDate
	 */
	private String insertDate;
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
	public int getLiveDetailId() {
		return liveDetailId;
	}
	public void setLiveDetailId(int liveDetailId) {
		this.liveDetailId = liveDetailId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

}
