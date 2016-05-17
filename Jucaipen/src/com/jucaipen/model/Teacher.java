package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   ��ʦ
 */
@SuppressWarnings("serial")
public class Teacher implements Serializable {
	/**
	 * ��ʦ��Ϣ��ǰҳ
	 */
	private int page;
	/**
	 * ��ʦ��Ϣ��ҳ��
	 */
	private int totlePage;
	/**
	 * id 
	 */
	private int id;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ͼƬurl
	 */
	private String photoUrl;
	/**
	 * ��Ҫ
	 */
	private String summary;
	/**
	 * ����
	 */
	private String bodys;
	/**
	 * ����
	 */
	private int px;
	
	
	public Teacher(int id, String name, String photoUrl, String summary,
			String bodys, int px) {
		this.id = id;
		this.name = name;
		this.photoUrl = photoUrl;
		this.summary = summary;
		this.bodys = bodys;
		this.px = px;
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
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
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
	
	
	

}
