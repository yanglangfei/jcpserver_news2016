package com.jucaipen.model;

import java.io.Serializable;

public class SharkDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private int id;
	/**
	 *   �û�id
	 */
	private int userId;
	/**
	 *   �񽱽��
	 */
	private int price;
	/**
	 *  ��;����1�ֻ���ҳ�ˣ�2�ֻ���׿�ˣ�3�ֻ�IOS�ˣ�
	 */
	private int pathWay;
	/**
	 *   ��ʱ��
	 */
	private String insertDate;
	/**
	 * ��ע
	 */
	private String remark;
	
	public SharkDetail() {
	}

	public SharkDetail(int id, int userId, int price, int pathWay,
			String insertDate, String remark) {
		this.id = id;
		this.userId = userId;
		this.price = price;
		this.pathWay = pathWay;
		this.insertDate = insertDate;
		this.remark = remark;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPathWay() {
		return pathWay;
	}

	public void setPathWay(int pathWay) {
		this.pathWay = pathWay;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
