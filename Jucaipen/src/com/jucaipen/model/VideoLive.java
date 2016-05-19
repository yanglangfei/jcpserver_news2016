package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
 *
 *
 *   直播室                     ------------------------------数据已更新    5.18
 */
@SuppressWarnings("serial")
public class VideoLive implements Serializable{
	/**
	 *  直播id
	 */
	private int id;
	/**
	 * 直播标题
	 */
	private String title;
	/**
	 * 直播关键字
	 */
	private String keyWord;
	/**
	 *  描述
	 */
	private String descript;
	/**
	 *  直播内容所属分类
	 */
	private int classId;
	/**
	 *  直播URL
	 */
	private String videoUrl;
	/**
	 *  直播封面
	 */
	private String videoImage;
	/**
	 *  直播讲师id
	 */
	private int teacherId;
	/**
	 * 直播状态 1未开始 2进行中 3已结束
	 */
	private int isEnd;
	/**
	 * 开始时间
	 */
	private String startDate;
	/**
	 *  结束时间
	 */
	private String endDate;
	/**
	 *  直播人气
	 */
	private int renQi;
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
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getVideoImage() {
		return videoImage;
	}
	public void setVideoImage(String videoImage) {
		this.videoImage = videoImage;
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
	public int getRenQi() {
		return renQi;
	}
	public void setRenQi(int renQi) {
		this.renQi = renQi;
	}
}
