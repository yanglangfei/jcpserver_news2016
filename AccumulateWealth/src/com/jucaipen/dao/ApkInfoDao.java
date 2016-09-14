package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ApkInfo;

public interface ApkInfoDao {

	/**
	 * @param id
	 * @return  ��ȡAPK��Ϣ
	 */
	public ApkInfo findApkInfoById(int id);

	/**
	 * @return  ��ѯ����APK�汾��Ϣ
	 */
	public List<ApkInfo> findAll();

	/**
	 * @return  ���APK
	 */
	public int insertApkInfo(ApkInfo info);

	/**
	 * @return   ɾ��APK
	 */
	public int deleteApkInfo();
	/**
	 * @return  ��ȡAPK���id
	 */
	public int querrtMaxId();
}
