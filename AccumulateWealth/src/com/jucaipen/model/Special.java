package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator ------------��������
 * 
 *         ר�� JCP_Special
 */
@SuppressWarnings("serial")
public class Special implements Serializable {
	private int page;
	private int totlePage;
	/**
	 * Id
	 */
	private int id;
	/**
	 *  SpecialName
	 */
	private String name;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  Description
	 */
	private String description;
	/**
	 *  SortId
	 */
	private int sortId;
	/**
	 *  IsDel  �Ƿ�ɾ����0������1��ɾ����
	 */
	private int isDel;
	
	/**
	 *  IsFree  �Ƿ�Ϊ����ר����1��2�ǣ� 
	 */
	private int isFree;
	/**
	 *  AmountMoney ����ר��Ӧ�����
	 */
	private int allMoney;
	/**
	 *  ShiFuMoney   ʵ��֧�����
	 */
	private int mothMoney;
	
	private int quarBills;
	
	private int yearBills;
	
	public int getQuarBills() {
		return quarBills;
	}
	public void setQuarBills(int quarBills) {
		this.quarBills = quarBills;
	}
	public int getYearBills() {
		return yearBills;
	}
	public void setYearBills(int yearBills) {
		this.yearBills = yearBills;
	}
	public void setAllMoney(int allMoney) {
		this.allMoney = allMoney;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getIsFree() {
		return isFree;
	}
	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}
	public double getAllMoney() {
		return allMoney;
	}
	public int getMothMoney() {
		return mothMoney;
	}
	public void setMothMoney(int mothMoney) {
		this.mothMoney = mothMoney;
	}
}