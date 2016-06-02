package com.jucaipen.dao;

import com.jucaipen.model.TacticsDetails;

/**
 * @author Administrator
 *
 *  战法详细信息
 */
public interface TacticsDetailsDao {
	
	/**
	 * @param id
	 * @return 根据id获取详细信息
	 */
	public TacticsDetails findDetailsById(int id);
	
	/**
	 * @param fkId
	 * @return  根据战法id获取详细信息
	 */
	public TacticsDetails findDetailsByFkId(int fkId);
	
	

}
