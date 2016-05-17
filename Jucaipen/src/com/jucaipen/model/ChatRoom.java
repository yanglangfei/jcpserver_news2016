package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
 *
 *
 *   ֱ����
 */
@SuppressWarnings("serial")
public class ChatRoom implements Serializable{
	/**
	 *  ����id
	 */
	private int id;
	/**
	 * ��������
	 */
	private String roomName;
	/**
	 * ��������
	 */
	private String rollNotice;
	/**
	 * ����֪ͨ
	 */
	private String roomNotice;
	/**
	 * ��������
	 */
	private String Mianze;
	/**
	 * ��Ȩ
	 */
	private String copyRight;
	/**
	 * �Ƿ��οͷ���  (0--�������    1---���������)
	 */
	private int isStopYouke;
	/**
	 * �ɷ���Ȩ��
	 */
	private String userLevel;
	/**
	 * ����״̬
	 */
	private int roomState;
	/**
	 * �Ƿ�����ֱ��
	 */
	private int isLive;
	/**
	 * ֱ��URL
	 */
	private String liveUrl;
	/**
	 * 
	 */
	private String viedoUrl;
	/**
	 * ����ʱ��
	 */
	private String createDate;
	/**
	 * ��ϵ�绰
	 */
	private String telNum;
	/**
	 * �ֻ�����id
	 */
	private String moblieLiveId;
	/**
	 * �����ά��
	 */
	private String erweima;
	/**
	 * ��������
	 */
	private int shiTingDay;
	/**
	 * ֱ���䱳����
	 */
	private String roomFace;
	/**
	 * ֱ�����Ƿ�������ʾ  ��0   ������ʾ   1  �ر�  ����ʾ��
	 */
	private int roomType;
	
	
	
	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	public String getRoomFace() {
		return roomFace;
	}
	public void setRoomFace(String roomFace) {
		this.roomFace = roomFace;
	}
	public ChatRoom() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRollNotice() {
		return rollNotice;
	}
	public void setRollNotice(String rollNotice) {
		this.rollNotice = rollNotice;
	}
	public String getRoomNotice() {
		return roomNotice;
	}
	public void setRoomNotice(String roomNotice) {
		this.roomNotice = roomNotice;
	}
	public String getMianze() {
		return Mianze;
	}
	public void setMianze(String mianze) {
		Mianze = mianze;
	}
	public String getCopyRight() {
		return copyRight;
	}
	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}
	public int getIsStopYouke() {
		return isStopYouke;
	}
	public void setIsStopYouke(int isStopYouke) {
		this.isStopYouke = isStopYouke;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public int getRoomState() {
		return roomState;
	}
	public void setRoomState(int roomState) {
		this.roomState = roomState;
	}
	public int getIsLive() {
		return isLive;
	}
	public void setIsLive(int isLive) {
		this.isLive = isLive;
	}
	public String getLiveUrl() {
		return liveUrl;
	}
	public void setLiveUrl(String liveUrl) {
		this.liveUrl = liveUrl;
	}
	public String getViedoUrl() {
		return viedoUrl;
	}
	public void setViedoUrl(String viedoUrl) {
		this.viedoUrl = viedoUrl;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getMoblieLiveId() {
		return moblieLiveId;
	}
	public void setMoblieLiveId(String moblieLiveId) {
		this.moblieLiveId = moblieLiveId;
	}
	public String getErweima() {
		return erweima;
	}
	public void setErweima(String erweima) {
		this.erweima = erweima;
	}
	public int getShiTingDay() {
		return shiTingDay;
	}
	public void setShiTingDay(int shiTingDay) {
		this.shiTingDay = shiTingDay;
	}
	
	
	


}
