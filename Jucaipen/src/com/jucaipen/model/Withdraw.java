package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator ----------��������
 * 
 *         ���� JCP_TiXian
 */
@SuppressWarnings("serial")
public class Withdraw implements Serializable {
	/**
	 * Id
	 */
	private int id;
	/**
	 *  OrderCode
	 */
	private String orderCode;
	/**
	 *  UserId
	 */
	private int userId;
	/**
	 *  �����˺�  BankCode
	 */
	private String bankCode;
	/**
	 *  BankType  �˺����ͣ�1֧������2���У�0���У�
	 */
	private int bankType;
	/**
	 *  �������� BankUserTrueName
	 */
	private String bankUserTrueName;
	/**
	 *  ��������  BankName
	 */
	private String bankName;
	/**
	 *  ���ֽ��
	 */
	private double outMoney;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  Type  ״̬:0Ϊ����,1Ϊ�������δ���,2���ֳɹ�,3����ʧ��
	 */
	private int type;
	/**
	 *  ShenHeDate  ���ʱ��
	 */
	private String checkDate;
	/**
	 *  IsPay  �Ƿ��Ѿ��۳����˻����0��δ�۳�,1�Ѿ��۳�
	 */
	private int isPay;
	/**
	 *  IsDel  0��ʾ������1��ʾ�û�ɾ����2��ʾ�ͷ�ɾ��
	 */
	private int isDel;
	/**
	 *  Remark  
	 */
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public int getBankType() {
		return bankType;
	}
	public void setBankType(int bankType) {
		this.bankType = bankType;
	}
	public String getBankUserTrueName() {
		return bankUserTrueName;
	}
	public void setBankUserTrueName(String bankUserTrueName) {
		this.bankUserTrueName = bankUserTrueName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getOutMoney() {
		return outMoney;
	}
	public void setOutMoney(double outMoney) {
		this.outMoney = outMoney;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public int getIsPay() {
		return isPay;
	}
	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
