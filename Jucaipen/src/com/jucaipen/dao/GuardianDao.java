package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Guardian;

/**
 * @author Administrator
 *
 *  守护者 
 */
public interface GuardianDao {
	
	/**
	 * @param id
	 * @return 根据id获取守护者信息
	 */
	public Guardian findGuardianById(int id);
	
	/**
	 * @param userId
	 * @return 通过用户id获取我守护的信息
	 */
	public List<Guardian> findGurdianByUid(int userId,int page);
	
	/**
	 * @param teacherId
	 * @return 通过讲师id获取守护我的信息
	 */
	public List<Guardian> findGuradianByTeacherId(int teacherId,int page);
	
	/**
	 * @param guardian
	 * @return 添加守护信息
	 */
	public int addGuardian(Guardian guardian);

}
