package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Advertive;


/**
 * @author Administrator
 *
 *  ���
 */
public interface AdverticeDao {

	/**
	 * @return ��ѯ���й��
	 */
	public List<Advertive> findAll();

	/**
	 * @param pId
	 * @return ���������õ�id��ѯ���
	 */
	public List<Advertive> findAdByPid(int pId);
}