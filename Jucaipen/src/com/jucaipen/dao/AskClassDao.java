package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.AskClass;

public interface AskClassDao {
	
	/**
	 * @return 获取所有分类信息
	 */
	public List<AskClass> findAllClass();
	/**
	 * @param id
	 * @return 根据分类你id获取分类信息
	 */
	public AskClass findAskClassById(int id);

}
