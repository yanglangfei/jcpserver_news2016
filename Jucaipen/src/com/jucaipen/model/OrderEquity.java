package com.jucaipen.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author ylf
 * 
 *   ԤԼ��Ȩ
 *
 */
@SuppressWarnings("serial")
public class OrderEquity implements Serializable{
	/**
	 * ԤԼ��Ȩ��ǰҳ
	 */
	private int pager;
	/**
	 * ԤԼ��Ȩ��ҳ��
	 */
	private int totlePager;
	/**
	 * ԤԼid
	 */
	private int id;
	/**
	 * ԤԼ�û�id
	 */
	private int uId;
	/**
	 * ԤԼ�û���ʵ����
	 */
	private String trueName;
	/**
	 * ԤԼ�û��ֻ�����
	 */
	private String mobileNum;
	/**
	 * ԤԼ��Ȩ����
	 */
	private String remark;
	/**
	 * ԤԼ��Ȩʱ��
	 */
	private String insertDate;
	/**
	 * ԤԼ��ȨͶ�ʽ��
	 */
	private String touziMoney;
	/**
	 * ԤԼ��Ȩid
	 */
	private int eId;
	/**
	 * ԤԼ�˵�¼�豸ip
	 */
	private String uIp;
	/**
	 * ԤԼʱ��
	 */
	private Date orderDate;
	/**
	 *  ԤԼ����  1  ��ȨԤԼ    2  ˽ļԤԼ
	 */
	private int orderType;
	
	
	
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderEquity() {
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
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getTouziMoney() {
		return touziMoney;
	}
	public void setTouziMoney(String touziMoney) {
		this.touziMoney = touziMoney;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String getuIp() {
		return uIp;
	}
	public void setuIp(String uIp) {
		this.uIp = uIp;
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
