package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ���߿ͷ�
 *
 */
@SuppressWarnings("serial")
public class ServerQQ implements Serializable{
	
	/**
	 *  �ͷ�id
	 */
	private int id;
	/**
	 * �ͷ�����
	 */
	private String title;
	/**
	 * �ͷ�QQ��
	 */
	private String qqCode;
	/**
	 * �ͷ���������
	 */
	private int roomId;
	/**
	 * �ͷ�����
	 */
	private int pxId;
	
	public ServerQQ() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQqCode() {
		return qqCode;
	}
	public void setQqCode(String qqCode) {
		this.qqCode = qqCode;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	

}
