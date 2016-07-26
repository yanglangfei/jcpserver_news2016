package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Gifts;

/**
 * @author Administrator
 *
 *   礼品
 */
public interface GiftsDao {
	
	/**
	 * @return  获取所有礼品
	 */
	public List<Gifts>  findAllGift(int page);
	
	/**
	 * @param page
	 * @return 根据分类id获取礼品信息
	 */
	public List<Gifts> findGiftByClassId(int page,int classId);
	
	/**
	 * @param id
	 * @return 根据id获取礼品信息
	 */
	public Gifts findGiftById(int id);
	
	public List<Gifts> findIsTuijian(int IsTuiJian);
	

}
