package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
 *  ���Ŷ�������
 */
@SuppressWarnings("serial")
public class NewsSmallClass implements Serializable{
	/**
	 * ��������id
	 */
	private int id;
	/**
	 * ��������������һ������id
	 */
	private int BigId;
	/**
	 * ������������
	 */
	private String samllName;
	/**
	 * �ؼ���
	 */
	private String keyWord;
	/**
	 * ����
	 */
	private String descript;
	/**
	 * ģ��·��
	 */
	private String templeteName;
	/**
	 * �ļ�·��
	 */
	private String filePath;
	/**
	 * ����id
	 */
	private int pxId;
	/**
	 *  ���ӵ�ַ
	 */
	private String linkUrl;
	
	
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public NewsSmallClass(int id,String samllName) {
		this.id = id;
		this.samllName = samllName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBigId() {
		return BigId;
	}
	public void setBigId(int bigId) {
		BigId = bigId;
	}
	public String getSamllName() {
		return samllName;
	}
	public void setSamllName(String samllName) {
		this.samllName = samllName;
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
	public String getTempleteName() {
		return templeteName;
	}
	public void setTempleteName(String templeteName) {
		this.templeteName = templeteName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	
	

}
