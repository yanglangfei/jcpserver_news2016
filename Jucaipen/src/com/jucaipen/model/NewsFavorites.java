package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   �ղ�����
 *
 */
@SuppressWarnings("serial")
public class NewsFavorites implements Serializable {
	/**
	 *  �����ղص�ǰҳ
	 */
	private int pager;
	/**
	 *  �����ղ���Ϣ��ҳ��
	 */
	private int totlePager;
	/**
	 * �ղ�id
	 */
	private int id;
	/**
	 * �ղ���id
	 */
	private int uId;
	/**
	 * ����id
	 */
	private int nId;
	/**
	 * �ղ�ʱ��
	 */
	private String date;
	
	public NewsFavorites() {
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
