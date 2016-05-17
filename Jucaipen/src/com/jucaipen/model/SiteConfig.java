package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *
 *   APP������Ϣ  �ӿڵ�������
 */
@SuppressWarnings("serial")
public class SiteConfig implements Serializable{
	
	private String siteTitle;
	
	private String keyWord;
	
	private String descript;
	/**
	 * վ���Ƿ�رգ�0Ϊ������1Ϊ�رգ�
	 */
	private int isClose;
	/**
	 *  վ��ر���ʾ��Ϣ
	 */
	private String closeMsg;
	/**
	 * �Ƿ�ֹͣע�ᣨ1Ϊֹͣע��0Ϊ����ע�ᣩ
	 */
	private int isReg;
	/**
	 * ֹͣ�û�ע����ʾ��Ϣ
	 */
	private String stopRegMsg;
	
	private String icp;
	/**
	 *   ��Ȩ��Ϣ
	 */
	private String copyRight;
	/**
	 * ҳ��״̬(0Ϊ��̬,1Ϊα��̬,2Ϊ��̬)
	 */
	private int pageType;
	/**
	 * ����״̬��0������ˣ�1��Ҫ��ˣ�
	 */
	private int commType;
	/**
	 * ���ۻظ�״̬��0������ˣ�1��Ҫ��ˣ�
	 */
	private int commRespType;
	private String siteName;
	/**
	 *  ԤԼ֪ͨ����
	 */
	private String orderNoticeEmail;
	/**
	 *  ���ʵ��������
	 */
	private int askNum;
	public String getSiteTitle() {
		return siteTitle;
	}
	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
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
	public int getIsClose() {
		return isClose;
	}
	public void setIsClose(int isClose) {
		this.isClose = isClose;
	}
	public String getCloseMsg() {
		return closeMsg;
	}
	public void setCloseMsg(String closeMsg) {
		this.closeMsg = closeMsg;
	}
	public int getIsReg() {
		return isReg;
	}
	public void setIsReg(int isReg) {
		this.isReg = isReg;
	}
	public String getStopRegMsg() {
		return stopRegMsg;
	}
	public void setStopRegMsg(String stopRegMsg) {
		this.stopRegMsg = stopRegMsg;
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
	public int getPageType() {
		return pageType;
	}
	public void setPageType(int pageType) {
		this.pageType = pageType;
	}
	public int getCommType() {
		return commType;
	}
	public void setCommType(int commType) {
		this.commType = commType;
	}
	public int getCommRespType() {
		return commRespType;
	}
	public void setCommRespType(int commRespType) {
		this.commRespType = commRespType;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getOrderNoticeEmail() {
		return orderNoticeEmail;
	}
	public void setOrderNoticeEmail(String orderNoticeEmail) {
		this.orderNoticeEmail = orderNoticeEmail;
	}
	public int getAskNum() {
		return askNum;
	}
	public void setAskNum(int askNum) {
		this.askNum = askNum;
	}
	

}
