package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   ��������
 */
@SuppressWarnings("serial")
public class NewsComment implements Serializable {
	/**
	 * ����������ҳ��
	 */
	private int totlePager;
	
	/**
	 * �������۵�ǰҳ��
	 */
	private int pager;
	/**
	 * ����id
	 */
	private int id;
	/**
	 * �û�id
	 */
	private int uId;
	/**
	 *   parentId
	 */
	private int pId;
	/**
	 * ����id
	 */
	private int nId;
	/**
	 * ��������
	 */
	private String bodys;
	/**
	 * ����ʱ��
	 */
	private String insertDate;
	/**
	 * ��������
	 */
	private int goodNum;
	/**
	 * �Ƿ���ʾ��0 ����ʾ   1��ʾ��
	 */
	private int isShow;
	/**
	 * �ظ�����
	 */
	private int repCount;
	/**
	 *   ���۷��� ---0   ��������    --- 1 ��Ƶ����
	 */
	private int CommType;
	
	public NewsComment() {
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
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
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
	public int getRepCount() {
		return repCount;
	}
	public void setRepCount(int repCount) {
		this.repCount = repCount;
	}
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

	public int getCommType() {
		return CommType;
	}

	public void setCommType(int commType) {
		CommType = commType;
	}
	
	
	

}
