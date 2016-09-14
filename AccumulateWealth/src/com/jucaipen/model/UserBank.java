package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  ---------------��������
 *
 *   JCP_User_Bank    ���п���Ϣ
 */
@SuppressWarnings("serial")
public class UserBank implements Serializable{
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  BankName
	 */
	private String bankName;
	/**
	 *  BankCode
	 */
	private String bankCode;
	/**
	 *  ����  BankUserTrueName
	 */
	private String bankUserTrueName;
	/**
	 *  ���֤��   BankIdCard
	 */
	private String bankIdCard;
	/**
	 *  Ԥ���ֻ���  BankMobile
	 */
	private String bankMobile;
	/**
	 *  UserId
	 */
	private int userId;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  Remark
	 */
	private String remark;
	/**
	 *  IsDel �Ƿ�ɾ����0������1��ɾ����
	 */
	private int isDel;
	/**
	 *   IsDefault  1Ĭ�ϣ�0����
	 */
	private int isDefault;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankUserTrueName() {
		return bankUserTrueName;
	}
	public void setBankUserTrueName(String bankUserTrueName) {
		this.bankUserTrueName = bankUserTrueName;
	}
	public String getBankIdCard() {
		return bankIdCard;
	}
	public void setBankIdCard(String bankIdCard) {
		this.bankIdCard = bankIdCard;
	}
	public String getBankMobile() {
		return bankMobile;
	}
	public void setBankMobile(String bankMobile) {
		this.bankMobile = bankMobile;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
}
