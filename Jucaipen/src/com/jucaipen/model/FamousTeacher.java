package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *    �Ƽ���ʦ
 */
@SuppressWarnings("serial")
public class FamousTeacher implements Serializable{
	/**
	 * ��ʦ��ǰҳ��
	 */
	private int page;
	/**
	 * ��ʦ��ҳ��
	 */
	private int totlePage;
	/**
	 * ��ʦid
	 */
	private int id;
	/**
	 * ��¼�˺�
	 */
	private String account;
	/**
	 * ��¼����
	 */
	private String loginPwd;
	/**
	 * ��ʵ����
	 */
	private String trueName;
	/**
	 * �ǳ�
	 */
	private String nickName;
	/**
	 * ͷ��
	 */
	private String headFace;
	/**
	 * ͷ��
	 */
	private String level;
	/**
	 * �Ƿ��V
	 */
	private int isV;
	/**
	 * ��˿����
	 */
	private int fans;
	/**
	 * ֱ������
	 */
	private int liveFans;
	/**
	 * �ظ�������
	 */
	private int answerCount;
	/**
	 * ��־��
	 */
	private int articleCount;
	/**
	 * ��־�Ķ���
	 */
	private int articleReadCount;
	/**
	 * ��־������
	 */
	private int articleGood;
	/**
	 * ����
	 */
	private String notice;
	/**
	 * ��ʦ���
	 */
	private String introduce;
	/**
	 * �ó�����
	 */
	private String hoby;
	/**
	 * �ֻ���
	 */
	private String telPhone;
	/**
	 * ��������
	 */
	private int serverCount;
	/**
	 * �˺�״̬
	 */
	private int state;
	/**
	 * ����ʱ��
	 */
	private String joinDate;
	/**
	 * �����¼ʱ��
	 */
	private String lastLoginDate;
	/**
	 * �����¼ip
	 */
	private String lastLoginIp;
	/**
	 * ֱ�������Ƿ���Ҫ���
	 */
	private int liveGbookIsPass;
	private int userId;
	/*
	 * �������� 
	 */
	private int askNum;
	/**
	 *   ��۸� 
	 */
	private double yaerPrice;
	/**
	 *   �¼۸� 
	 */
	private double mothPrice;
	/**
	 *   ���ȼ۸� 
	 */
	private double qulaterPrice;
	/**
	 *   ÿ��۸�
	 */
	private double dayPrice;
	
	public FamousTeacher() {
		super();
	}
	
	
	
	public double getYaerPrice() {
		return yaerPrice;
	}



	public void setYaerPrice(double yaerPrice) {
		this.yaerPrice = yaerPrice;
	}



	public double getMothPrice() {
		return mothPrice;
	}



	public void setMothPrice(double mothPrice) {
		this.mothPrice = mothPrice;
	}



	public double getQulaterPrice() {
		return qulaterPrice;
	}



	public void setQulaterPrice(double qulaterPrice) {
		this.qulaterPrice = qulaterPrice;
	}



	public double getDayPrice() {
		return dayPrice;
	}



	public void setDayPrice(double dayPrice) {
		this.dayPrice = dayPrice;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
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
	public String getHeadFace() {
		return headFace;
	}
	public void setHeadFace(String headFace) {
		this.headFace = headFace;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getIsV() {
		return isV;
	}
	public void setIsV(int isV) {
		this.isV = isV;
	}
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	public int getLiveFans() {
		return liveFans;
	}
	public void setLiveFans(int liveFans) {
		this.liveFans = liveFans;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public int getArticleReadCount() {
		return articleReadCount;
	}
	public void setArticleReadCount(int articleReadCount) {
		this.articleReadCount = articleReadCount;
	}
	public int getArticleGood() {
		return articleGood;
	}
	public void setArticleGood(int articleGood) {
		this.articleGood = articleGood;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getHoby() {
		return hoby;
	}
	public void setHoby(String hoby) {
		this.hoby = hoby;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public int getServerCount() {
		return serverCount;
	}
	public void setServerCount(int serverCount) {
		this.serverCount = serverCount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
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
	public int getLiveGbookIsPass() {
		return liveGbookIsPass;
	}
	public void setLiveGbookIsPass(int liveGbookIsPass) {
		this.liveGbookIsPass = liveGbookIsPass;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAskNum() {
		return askNum;
	}
	public void setAskNum(int askNum) {
		this.askNum = askNum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
