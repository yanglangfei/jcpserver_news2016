package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator        ---------�����Ѹ���
 * 
 *   ֱ������
 *
 */
@SuppressWarnings("serial")
public class LiveMsg implements Serializable {
	/**
	 *  ��ǰҳ�� 
	 */
	private int page;
	/**
	 *  ��ҳ��
	 */
	private int totlePage;
	/**
	 *  ����id
	 */
	private int id;
	/**
	 * �û�id
	 */
	private int userId;
	/**
	 * ��������
	 */
	private String msgBodys;
	/**
	 * ���
	 */
	private int check;
	/**
	 * ֱ��id
	 */
	private int liveId;
	/**
	 * ����ʱ��
	 */
	private String insertDate;
	/**
	 *  ������id
	 */
	private int receiverId;
	/**
	 *  �Ƿ�ϵͳ����Ա
	 */
	private int isSysAdmin;
	/**
	 * �Ƿ񷿼����Ա
	 */
	private int isRoomAdmin;
	/**
	 * �û�ip
	 */
	private String ip;
	
	public LiveMsg( int id, int userId,
			String msgBodys, int check, int liveId, String insertDate,
			int receiverId, int isSysAdmin, int isRoomAdmin, String ip) {
		this.id = id;
		this.userId = userId;
		this.msgBodys = msgBodys;
		this.check = check;
		this.liveId = liveId;
		this.insertDate = insertDate;
		this.receiverId = receiverId;
		this.isSysAdmin = isSysAdmin;
		this.isRoomAdmin = isRoomAdmin;
		this.ip = ip;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
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
	public String getMsgBodys() {
		return msgBodys;
	}
	public void setMsgBodys(String msgBodys) {
		this.msgBodys = msgBodys;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
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
		return isRoomAdmin;
	}
	public void setIsRoomAdmin(int isRoomAdmin) {
		this.isRoomAdmin = isRoomAdmin;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	

}
