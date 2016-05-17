package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ֱ������
 *
 */
@SuppressWarnings("serial")
public class LiveInteractive implements Serializable {
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
	 * ֱ��id
	 */
	private int liveId;
	/**
	 * �û�id
	 */
	private int userId;
	/**
	 *  �豸����  ��1����վPC��2���ֻ���վ��3��ֱ����PC��4��ֱ�����ֻ���5��APP��
	 */
	private int deviceType;
	/**
	 * ����ʱ��
	 */
	private String insertDate;
	/**
	 * ��������
	 */
	private String bodys;
	/**
	 * �Ƿ���ʾ
	 */
	private int isShow;
	/**
	 * �û�ip
	 */
	private String ip;
	/**
	 * �ϼ�����id
	 */
	private int parentaId;
	
	public LiveInteractive(int id, int liveId, int userId, int deviceType,
			String insertDate, String bodys, int isShow, String ip,
			int parentaId) {
		this.id = id;
		this.liveId = liveId;
		this.userId = userId;
		this.deviceType = deviceType;
		this.insertDate = insertDate;
		this.bodys = bodys;
		this.isShow = isShow;
		this.ip = ip;
		this.parentaId = parentaId;
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
	public int getLiveId() {
		return liveId;
	}
	public void setLiveId(int liveId) {
		this.liveId = liveId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getParentaId() {
		return parentaId;
	}
	public void setParentaId(int parentaId) {
		this.parentaId = parentaId;
	}
	
	
	

}
