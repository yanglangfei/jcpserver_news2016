package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   文字直播信息              -----------------------数据已更新     5.18
 *
 */
@SuppressWarnings("serial")
public class TextLive implements Serializable{
	/**
	 * 文字直播当前页数
	 */
	private int page;
	/**
	 *  文字直播总页数
	 */
	private int totlePage;
	/**
	 * 直播id
	 */
	private int id;
	/**
	 * 直播标题
	 */
	private String title;
	/**
	 * 开始时间
	 */
	private String startDate;
	/**
	 * 结束时间
	 */
	private String endDate;
	/**
	 * 点赞数量
	 */
	private int goods;
	/**
	 * 
	 */
	private int hits;
	/**
	 * 讲师id
	 */
	private int teacherId;
	/**
	 * 是否结束（1未开始，2进行中，3已结束）   
	 */
	private int isEnd;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}

}
