package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.NewsClass;

public interface NewsClassDao {
	/**
	 * @return   ��ȡ���е�һ��������Ϣ
	 */
	public List<NewsClass>  findAllBigClass();
	/**
	 * @param id
	 * @return   ͨ��id ��ѯһ��������ϸ��Ϣ
	 */
	public List<NewsClass> findBigClassById(int id);

}
