package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.LinkUrl;

/**
 * @author Administrator
 *
 *  ����URL
 */
public interface LinkUrlDao {
	
	/**
	 * @param id
	 * @return ͨ��id��ȡ���ӵ�ַ
	 */
	public LinkUrl findUrlById(int id);
	
	/**
	 * @return ��ȡ�������ӵ�ַ
	 */
	public List<LinkUrl> findAll();

}
