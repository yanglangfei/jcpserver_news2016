package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *    ��Ƶ����bean
 *
 */
@SuppressWarnings("serial")
public class VideoComm implements Serializable {
    /**
     *  ����id
     */
    private int id;
    /**
     *  ������Ƶid
     */
    private int videoId;
    /**
     *  �����û�id
     */
    private int userId;
    /**
     *  ��������
     */
    private String bodys;
    /**
     *  ��������
     */
    private int goodCount;
    /**
     *  �ظ�����
     */
    private int replyCount;
    /**
     *  ����ʱ��
     */
    private String insertDate;
    /**
     *  �����û�ip
     */
    private String ip;
    /**
     *  �����Ƿ���ʾ
     */
    private int isShow;
    
	public VideoComm(int id, int videoId, int userId, String bodys) {
		super();
		this.id = id;
		this.videoId = videoId;
		this.userId = userId;
		this.bodys = bodys;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public int getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
    
    
}
