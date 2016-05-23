package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Special;

public interface SpecialDao {
	
	/**
	 * @param id
	 * @return ����id��ȡר����Ϣ
	 */
	public Special findSpecialById(int id);
	
	/**
	 * @param page
	 * @return ��ȡ����ר����Ϣ
	 */
	public List<Special> findAll(int page);

}
