package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *         ��Ƶ����
 * 
 */
@SuppressWarnings("serial")
public class VideoType implements Serializable {
	/**
	 *   ��Ƶid
	 */
	private int typeId;
	/**
	 *  �ϼ�����id
	 */
	private int parentId;
	/**
	 *   �ؼ���
	 */
	private String keyWord;
	/**
	 *   ����
	 */
	private String descript;
	/**
	 *  ��������
	 */
	private String typeName;
	/**
	 *   ����id
	 */
	private int sortId;
	/**
	 * �Ƿ�ɾ����������ɾ������������������
	 */
	private int isDelete;

	public VideoType(String typeName, int typeId) {
		this.typeName = typeName;
		this.typeId = typeId;
	}
	

	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
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


	public int getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}


	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

}
