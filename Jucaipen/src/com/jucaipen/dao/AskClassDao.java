package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.AskClass;

public interface AskClassDao {
	
	/**
	 * @return ��ȡ���з�����Ϣ
	 */
	public List<AskClass> findAllClass();
	/**
	 * @param id
	 * @return ���ݷ�����id��ȡ������Ϣ
	 */
	public AskClass findAskClassById(int id);

}
