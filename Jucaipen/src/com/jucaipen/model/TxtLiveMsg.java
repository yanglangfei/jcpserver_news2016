package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  --------------数据已更新
 *
 *   文字直播交流区   JCP_TxtLive_Msg
 */
@SuppressWarnings("serial")
public class TxtLiveMsg implements Serializable{
	/** 
	 *  Id
	 */
	private int id;
	/**
	 *  UserId
	 */
	private int userId;
	/**
	 *  MessBody
	 */
	private String messBody;
	/**
	 * shenhe  审核
	 */  
	private int shenhe;
	/**
	 *  Fk_TxtLiveId
	 */
	private int txtLiveId;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  ReceiverId
	 */
	private int receiverId;
	/**
	 *  IsSysAdmin
	 */
	private int isSysAdmin;
	/**
	 *  IsRoomAdmin
	 */
	private int IsRoomAdmin;
	/**
	 *  IP
	 */
	private String ip;
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
	public String getMessBody() {
		return messBody;
	}
	public void setMessBody(String messBody) {
		this.messBody = messBody;
	}
	public int getShenhe() {
		return shenhe;
	}
	public void setShenhe(int shenhe) {
		this.shenhe = shenhe;
	}
	public int getTxtLiveId() {
		return txtLiveId;
	}
	public void setTxtLiveId(int txtLiveId) {
		this.txtLiveId = txtLiveId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public int getIsSysAdmin() {
		return isSysAdmin;
	}
	public void setIsSysAdmin(int isSysAdmin) {
		this.isSysAdmin = isSysAdmin;
	}
	public int getIsRoomAdmin() {
		return IsRoomAdmin;
	}
	public void setIsRoomAdmin(int isRoomAdmin) {
		IsRoomAdmin = isRoomAdmin;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

}
