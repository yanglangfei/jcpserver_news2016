package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf      -------------�����Ѹ���   JCP_LogOrLive_Comm
 * 
 *   �۵㡢����ֱ�� ����      
 */
@SuppressWarnings("serial")
public class Comment implements Serializable {
	/**
	 * ������ҳ��
	 */
	private int totlePager;
	
	/**
	 * ���۵�ǰҳ��
	 */
	private int pager;
	/**
	 * ����id
	 */
	private int id;
	/**
	 * �û�id
	 */
	private int userId;
	/**
	 * ��������
	 */
	private String bodys;
	/**
	 * �������ͣ�1�۵���־��2����ֱ����
	 */
	private int commType;
	/**
	 * ����ʱ��
	 */
	private String insertDate;
	/**
	 * �Ƿ���ʾ��1����ʾ   2��ʾ��
	 */
	private int isShow;
	/**
	 * ��������
	 */
	private int goods;
	/**
	 * �ظ�����
	 */
	private int repCount;
	/**
	 *  �۵������ֱ��id
	 */
	private int logOrLiveId;
	/**
	 *   �ظ����۵�id
	 */
	private int parentId;
	public int getTotlePager() {
		return totlePager;
	}
	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
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
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public int getCommType() {
		return commType;
	}
	public void setCommType(int commType) {
		this.commType = commType;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getRepCount() {
		return repCount;
	}
	public void setRepCount(int repCount) {
		this.repCount = repCount;
	}
	public int getLogOrLiveId() {
		return logOrLiveId;
	}
	public void setLogOrLiveId(int logOrLiveId) {
		this.logOrLiveId = logOrLiveId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
