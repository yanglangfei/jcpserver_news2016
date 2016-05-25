package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.GiftsDao;
import com.jucaipen.daoimp.GiftsImp;
import com.jucaipen.model.Gifts;

public class GiftsSer{

	/**
	 * @param page
	 * @return ��ȡ�̵�������Ʒ
	 */
	public static List<Gifts> findAllGift(int page) {
		GiftsDao dao=new GiftsImp();
		return dao.findAllGift(page);
	}

	/**
	 * @param page
	 * @param classId
	 * @return ���ݷ���id��ȡ�̵���Ʒ
	 */
	public static List<Gifts> findGiftByClassId(int page, int classId) {
		GiftsDao dao=new GiftsImp();
		return dao.findGiftByClassId(page, classId);
	}

	/**
	 * @param id
	 * @return ����id��ȡ��Ʒ��Ϣ
	 */
	public static Gifts findGiftById(int id) {
		GiftsDao dao=new GiftsImp();
		return dao.findGiftById(id);
	}
}