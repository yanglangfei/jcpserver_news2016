package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.FamousTeacher;

public interface FamousTeacherDao {
	
	/**
	 * @param condition
	 * @return 获取名师信息总页数
	 */
	public int findTotlePage(String condition);
	
	/**
	 * @return  获取所有粉丝数量
	 */
	public List<FamousTeacher> findIndexData();
	
	/**
	 * @return 获取所有名师信息
	 */
	public List<FamousTeacher> findAllFamousTeacher(int page);
	
	/**
	 * @param count
	 * @return 获取推荐的几名讲师
	 */
	public List<FamousTeacher>  findFamousTeacherByIndex(int count);
	
	/**
	 * @param id
	 * @return 根据id获取名师信息
	 */
	public FamousTeacher findFamousTeacherById(int id);
	
	/**
	 * @param id
	 * @return  获取最大提问数
	 */
	public int findMaxAsk(int id);
	

}
