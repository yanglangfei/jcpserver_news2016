package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Province;

public interface ProvinceDao {
	/**
	 * @return  ��ѯ����ʡ����Ϣ
	 */
	public List<Province> findAll();
	/**
	 * @param id
	 * @return  ����id��ѯʡ����Ϣ
	 */
	public Province findProvince(int id);

}
