package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.AdverticeDao;
import com.jucaipen.daoimp.AdverticeImp;
import com.jucaipen.model.Advertive;

public class AdverSer {
	public static List<Advertive> findAll() {
		return null;

	}

	/** 
	 * @param pId
	 * @return   ���ݻõ�id ��ȡ��Ӧ���
	 */
	public static List<Advertive> findAdverByPid(int pId) {
		AdverticeDao dao = new AdverticeImp();
		return dao.findAdByPid(pId);
	}

}
