package com.jucaipen.model;

import java.io.Serializable;
/**
 * @author ylf
 * 
 *   �ղع�Ȩ
 *
 */
@SuppressWarnings("serial")
public class EquityFavorites implements Serializable {
	/**
	 * �ղع�Ȩ��ǰҳ
	 */
	private int pager;
	/**
	 * �ղع�Ȩ��ҳ��
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
	 * ��Ȩid
	 */
	private int eId;
	/**
	 * �ղ�ʱ��
	 */
	private String date;
	
	public EquityFavorites() {
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
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
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
