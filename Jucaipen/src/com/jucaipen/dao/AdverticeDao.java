package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Advertive;


public interface AdverticeDao {

	/**
	 * @return 查询所有广告
	 */
	public List<Advertive> findAll();

	/**
	 * @param pId
	 * @return 根据所属幻灯id查询广告
	 */
	public List<Advertive> findAdByPid(int pId);
}
