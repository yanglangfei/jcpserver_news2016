package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.PrivatePlaceDao;
import com.jucaipen.daoimp.PrivatePlaceImp;
import com.jucaipen.model.PrivatePlace;

public class PrivatePlaceSer {
	/**
	 * @param pager
	 * @return   ��ȡ����˽ļ��Ϣ
	 */
	public static List<PrivatePlace> findAll(int pager) {
		PrivatePlaceDao dao = new PrivatePlaceImp();
		return dao.findAll(pager);
	}

	/**
	 * @param id
	 * @return  ����id��ȡ˽ļ��Ϣ
	 */
	public static PrivatePlace findPrivatePlaceById(int id) {
		PrivatePlaceDao dao = new PrivatePlaceImp();
		return dao.findPrivatePlaceById(id);
	}

}
