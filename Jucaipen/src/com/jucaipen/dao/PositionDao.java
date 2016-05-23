package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Position;

/**
 * @author Administrator
 *
 *  岗位
 */
public interface PositionDao {
	
	/**
	 * @param id
	 * @return 通过id获取岗位信息
	 */
	public Position findPositionById(int id);
	
	/**
	 * @return 获取所有岗位信息
	 */
	public List<Position> findAll();

}
