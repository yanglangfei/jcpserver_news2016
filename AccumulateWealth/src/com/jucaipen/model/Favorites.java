package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf          -------------�����Ѹ���
 * 
 *   �ղ� ��Ƶ  /֪ʶ
 *
 */
@SuppressWarnings("serial")
public class Favorites implements Serializable {
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
	 * ��Ƶ��֪ʶid
	 */
	private int fk_Id;
	
	private boolean isCharge;
	
	
	private boolean isSpecial;
	
	/**
	 *   �Ƿ���    0   ��    1   ��    2   ����
	 */
	private int isPurch;
	
	/**
	 * �ղ�ʱ��
	 */
	private String date;
	/**
	 * 1Ϊ�ղ���Ƶ 2Ϊ�ղ�֪ʶ
	 * 
	 * 
	 */
	private int type;
	
	
	
	
	public int getIsPurch() {
		return isPurch;
	}
	public void setIsPurch(int isPurch) {
		this.isPurch = isPurch;
	}
	public boolean isCharge() {
		return isCharge;
	}
	public void setCharge(boolean isCharge) {
		this.isCharge = isCharge;
	}
	public boolean isSpecial() {
		return isSpecial;
	}
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
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
	public int getFk_Id() {
		return fk_Id;
	}
	public void setFk_Id(int fk_Id) {
		this.fk_Id = fk_Id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
