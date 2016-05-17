package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   �������ۻظ�
 *
 */
@SuppressWarnings("serial")
public class NewsCommRes implements Serializable {
	/**
	 *  �������ۻظ���ǰҳ
	 */
	private int pager;
	/**
	 *  �������ۻظ���ҳ��
	 */
	private int totlePager;
	/**
	 * �ظ�id
	 */
	private int id;
	/**
	 * �ظ��û�id
	 */
	private int uId;
	/**
	 * ����id
	 */
	private int nId;
	/**
	 * ����id
	 */
	private int commId;
	/**
	 * ��Ӧ����
	 */
	private String bodys;
	/**
	 * ��Ӧʱ��
	 */
	private String insertDate;
	/**
	 * ��������
	 */
	private int goodNum;
	/**
	 * �Ƿ���ʾ�� 0 ����ʾ  1 ��ʾ��
	 */
	private int isShow;
	
	public NewsCommRes(int id, int uId, int nId, int commId, String bodys,
			String insertDate, int goodNum, int isShow) {
		this.id = id;
		this.uId = uId;
		this.nId = nId;
		this.commId = commId;
		this.bodys = bodys;
		this.insertDate = insertDate;
		this.goodNum = goodNum;
		this.isShow = isShow;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public int getCommId() {
		return commId;
	}
	public void setCommId(int commId) {
		this.commId = commId;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}
	public int getTotlePager() {
		return totlePager;
	}
	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}

}
