package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  -------------------��������
 *
 *   �ҵ���Ʒ(����ӵ�е�)   JCP_MyPresent
 */
@SuppressWarnings("serial")
public class MyPresent implements Serializable{
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  FK_UserId
	 */
	private int userId;
	/**
	 * ��Ʒ����
	 */
	private int presentNum;
	/**
	 *  FK_LiPinId
	 */
	private int presentId;
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
	public int getPresentNum() {
		return presentNum;
	}
	public void setPresentNum(int presentNum) {
		this.presentNum = presentNum;
	}
	public int getPresentId() {
		return presentId;
	}
	public void setPresentId(int presentId) {
		this.presentId = presentId;
	}
}
