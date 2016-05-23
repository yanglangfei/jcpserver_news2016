package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.SignDetail;

public interface SignDetailDao {
	
	/**
	 * @param userId
	 * @param page
	 * @return 根据用户id获取签到信息
	 */
	public List<SignDetail> findSignDetailByUserId(int userId,int page);
	/**
	 * @param detail
	 * @return 添加签到详细信息
	 */
	public int addSignDetail(SignDetail detail);

}
