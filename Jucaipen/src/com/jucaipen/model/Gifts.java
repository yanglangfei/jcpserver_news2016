package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator   -------------------��������
 *
 *  ��Ʒ �̵�    JCP_LiPin 
 */
@SuppressWarnings("serial")
public class Gifts implements Serializable{
	/**
	 *  ��ǰҳ�� 
	 */
	private int page;
	/**
	 *  ��ҳ��
	 */
	private int totlePage;
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  ��Ʒ����  Title
	 */
	private String title;
	/**
	 * ��Ʒ����  ClassId
	 */
	private int classId;
	/**
	 *  ��Ʒ�۸�  Price
	 */
	private double price;
	/**
	 *  ��λ  Company
	 */
	private String company;
	/**
	 * ����ͼ Thumbnail
	 */
	private String thumbnail;
	/**
	 * ԭʼͼ   ImagesUrl
	 */
	private String imageUrl;
	/**
	 *  ����  Bodys
	 */
	private String desc;
	/**
	 *  ��������  SaleCount
	 */
	private int saleCount;
	/**
	 * ����״̬��1���������ۣ�2����ͣ���ۣ�3�����޿�棩   SaleType
	 */
	private int saleState;
	/**
	 * �Ƿ�ɾ��(0������1��ɾ����  IsDel
	 */
	private int isDel;
	/**
	 *  �Ƿ��ö���0���ö���1�ö���  IsTop
	 */
	private int isTop;
	/**
	 * �Ƿ��Ƽ���0���Ƽ���1�Ƽ���   IsTuiJian
	 */
	private int isRecomm;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public int getSaleState() {
		return saleState;
	}
	public void setSaleState(int saleState) {
		this.saleState = saleState;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getIsTop() {
		return isTop;
	}
	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}
	public int getIsRecomm() {
		return isRecomm;
	}
	public void setIsRecomm(int isRecomm) {
		this.isRecomm = isRecomm;
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
}
