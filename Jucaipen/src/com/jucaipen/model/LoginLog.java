package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
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
	 * ��¼�û���
	 */
	private String userName;
	/**
	 * ��¼����
	 */
	private String password;
	/**
	 * ��¼ʱ��
	 */
	private String loginDate;
	/**
	 * ��¼���
	 */
	private int loginResult;
	/**
	 * ��¼�豸ip
	 */
	private String loginIp;
	/**
	 * ��¼��ע��Ϣ��ʧ��ԭ��
	 */
	private String remark;
	
	public LoginLog() {
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
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
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
	
	

}
