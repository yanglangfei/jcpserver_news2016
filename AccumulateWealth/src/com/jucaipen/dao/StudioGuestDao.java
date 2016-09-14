package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.StudioGuest;

/**
 * @author Administrator
 *  �ݲ��Ҽα�
 */
public interface StudioGuestDao {
	
	/**
	 * @param page
	 * @return ��ȡ�ݲ������мα���Ϣ
	 */
	public List<StudioGuest> findAll(int page,int studioId);
	
	/**
	 * @param id
	 * @return ����id ��ȡ�α���Ϣ
	 */
	public StudioGuest findGuestById(int id);
	
	/**
	 * @param top
	 * @param studioId
	 * @return ��ȡ�ݲ�������ļ����α�
	 */
	public List<StudioGuest> findTopGuest(int top,int studioId);

}
