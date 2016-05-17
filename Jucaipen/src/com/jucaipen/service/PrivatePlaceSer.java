package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.PrivatePlaceDao;
import com.jucaipen.daoimp.PrivatePlaceImp;
import com.jucaipen.model.PrivatePlace;

public class PrivatePlaceSer {
	/**
	 * @param pager
	 * @return   获取所有私募信息
	 */
	public static List<PrivatePlace> findAll(int pager) {
		PrivatePlaceDao dao = new PrivatePlaceImp();
		return dao.findAll(pager);
	}

	/**
	 * @param id
	 * @return  根据id获取私募信息
	 */
	public static PrivatePlace findPrivatePlaceById(int id) {
		PrivatePlaceDao dao = new PrivatePlaceImp();
		return dao.findPrivatePlaceById(id);
	}

}
