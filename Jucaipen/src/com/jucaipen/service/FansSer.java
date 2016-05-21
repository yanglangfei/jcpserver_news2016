package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.FansDao;
import com.jucaipen.daoimp.FansImp;
import com.jucaipen.model.Fans;

/**
 * @author Administrator
 *
 * 粉丝信息
 */
public class FansSer {

	/**
	 * @param userId
	 * @param page
	 * @return 根据用户id获取粉丝信息
	 */
	public static List<Fans> findFansByUid(int userId, int page) {
		FansDao dao=new FansImp();
		return dao.findFansByUid(userId, page);
	}

	/**
	 * @param teacherId
	 * @param page
	 * @return 根据讲师id获取粉丝信息
	 */
	public static List<Fans> findFansByTeacherId(int teacherId, int page) {
		FansDao dao=new FansImp();
		return dao.findFansByTeacherId(teacherId, page);
	}

	/**
	 * @param id
	 * @return 根据id获取粉丝信息
	 */
	public static Fans findFansById(int id) {
		FansDao dao=new FansImp();
		return dao.findFansById(id);
	}

}
