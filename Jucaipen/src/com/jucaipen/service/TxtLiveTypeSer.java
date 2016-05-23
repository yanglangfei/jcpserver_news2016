package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TxtLiveTypeDao;
import com.jucaipen.daoimp.TxtLiveTypeImp;
import com.jucaipen.model.TxtLiveType;

public class TxtLiveTypeSer {

	/**
	 * @return ��ȡ��������ֱ��������Ϣ
	 */
	public static List<TxtLiveType> findAll() {
		TxtLiveTypeDao dao=new TxtLiveTypeImp();
		return dao.findAll();
	}

	/**
	 * @param id
	 * @return ����id��ȡ����ֱ��������Ϣ
	 */
	public static  TxtLiveType findTypeById(int id) {
		TxtLiveTypeDao dao=new TxtLiveTypeImp();
		return dao.findTypeById(id);
	}

}
