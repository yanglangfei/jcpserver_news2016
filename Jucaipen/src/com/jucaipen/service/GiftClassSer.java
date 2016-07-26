package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.GiftClassDao;
import com.jucaipen.daoimp.GiftClassImp;
import com.jucaipen.model.GiftClass;

public class GiftClassSer{

	/**
	 * @return ��ȡ������Ʒ������Ϣ
	 */
	public static  List<GiftClass> findAllClass() {
		GiftClassDao dao=new GiftClassImp();
		return dao.findAllClass();
	}

	/**
	 * @param id
	 * @return ����id��ȡ������Ϣ
	 */
	public static GiftClass findIdByClass(int id) {
		GiftClassDao dao=new GiftClassImp();
		return dao.findIdByClass(id);
	}
	
	public static List<GiftClass> findTopClass(int top) {
		GiftClassDao dao=new GiftClassImp();
		return dao.findTopClass(top);
	}

}
