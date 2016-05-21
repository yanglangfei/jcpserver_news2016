package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  -------------新增数据 
 *
 *   我的礼品 (赠送 收到礼品记录)            JCP_MyLiPin
 */
@SuppressWarnings("serial")
public class MyGifts implements Serializable{
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  FK_SendUserId
	 */
	private int senderId;
	/**
	 *  FK_ReceiveUserId
	 */
	private int receiverId;
	/**
	 *  FK_LiPinId
	 */
	private int giftId;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  SortId
	 */
	private int sortId;
	/**
	 *   礼品数量    LiPinNum
	 */
	private int giftNum;
	/**
	 *  描述   ReMark
	 */
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public int getGiftId() {
		return giftId;
	}
	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getGiftNum() {
		return giftNum;
	}
	public void setGiftNum(int giftNum) {
		this.giftNum = giftNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
