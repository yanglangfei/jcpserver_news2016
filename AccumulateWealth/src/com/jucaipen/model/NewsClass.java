package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF         -------------�����Ѹ���
 * 
 *   �����ܷ���
 *
 */
@SuppressWarnings("serial")
public class NewsClass implements Serializable{
	/**
	 * �ܷ���id
	 */
	private int id;
	/**
	 * �ܷ�������
	 */
	private String className;
	/**
	 * �ؼ���
	 */
	private String keyWord;
	/**
	 * ����
	 */
	private String descript;
	/**
	 * ����id
	 */
	private int sortId;
	/**
	 *   ���ӵ�ַ
	 */
	private String linkUrl;
	/**
	 *  ����id
	 */
	private int parentId;
	
	
	public NewsClass(int id, String className, String keyWord,
			String descript, String linkUrl, int sortId) {
		this.id = id;
		this.className = className;
		this.keyWord = keyWord;
		this.linkUrl=linkUrl;
		this.descript = descript;
		this.sortId = sortId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	
	

}
