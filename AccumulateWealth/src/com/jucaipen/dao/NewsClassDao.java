package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.NewsClass;

public interface NewsClassDao {
	/**
	 * @return   ��ȡ���е�һ��������Ϣ
	 */
	public List<NewsClass>  findAllNewsClass();
	/**
	 * @param id
	 * @return   ͨ��id ��ѯ�����ȡ������Ϣ
	 */
	public List<NewsClass> findNewsClassByPId(int pId);
	
	/**
	 * @param id
	 * @return  ����id��ȡ������Ϣ
	 */
	public NewsClass findClassById(int id);

}
