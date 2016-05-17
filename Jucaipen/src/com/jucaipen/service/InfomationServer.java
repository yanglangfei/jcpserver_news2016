package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.SysInfoDao;
import com.jucaipen.daoimp.SysInfoImp;
import com.jucaipen.model.SystemInfo;

public class InfomationServer {
	/**
	 * @return ��ѯȫ����Ϣ
	 */
	public static List<SystemInfo> getInfos(int page) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findAll(page);
	}

	/**
	 * @param id
	 * @return ��ѯ������Ϣ
	 */
	public static SystemInfo getInfo(int id) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findSystemInfo(id);
	}

}
