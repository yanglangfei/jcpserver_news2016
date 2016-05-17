package com.jucaipen.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YLF ������
 */
@SuppressWarnings("serial")
public class Admin implements Serializable {
	/**
	 * ������id
	 */
	private int id;
	/**
	 * �û���
	 */
	private String userName;
	/**
	 * ����
	 */
	private String passWord;
	/**
	 * ��ʵ����
	 */
	private String trueName;
	/**
	 * ��¼����
	 */
	private int loginTime;
	/**
	 * �ϴε�¼ʱ��
	 */
	private Date lastLoginDate;
	/**
	 * �ϴε�¼IP
	 */
	private String lastLoginIp;
	/**
	 * ״̬ ---0Ϊ������1Ϊ���� 4Ϊɾ��
	 */
	private int type;
	/**
	 * ����ʱ��
	 */
	private Date insertDate;

	public Admin(int id, String userName, String passWord, String trueName,
			int loginTime, Date lastLoginDate, String lastLoginIp, int type,
			Date insertDate) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.trueName = trueName;
		this.loginTime = loginTime;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginIp = lastLoginIp;
		this.type = type;
		this.insertDate = insertDate;
	}

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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public int getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(int loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

}
