package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf            ------------------�����Ѹ���     5.18
 * 
 *         �û�
 * 
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	
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
	 * ��ʵ����
	 */
	private String trueName;
	/**
	 * �ǳ�
	 */
	private String nickName;
	/**
	 * �Ա�
	 */
	private String sex;
	/**
	 * �û�ͷ��
	 */
	private String faceImage;
	/**
	 * �ֻ���
	 */
	private String mobileNum;
	/**
	 * ��¼����
	 */
	private String password;
	/**
	 * Email
	 */
	private String email;
	/**
	 * ��ʡ��
	 */
	private int provinceId;
	/**
	 * ���У�
	 */
	private int cityId;
	/**
	 * ������
	 */
	private int areaId;
	/**
	 * ����
	 */
	private String birthday;
	/**
	 * ���˼��
	 */
	private String descript;
	/**
	 *   ������  --������id
	 */
	private int parentUserId;
	/**
	 * ע��ʱ��
	 */
	private String regDate;
	/**
	 * �Ƿ����������֤��0 δ��� 1 ����ɣ�
	 */
	private int isChechEmail;
	/**
	 * �Ƿ�����ֻ���֤��0 δ��� 1����ɣ�
	 */
	private int isChechMobile;
	/**
	 *  �Ƿ�ͨ����ֱ��    0   ��   1 ��
	 */
	private int isTxtTeacher;
	/**
	 *  �Ƿ�ͨ��Ƶֱ��   0  ��  1  ��
	 */
	private int isVideoTeacher;
	/**
	 *  ��¼����
	 */
	private int loginNum;
	/**
	 *  �����¼ʱ��
	 */
	private String lastLoginDate;
	/**
	 *  �����¼IP
	 */
	private String lastLoginIp;
	/**
	 *  Ͷ�ʷ��
	 */
	private int investId;
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
	 * �ʺ�״̬��0���� 1���� 2ɾ����
	 */
	private int isLock;
	/**
	 * �Ƿ�Ϊϵͳ����Ա��0��ͨ�û���1����Ա��
	 */
	private int isSysAdmin;
	/**
	 * �Ƿ�Ϊֱ�������Ա��0��1�ǣ�
	 */
	private int isRoomAdmin;
	/**
	 *  ֱ�������Ա������ֱ����id
	 */
	private int fk_roomTeacherId;
	/**
	 *  �û��ȼ�
	 */
	private int userLeval;
	/**
	 *  ������
	 */
	private String invitationCode;
	/**
	 * ע����Դ��1PC�ˣ�2�ֻ���վ��3�ֻ�APP��4ϵͳ��ӣ�
	 */
	private int reginFrom;
	/**
	 *  �ܻ���
	 */
	private int allIntegral;
	/**
	 *  �û���
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
