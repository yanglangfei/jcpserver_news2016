package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *   ��Ƶ����                  --------------------------�Ѹ���     5.18
 */
@SuppressWarnings("serial")
public class VideoClass implements Serializable{
	private int id;
	/**
	 *  �������
	 */
	private int typeTitle;
	/**
	 *  �ؼ���
	 */
	private String keyWord;
	/**
	 *  ����
	 */
	private String descript;
	/**
	 * ����id
	 */
	private int sortId;
	/**
	 * ����id
	 */
	private int parentId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeTitle() {
		return typeTitle;
	}
	public void setTypeTitle(int typeTitle) {
		this.typeTitle = typeTitle;
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
