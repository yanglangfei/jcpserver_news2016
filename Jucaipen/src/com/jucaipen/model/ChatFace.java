package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *   �������
 *
 */
@SuppressWarnings("serial")
public class ChatFace implements Serializable{
     /**
     *   �������id
     */
    private int id;
     /**
     * �������URL
     */
    private String faceUrl;
     /**
     * �����������
     */
    private String title;
     /**
     * ����id
     */
    private int pxId;
     
	public ChatFace() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFaceUrl() {
		return faceUrl;
	}
	public void setFaceUrl(String faceUrl) {
		this.faceUrl = faceUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
     
}
