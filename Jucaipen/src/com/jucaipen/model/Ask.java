package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator              --------------------数据已更新     5.18
 *
 *  提问
 */
@SuppressWarnings("serial")
public class Ask implements Serializable{
	/**
	 * 提问当前页数
	 */
	private int page;
	/**
	 * 提问总页数
	 */
	private int totlePage;
	/**
	 *  提问id
	 */
	private int id;
	/**
	 * 提问用户id
	 */
	private int userId;
	/**
	 *  追提问id 追问有效
	 */
	private int parentId;
	/**
	 * 提问内容
	 */
	private String askBody;
	/**
	 * 提问时间
	 */
	private String askDate;
	/**
	 * 提问状态
	 */
	private int askState;
	/**
	 * 点击数
	 */
	private int hits;
	/**
	 * 是否恢复
	 */
	private int isReply;
	/**
	 * 关联新闻id
	 */
	private int classId;
	/**
	 * 被提问老师id
	 */
	private int teacherId;
	/**
	 *  提问者ip
	 */
	private String ip;
	/**
	 *   0 免费   1  收费
	 */
	private int isPay;
	/**
	 *  支付聚财币
	 */
	private int jucaiBills;
	/**
	 *  提问来源 （1、PC端，2、手机APP，3、手机网站）
	 */
	private int askFrom;
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
	public String getAskDate() {
		return askDate;
	}
	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}
	public int getAskState() {
		return askState;
	}
	public void setAskState(int askState) {
		this.askState = askState;
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
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getIsPay() {
		return isPay;
	}
	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}
	public int getJucaiBills() {
		return jucaiBills;
	}
	public void setJucaiBills(int jucaiBills) {
		this.jucaiBills = jucaiBills;
	}
	public int getAskFrom() {
		return askFrom;
	}
	public void setAskFrom(int askFrom) {
		this.askFrom = askFrom;
	}

}
