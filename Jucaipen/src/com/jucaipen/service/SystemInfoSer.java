package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.SysInfoDao;
import com.jucaipen.daoimp.SysInfoImp;
import com.jucaipen.model.SystemInfo;

public class SystemInfoSer {
	/**
	 * @return ��ѯ���е���Ϣ
	 */
	public static List<SystemInfo> findAllInfo(int page) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findAll(page);
	}

	/**
	 * @param id
	 * @return ����id��ȡ���е���Ϣ
	 */
	public static SystemInfo findInfoById(int id) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findSystemInfo(id);
	}

	/**
	 * @param reId
	 * @param page
	 * @return �����ռ���id��ѯ�û����ռ���
	 */
	public static List<SystemInfo> findInfoByReceiveId(int reId, int page) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findInfoByReceiver(reId, page);
	}
	/**
	 * @param sendId
	 * @param page
	 * @return   ���ݷ�����id ��ѯ�û��ķ�����
	 */
	public static List<SystemInfo> findInfoBySendId(int sendId,int page){
		SysInfoDao dao=new SysInfoImp();
		return dao.findInfoBySender(sendId, page);
	}
	
	/**
	 * @param userId
	 * @param page
	 * @return   �����û�id��ȡϵͳ��Ϣ
	 */
	public static List<SystemInfo> findInfoByUserId(int userId,int page){
		SysInfoDao dao=new SysInfoImp();
		return dao.findAllSystemInfoByUserId(userId, page);
	}
}
