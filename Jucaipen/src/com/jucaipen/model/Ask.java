package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *  ����
 */
@SuppressWarnings("serial")
public class Ask implements Serializable{
	/**
	 * ���ʵ�ǰҳ��
	 */
	private int page;
	/**
	 * ������ҳ��
	 */
	private int totlePage;
	/**
	 *  ����id
	 */
	private int id;
	/**
	 * �����û�id
	 */
	private int userId;
	private int parentId;
	/**
	 * ��������
	 */
	private String askBody;
	/**
	 * ����id
	 */
	private int classId;
	/**
	 * ����ʱ��
	 */
	private String askDate;
	/**
	 * �����
	 */
	private int hits;
	/**
	 * �Ƿ�ָ�
	 */
	private int isReply;
	/**
	 *  ������ip
	 */
	private String ip;
	/**
	 * ��������ʦid
	 */
	private int teacherId;
	/**
	 * ����״̬
	 */
	private int askState;
	public Ask() {
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


	public int getAskState() {
		return askState;
	}

	public void setAskState(int askState) {
		this.askState = askState;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getAskBody() {
		return askBody;
	}
	public void setAskBody(String askBody) {
		this.askBody = askBody;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getAskDate() {
		return askDate;
	}
	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getIsReply() {
		return isReply;
	}
	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
	
	

}
