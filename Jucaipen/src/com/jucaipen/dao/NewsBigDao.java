package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.NewsBigClass;

public interface NewsBigDao {
	/**
	 * @return   ��ȡ���е�һ��������Ϣ
	 */
	public List<NewsBigClass>  findAllBigClass();
	/**
	 * @param id
	 * @return   ͨ��id ��ѯһ��������ϸ��Ϣ
	 */
	public List<NewsBigClass> findBigClassById(int id);

}
