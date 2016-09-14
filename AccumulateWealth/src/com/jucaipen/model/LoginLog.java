package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF     -------------------�����Ѹ���
 * 
 *   ��¼��־
 *
 */
@SuppressWarnings("serial")
public class LoginLog implements Serializable{
	/**
	 * ��¼
	 */
	private int pager;
	/**
	 *  ��¼��־��ҳ��
	 */
	private int totlePager;
	/**
	 *  ��¼��־id
	 */
	private int id;
	/**
	 * ��¼�û�id
	 */
	private int userId;
	/**
	 * ��¼�˺�
	 */
	private String account;
	/**
	 * ��¼����
	 */
	private String password;
	/**
	 * ��¼ʱ��
	 */
	private String loginDate;
	/**
	 * ��¼�������
	 */
	private String browserName;
	/**
	 * ����ϵͳ
	 */
	private String osName;
	/**
	 * ��¼���  1  ʧ��   0�ɹ�
	 */
	private int loginResult;
	/**
	 * ��¼�豸ip
	 */
	private String loginIp;
	
	/**
	 * ��¼������Ϣ��ʧ��ԭ��
	 */
	private String remark;
	/**
	 *  ��¼���ͣ�1PC��վ��2�ֻ���վ��3App�ȣ�
	 */
	private int loginType;
	/**
	 * ��¼�ύ��ַ
	 */
	private String loginUrl;
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}
	public int getTotlePager() {
		return totlePager;
	}
	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public int getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(int loginResult) {
		this.loginResult = loginResult;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	

}
