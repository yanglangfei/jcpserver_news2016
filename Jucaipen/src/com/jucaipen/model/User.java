package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf            ------------------数据已更新     5.18
 * 
 *         用户
 * 
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	
	/**
	 * 用户信息当前页
	 */
	private int page;
	/**
	 * 用户信息总页数
	 */
	private int totlePage;
	
	/**
	 * 用户id
	 */
	private int id;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 用户头像
	 */
	private String faceImage;
	/**
	 * 手机号
	 */
	private String mobileNum;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * Email
	 */
	private String email;
	/**
	 * （省）
	 */
	private int provinceId;
	/**
	 * （市）
	 */
	private int cityId;
	/**
	 * （区）
	 */
	private int areaId;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 个人简介
	 */
	private String descript;
	/**
	 *   邀请人  --介绍人id
	 */
	private int parentUserId;
	/**
	 * 注册时间
	 */
	private String regDate;
	/**
	 * 是否完成邮箱验证（0 未完成 1 已完成）
	 */
	private int isChechEmail;
	/**
	 * 是否完成手机验证（0 未完成 1已完成）
	 */
	private int isChechMobile;
	/**
	 *  是否开通文字直播    0   否   1 是
	 */
	private int isTxtTeacher;
	/**
	 *  是否开通视频直播   0  否  1  是
	 */
	private int isVideoTeacher;
	/**
	 *  登录次数
	 */
	private int loginNum;
	/**
	 *  最近登录时间
	 */
	private String lastLoginDate;
	/**
	 *  最近登录IP
	 */
	private String lastLoginIp;
	/**
	 *  投资风格
	 */
	private int investId;
	/**
	 * 绑定微博id
	 */
	private String weiBoId;
	/**
	 * qq绑定id
	 */
	private String qqId;
	/**
	 * 微信绑定id
	 */
	private String weiXinId;
	/**
	 * 帐号状态（0正常 1锁定 2删除）
	 */
	private int isLock;
	/**
	 * 是否为系统管理员（0普通用户，1管理员）
	 */
	private int isSysAdmin;
	/**
	 * 是否为直播间管理员（0否，1是）
	 */
	private int isRoomAdmin;
	/**
	 *  直播间管理员关联的直播间id
	 */
	private int fk_roomTeacherId;
	/**
	 *  用户等级
	 */
	private int userLeval;
	/**
	 *  邀请码
	 */
	private String invitationCode;
	/**
	 * 注册来源（1PC端，2手机网站，3手机APP，4系统添加）
	 */
	private int reginFrom;
	/**
	 *  总积分
	 */
	private int allIntegral;
	/**
	 *  用户名
	 */
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getParentUserId() {
		return parentUserId;
	}
	public void setParentUserId(int parentUserId) {
		this.parentUserId = parentUserId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
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
	public int getIsTxtTeacher() {
		return isTxtTeacher;
	}
	public void setIsTxtTeacher(int isTxtTeacher) {
		this.isTxtTeacher = isTxtTeacher;
	}
	public int getIsVideoTeacher() {
		return isVideoTeacher;
	}
	public void setIsVideoTeacher(int isVideoTeacher) {
		this.isVideoTeacher = isVideoTeacher;
	}
	public int getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(int loginNum) {
		this.loginNum = loginNum;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public int getInvestId() {
		return investId;
	}
	public void setInvestId(int investId) {
		this.investId = investId;
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
	public int getIsLock() {
		return isLock;
	}
	public void setIsLock(int isLock) {
		this.isLock = isLock;
	}
	public int getIsSysAdmin() {
		return isSysAdmin;
	}
	public void setIsSysAdmin(int isSysAdmin) {
		this.isSysAdmin = isSysAdmin;
	}
	public int getIsRoomAdmin() {
		return isRoomAdmin;
	}
	public void setIsRoomAdmin(int isRoomAdmin) {
		this.isRoomAdmin = isRoomAdmin;
	}
	public int getFk_roomTeacherId() {
		return fk_roomTeacherId;
	}
	public void setFk_roomTeacherId(int fk_roomTeacherId) {
		this.fk_roomTeacherId = fk_roomTeacherId;
	}
	public int getUserLeval() {
		return userLeval;
	}
	public void setUserLeval(int userLeval) {
		this.userLeval = userLeval;
	}
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public int getReginFrom() {
		return reginFrom;
	}
	public void setReginFrom(int reginFrom) {
		this.reginFrom = reginFrom;
	}
	public int getAllIntegral() {
		return allIntegral;
	}
	public void setAllIntegral(int allIntegral) {
		this.allIntegral = allIntegral;
	}
	
	
}
