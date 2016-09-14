package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.StudioGuestDao;
import com.jucaipen.daoimp.StudioGuestImp;
import com.jucaipen.model.StudioGuest;

/**
 * @author Administrator
 *
 *  �ݲ��Ҽα�
 */
public class StudioGuestSer{

	/**
	 * @param page
	 * @param studioId
	 * @return  ��ȡ�ݲ������еļα�
	 */
	public static List<StudioGuest> findAll(int page, int studioId) {
		StudioGuestDao dao=new StudioGuestImp();
		return dao.findAll(page, studioId);
	}

	/**
	 * @param id
	 * @return ����id��ȡ�α���Ϣ
	 */
	public static StudioGuest findGuestById(int id) {
		StudioGuestDao dao=new StudioGuestImp();
		return dao.findGuestById(id);
	}

	/**
	 * @param top
	 * @param studioId
	 * @return ��ȡ�ݲ�������ļα�
	 */
	public static List<StudioGuest> findTopGuest(int top, int studioId) {
		StudioGuestDao dao=new StudioGuestImp();
		return dao.findTopGuest(top, studioId);
	}

}
