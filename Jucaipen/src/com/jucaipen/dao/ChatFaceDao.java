package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ChatFace;

/**
 * @author Administrator
 *
 *
 *   �������
 */
public interface ChatFaceDao {
	
	/**
	 * @return  ��ȡ�����������
	 */
	public List<ChatFace> findAll();
	
	/**
	 * @param id
	 * @return  ����id��ѯ�������
	 */
	public ChatFace findFaceById(int id);

}
