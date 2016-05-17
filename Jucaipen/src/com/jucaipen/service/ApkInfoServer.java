package com.jucaipen.service;

import com.jucaipen.dao.ApkInfoDao;
import com.jucaipen.daoimp.ApkInfoImp;
import com.jucaipen.model.ApkInfo;

public class ApkInfoServer {
	/**
	 * @param uId
	 * @return ��ȡ���°汾apk��Ϣ
	 */
	public static ApkInfo findLastApkInfo(int uId) {
		ApkInfoDao dao = new ApkInfoImp();
		return dao.findApkInfoById(uId);
	}

	/**
	 * @param info
	 * @return ���APK��Ϣ
	 */
	public static int insertApkInfo(ApkInfo info) {
		ApkInfoDao dao = new ApkInfoImp();
		return dao.insertApkInfo(info);
	}

	/**
	 * @return  ��ȡAPK��Ϣ����id
	 */
	public static int querryMaxId(){
		ApkInfoDao dao=new ApkInfoImp();
		return dao.querrtMaxId();
	}

}
