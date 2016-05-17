package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.NewsSmallClass;


public interface NewSmallDao {
	/**
	 * @return   ��ȡ���ж���������Ϣ
	 */
	public List<NewsSmallClass>  findAllSmallClass();
	/**
	 * @param bigId
	 * @return    ����һ�������ȡ����������Ϣ
	 */
	public List<NewsSmallClass>  findSmallClassByBigId(int bigId);
	/**
	 * @param id
	 * @return   ����id��ȡ����������Ϣ
	 */
	public NewsSmallClass findSmallClassById(int id);
	
	
	/**
	 * @param id
	 * @param bigId
	 * @return  ����һ��������id��ȡ������Ϣ
	 */
	public NewsSmallClass findSmallClassBySidAndBigId(int id,int bigId);

}
