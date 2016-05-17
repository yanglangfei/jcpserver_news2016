package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *   ��ʦ�ظ�
 */
@SuppressWarnings("serial")
public class Answer implements Serializable{
	/**
	 * ��ǰҳ��
	 */
	private int page;
	/**
	 * ��ҳ��
	 */
	private int totlePage;
	/**
	 * id
	 */
	private int id;
	/**
	 * �ش���������
	 */
	private String answerBody;
	/**
	 * ��ʦid
	 */
	private int teacherId;
	/**
	 * �ش�����ʱ��
	 */
	private String answerDate;
	/**
	 * ����
	 */
	private String remark;
	/**
	 * �ش������id
	 */
	private int askId;
	/**
	 * ����
	 */
	private int pingFen;
	
	public Answer() {
		super();
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
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getAskId() {
		return askId;
	}
	public void setAskId(int askId) {
		this.askId = askId;
	}
	public int getPingFen() {
		return pingFen;
	}
	public void setPingFen(int pingFen) {
		this.pingFen = pingFen;
	}
	
	
	
	
	

}
