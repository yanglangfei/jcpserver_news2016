package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *         �����б�
 * 
 */
@SuppressWarnings("serial")
public class ExpressionInfo implements Serializable {
	/**
	 * ����id
	 */
	private int id;
	/**
	 * ����id
	 */
	private int classId;
	/**
	 * ����
	 */
	private String Title;
	/**
	 * �������ӵ�ַ
	 */
	private String faceurl;
	/**
	 * ��������
	 */
	private int pxId;

	public ExpressionInfo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getFaceurl() {
		return faceurl;
	}

	public void setFaceurl(String faceurl) {
		this.faceurl = faceurl;
	}

	public int getPxId() {
		return pxId;
	}

	public void setPxId(int pxId) {
		this.pxId = pxId;
	}

}
