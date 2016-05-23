package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Rebate;

public interface RebateDao {
	
	/**
	 * @param id
	 * @return 通过id获取返利信息
	 */
	public  Rebate findRebateById(int id);
	
	/**
	 * @param teacherId
	 * @return 根据讲师获取返利信息
	 */
	public List<Rebate> findRebateByTid(int teacherId,int page);
	
	/**
	 * @param rebate
	 * @return 添加返利记录
	 */
	public int addRebate(Rebate rebate);

}
