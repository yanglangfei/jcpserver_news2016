package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Fans;


/**
 * @author Administrator
 *
 *  粉丝
 */
public interface FansDao {
	
	/**
	 * @param userId
	 * @return 根据用户id获取粉丝信息
	 */
	public List<Fans> findFansByUid(int userId,int page);
	
	/**
	 * @param teacherId
	 * @return  根据讲师id获取粉丝信息
	 */
	public List<Fans> findFansByTeacherId(int teacherId,int page);
	
	/**
	 * @param id
	 * @return 根据id获取粉丝信息
	 */
	public Fans findFansById(int id);

}
