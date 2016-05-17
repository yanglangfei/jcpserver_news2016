package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *         APK �ļ���Ϣ
 * 
 */
@SuppressWarnings("serial")
public class ApkInfo implements Serializable {
	/**
	 * APK����
	 */
	private String pkgName;
	/**
	 * APK�汾��
	 */
	private int versionCode;
	/**
	 * APK �汾id
	 */
	private int id;
	/**
	 *  �汾����
	 */
	private String vsionName;
	/**
	 *  APK����·��
	 */
	private String apkPath;
	/**
	 * APK����ʱ��
	 */
	private String updateDate;
	
	
	public String getUpdateDate() {
		return updateDate;
	}



	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}



	public String getApkPath() {
		return apkPath;
	}

	public void setApkPath(String apkPath) {
		this.apkPath = apkPath;
	}

	public String getVsionName() {
		return vsionName;
	}

	public void setVsionName(String vsionName) {
		this.vsionName = vsionName;
	}

	public String getPkgName() {
		return pkgName;
	}
	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}
	public int getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
