package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.SysMessage;

/**
 * @author Administrator
 *
 *  ϵͳ��Ϣ
 */
public interface SysMessageDao {
	 /**
	 * @param id
	 * @return ����id��ȡϵͳ��Ϣ
	 */
	public SysMessage findMessageById(int id);
	
	/**
	 * @param senderId
	 * @return ��ȡ�ҷ��͵���Ϣ
	 */
	public List<SysMessage> findMessageBySenderId(int senderId,int page);
	
	/**
	 * @param receiverId
	 * @return ��ȡ�ҽ��ܵ���ϵͳ��Ϣ
	 */
	public List<SysMessage> findMessageByReceiverId(int receiverId,int page);
	

}
