package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.NewsClass;

public interface NewsClassDao {
	/**
	 * @return   获取所有的一级分类信息
	 */
	public List<NewsClass>  findAllBigClass();
	/**
	 * @param id
	 * @return   通过id 查询一级分类详细信息
	 */
	public List<NewsClass> findBigClassById(int id);

}
