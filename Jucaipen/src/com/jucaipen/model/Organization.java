package com.jucaipen.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ylf
 * 
 *   �۲������
 *
 */
@SuppressWarnings("serial")
public class Organization implements Serializable {
	/**
	 * ��֯������ǰҳ
	 */
	private int pager;
	/**
	 * ��֯������ҳ��
	 */
	private int totlePager;
	/**
	 * ����id
	 */
	private int id;
	/**
	 * ��������
	 */
	private String name;
	/**
	 * Ӣ������
	 */
	private String nameEn;
	/**
	 * �������
	 */
	private String simpleName;
	/**
	 * ����ʱ��
	 */
	private Date createDate;
	/**
	 * ��������
	 */
	private String quality;
	/**
	 * Ͷ������
	 */
	private String investmentArea;
	/**
	 * ����logo
	 */
	private String logo;
	/**
	 * ��������
	 */
	private String descript;
	/**
	 * ��������ʱ��
	 */
	private Date insertDate;
	/**
	 * ����
	 */
	private int sortId;
	

	public Organization(int id, String name, String nameEn, String simpleName,
			Date createDate, String quality, String investmentArea,
			String logo, String descript, Date insertDate, int sortId) {
		this.id = id;
		this.name = name;
		this.nameEn = nameEn;
		this.simpleName = simpleName;
		this.createDate = createDate;
		this.quality = quality;
		this.investmentArea = investmentArea;
		this.logo = logo;
		this.descript = descript;
		this.insertDate = insertDate;
		this.sortId = sortId;
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
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getInvestmentArea() {
		return investmentArea;
	}
	public void setInvestmentArea(String investmentArea) {
		this.investmentArea = investmentArea;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
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
