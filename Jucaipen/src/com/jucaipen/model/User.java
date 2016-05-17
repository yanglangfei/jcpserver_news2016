package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *         �û�
 * 
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	/**
	 * ��Ӧ�û��� ChatType �ֶ�  ��1   �۲����û�    2   ����û�   ���ܽ�ֱ����  ����ɨ��ά�����   0  ��ͨ�û���
	 */
	private int userType;
	/**
	 * �û���Ϣ��ǰҳ
	 */
	private int page;
	/**
	 * �û���Ϣ��ҳ��
	 */
	private int totlePage;
	
	/**
	 * �û�id
	 */
	private int id;
	/**
	 * �û��˺�
	 */
	private String userName;
	/**
	 * �û�����
	 */
	private int age;
	/**
	 * ��¼����
	 */
	private String password;
	/**
	 * ��ʵ����
	 */
	private String trueName;
	/**
	 * �ǳ�
	 */
	private String nickName;
	/**
	 * Email
	 */
	private String email;
	/**
	 * �û�ͷ��
	 */
	private String faceImage;
	/**
	 * �ֻ���
	 */
	private String mobileNum;
	/**
	 * �Ա�
	 */
	private String sex;
	/**
	 * ����
	 */
	private String birthday;
	/**
	 * ���磨ʡ��
	 */
	private int homeProvince;
	/**
	 * ���磨�У�
	 */
	private int homeCity;
	/**
	 * ���磨����
	 */
	private int homeArea;
	/**
	 * ����ʡ��
	 */
	private int localProvince;
	/**
	 * ���ڳ���
	 */
	private int localCity;
	/**
	 * ������
	 */
	private int localArea;
	/**
	 * ��������
	 */
	private String descript;
	/**
	 * ע��ʱ��
	 */
	private String regDate;
	/**
	 * �ʺ�״̬��0���� 1���� 4ɾ����
	 */
	private int isLock;
	/**
	 * ��΢��id
	 */
	private String weiBoId;
	/**
	 * qq��id
	 */
	private String qqId;
	/**
	 * ΢�Ű�id
	 */
	private String weiXinId;
	/**
	 * �Ƿ����������֤��0 δ��� 1 ����ɣ�
	 */
	private int isChechEmail;
	/**
	 * �Ƿ�����ֻ���֤��0 δ��� 1����ɣ�
	 */
	private int isChechMobile;
	/**
	 * ע��ip
	 */
	private String regIp;
	private int isFree;
	private String serverStartDate;
	private String serverEndDate;
	private int isStop;
	private int serverId;
	private int isRoomManager;
	private int buyProductId;
	
	
	
	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	/**
	 * ע����Դ  ��1����վPC��2���ֻ���վ��3��ֱ����PC��4��ֱ�����ֻ���5��APP��
	 */
	private int RegFrom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaceImage() {
		return faceImage;
	}

	public void setFaceImage(String faceImage) {
		this.faceImage = faceImage;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getHomeProvince() {
		return homeProvince;
	}

	public void setHomeProvince(int homeProvince) {
		this.homeProvince = homeProvince;
	}

	public int getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(int homeCity) {
		this.homeCity = homeCity;
	}

	public int getHomeArea() {
		return homeArea;
	}

	public void setHomeArea(int homeArea) {
		this.homeArea = homeArea;
	}

	public int getLocalProvince() {
		return localProvince;
	}

	public void setLocalProvince(int localProvince) {
		this.localProvince = localProvince;
	}

	public int getLocalCity() {
		return localCity;
	}

	public void setLocalCity(int localCity) {
		this.localCity = localCity;
	}

	public int getLocalArea() {
		return localArea;
	}

	public void setLocalArea(int localArea) {
		this.localArea = localArea;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getIsLock() {
		return isLock;
	}

	public void setIsLock(int isLock) {
		this.isLock = isLock;
	}

	public String getWeiBoId() {
		return weiBoId;
	}

	public void setWeiBoId(String weiBoId) {
		this.weiBoId = weiBoId;
	}

	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}

	public String getWeiXinId() {
		return weiXinId;
	}

	public void setWeiXinId(String weiXinId) {
		this.weiXinId = weiXinId;
	}

	public int getIsChechEmail() {
		return isChechEmail;
	}

	public void setIsChechEmail(int isChechEmail) {
		this.isChechEmail = isChechEmail;
	}

	public int getIsChechMobile() {
		return isChechMobile;
	}

	public void setIsChechMobile(int isChechMobile) {
		this.isChechMobile = isChechMobile;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public int getIsFree() {
		return isFree;
	}

	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}

	public String getServerStartDate() {
		return serverStartDate;
	}

	public void setServerStartDate(String serverStartDate) {
		this.serverStartDate = serverStartDate;
	}

	public String getServerEndDate() {
		return serverEndDate;
	}

	public void setServerEndDate(String serverEndDate) {
		this.serverEndDate = serverEndDate;
	}

	public int getIsStop() {
		return isStop;
	}

	public void setIsStop(int isStop) {
		this.isStop = isStop;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public int getIsRoomManager() {
		return isRoomManager;
	}

	public void setIsRoomManager(int isRoomManager) {
		this.isRoomManager = isRoomManager;
	}

	public int getBuyProductId() {
		return buyProductId;
	}

	public void setBuyProductId(int buyProductId) {
		this.buyProductId = buyProductId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRegFrom() {
		return RegFrom;
	}

	public void setRegFrom(int regFrom) {
		RegFrom = regFrom;
	}
	

}
