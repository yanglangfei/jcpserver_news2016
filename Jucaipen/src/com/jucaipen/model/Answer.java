package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator         ----------------数据已更新
 *
 *   教师回复
 */
@SuppressWarnings("serial")
public class Answer implements Serializable{
	/**
	 * 当前页数
	 */
	private int page;
	/**
	 * 总页数
	 */
	private int totlePage;
	/**
	 * id
	 */
	private int id;
	/**
	 * 回答问题内容
	 */
	private String answerBody;
	/**
	 * 讲师id
	 */
	private int teacherId;
	/**
	 * 回答问题的id
	 */
	private int askId;
	/**
	 * 回答问题时间
	 */
	private String answerDate;
	/**
	 * 评分   满分为5分
	 */
	private int grade;
	/**
	 *  是否采纳   0  否   1  是
	 */
	private int isCatch;
	/**
	 *  私密部分
	 */
	private String privateBody;
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
	public int getAskId() {
		return askId;
	}
	public void setAskId(int askId) {
		this.askId = askId;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getIsCatch() {
		return isCatch;
	}
	public void setIsCatch(int isCatch) {
		this.isCatch = isCatch;
	}
	public String getPrivateBody() {
		return privateBody;
	}
	public void setPrivateBody(String privateBody) {
		this.privateBody = privateBody;
	}
}
