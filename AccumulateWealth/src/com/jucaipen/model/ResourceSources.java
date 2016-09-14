package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   ��Ϣ��Դ      ---------------�����Ѹ���
 *
 */
@SuppressWarnings("serial")
public class ResourceSources implements Serializable {
	/**
	 * ��Ϣ��Դ��ǰҳ
	 */
	private int pager;
	/**
	 * ��Ϣ��Դ��ҳ��
	 */
	private int totlePager;
	/**
	 * ��Դid
	 */
	private int id;
	/**
	 * ��Ϣ��Դ����
	 */
	private String fromName;
	/**
	 * ��Ϣ��Դ��ҳ
	 */
	private String fromUrl;
	/**
	 * ����
	 */
	private int sortId;
	
	public ResourceSources(int id, String fromName, String fromUrl, int sortId) {
		this.id = id;
		this.fromName = fromName;
		this.fromUrl = fromUrl;
		this.sortId = sortId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	
	public String getFromUrl() {
		return fromUrl;
	}
	public void setFromUrl(String fromUrl) {
		this.fromUrl = fromUrl;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
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
