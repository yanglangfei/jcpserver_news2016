package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Studio;

/**
 * @author Administrator
 *
 * 演播室
 */
public interface StudioDao {
	
	
	/**
	 * @return 获取所有演播室
	 */
	public List<Studio> findAll(int page);
	
	/**
	 * @param id
	 * @return 根据id获取演播室信息
	 */
	public Studio findStudioById(int id);
	
	/**
	 * @param columnId
	 * @return 根据；栏目id获取演播室信息
	 */
	public List<Studio> findStudioByColumnId(int columnId,int page);

}
