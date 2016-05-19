package com.jucaipen.model;

/**
 * @author Administrator
 *
 *
 *   ���bean
 */
public class Advertive {
	/**
	 *   ���id
	 */
	private int id;
	/**
	 * �����õ�id
	 */
	private int typeId;
	/**
	 *  ����
	 */
	private String title;
	/**
	 * ���� URL
	 */
	private String linkUrl;
	/**
	 * ͼƬURL
	 */
	private String imageUrl;
	/**
	 * ����
	 */
	private int sortId;
	public Advertive(int id, int typeId, String title, String linkUrl,
			String imageUrl, int sortId) {
		this.id = id;
		this.typeId = typeId;
		this.title = title;
		this.linkUrl = linkUrl;
		this.imageUrl = imageUrl;
		this.sortId = sortId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	
	
	

}
