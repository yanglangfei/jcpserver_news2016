package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.MessageModel;

/**
 * @author YLF
 * 
 *   ��Ϣģ��
 *
 */
public interface MessageModelDao {
	
	/**
	 *   ��ѯ���е�ģ����Ϣ
	 */
	public List<MessageModel> querryAllModel();
	
	/**
	 * @param id
	 * @return  ����id��ȡģ����Ϣ
	 */
	public MessageModel findModelById(int id);

}
