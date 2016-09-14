package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator   -------------------�����Ѹ���
 *
 *  ���ݿ�������Ϣ
 */
@SuppressWarnings("serial")
public class SiteConfig implements Serializable{
	/**
	 * ��վ����
	 */
	private String siteName;
	/**
	 * ��վ����
	 */
	private String siteTitle;
	/**
	 * ���ŷ�������������������
	 */
	private int newsMom;
	/**
	 * ��Ƶ��������������������
	 */
	private int videoMom;
	/**
	 * �ؼ���
	 */
	private String keyWord;
	/**
	 * ���� 
	 */
	private String descript;
	/**
	 * ������
	 */
	private String icp;
	/**
	 * ��Ȩ��Ϣ
	 */
	private String copyRight;
	/**
	 *  �û������Ƿ���Ҫ��ˣ�0��1�ǣ�
	 */
	private int commType;
	/**
	 * �Ƽ�һ�����Ͷ��ٻ���
	 */
	private int recommIntegeral;
	/**
	 * ����һ���Ͷ��ٻ���
	 */
	private int commIntegeral;
	/**
	 * ǩ��һ�����Ͷ��ٻ���
	 */
	private int signIntegeral;
	/**
	 * ���û��״�ע�����Ͷ��ٻ���
	 */
	private int regIntegeral;
	/**
	 * ���ֶһ��۲Ʊң�10����=1�۲Ʊң�
	 */
	private double subRat;
	/**
	 * ��ʦ�շ�ֱ����������
	 */
	private double teacherLiveRebat;
	/**
	 * ��ʦ�ش����ⷵ������
	 */
	private double teacherAnswerRebat;
	/**
	 * �û�������Ʒ��ʦ��������
	 */
	private double userGiveRebat;
	/**
	 *  �Ƿ������ػ�
	 */
	private double userIsShouhu;
	/**
	 * ϵͳ������������
	 */
	private int askNum;
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteTitle() {
		return siteTitle;
	}
	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}
	public int getNewsMom() {
		return newsMom;
	}
	public void setNewsMom(int newsMom) {
		this.newsMom = newsMom;
	}
	public int getVideoMom() {
		return videoMom;
	}
	public void setVideoMom(int videoMom) {
		this.videoMom = videoMom;
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
	public String getIcp() {
		return icp;
	}
	public void setIcp(String icp) {
		this.icp = icp;
	}
	public String getCopyRight() {
		return copyRight;
	}
	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}
	public int getCommType() {
		return commType;
	}
	public void setCommType(int commType) {
		this.commType = commType;
	}
	public int getRecommIntegeral() {
		return recommIntegeral;
	}
	public void setRecommIntegeral(int recommIntegeral) {
		this.recommIntegeral = recommIntegeral;
	}
	public int getCommIntegeral() {
		return commIntegeral;
	}
	public void setCommIntegeral(int commIntegeral) {
		this.commIntegeral = commIntegeral;
	}
	public int getSignIntegeral() {
		return signIntegeral;
	}
	public void setSignIntegeral(int signIntegeral) {
		this.signIntegeral = signIntegeral;
	}
	public int getRegIntegeral() {
		return regIntegeral;
	}
	public void setRegIntegeral(int regIntegeral) {
		this.regIntegeral = regIntegeral;
	}
	public double getSubRat() {
		return subRat;
	}
	public void setSubRat(double subRat) {
		this.subRat = subRat;
	}
	public double getTeacherLiveRebat() {
		return teacherLiveRebat;
	}
	public void setTeacherLiveRebat(double teacherLiveRebat) {
		this.teacherLiveRebat = teacherLiveRebat;
	}
	public double getTeacherAnswerRebat() {
		return teacherAnswerRebat;
	}
	public void setTeacherAnswerRebat(double teacherAnswerRebat) {
		this.teacherAnswerRebat = teacherAnswerRebat;
	}
	public double getUserGiveRebat() {
		return userGiveRebat;
	}
	public void setUserGiveRebat(double userGiveRebat) {
		this.userGiveRebat = userGiveRebat;
	}
	public double getUserIsShouhu() {
		return userIsShouhu;
	}
	public void setUserIsShouhu(double userIsShouhu) {
		this.userIsShouhu = userIsShouhu;
	}
	public int getAskNum() {
		return askNum;
	}
	public void setAskNum(int askNum) {
		this.askNum = askNum;
	}
}
