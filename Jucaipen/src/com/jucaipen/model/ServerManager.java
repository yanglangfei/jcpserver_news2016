package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ����������Ա
 *
 */
@SuppressWarnings("serial")
public class ServerManager implements Serializable{
	/**
	 *   ������id
	 */
	private int id;
	/**
	 * ����������
	 */
	private String name;
	/**
	 * �������ֻ���
	 */
	private String telPhone;
	/**
	 * �������û���
	 */
	private String userName;
	/**
	 * �����ߵ�¼����
	 */
	private String password;
	public ServerManager() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
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
	

}
