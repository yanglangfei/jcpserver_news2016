package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ResourceSources;

public interface ResourceFromDao {
	/**
	 * @return  ��ѯ������Ϣ��Դ
	 */
	public List<ResourceSources> findAll(int pager);
	/**
	 * @param id
	 * @return  ��ѯָ����Ϣ��Դ
	 */
	public ResourceSources findResourceSources(int id);

}
