package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.SysMessageDao;
import com.jucaipen.daoimp.SysMessageImp;
import com.jucaipen.model.SysMessage;

/**
 * @author Administrator
 * 
 *         ϵͳ��Ϣ
 */
public class SysMessageSer {

	/**
	 * @param id
	 * @return ����id��ȡϵͳ��Ϣ
	 */
	public static SysMessage findMessageById(int id) {
		SysMessageDao dao = new SysMessageImp();
		return dao.findMessageById(id);
	}

	/**
	 * @param senderId
	 * @param page
	 * @return ��ȡ�ҷ��͵�ϵͳ��Ϣ
	 */
	public static List<SysMessage> findMessageBySenderId(int senderId, int page) {
		SysMessageDao dao = new SysMessageImp();
		return dao.findMessageBySenderId(senderId, page);
	}

	public static List<SysMessage> findMessageByReceiverIdAndMaxId(
			int receiverId, int maxId) {
		SysMessageDao dao = new SysMessageImp();
		return dao.findMessageByReceiverIdAndMaxId(receiverId, maxId);
	}

	public static List<SysMessage> findMessageBySenderIdAndMaxId(int senderId,
			int maxId) {
		SysMessageDao dao = new SysMessageImp();
		return dao.findMessageBySenderIdAndMaxId(senderId, maxId);
	}

	/**
	 * @param receiverId
	 * @param page
	 * @return ��ȡ�ҽ��յ���ϵͳ��Ϣ
	 */
	public static List<SysMessage> findMessageByReceiverId(int receiverId,
			int page) {
		SysMessageDao dao = new SysMessageImp();
		return dao.findMessageByReceiverId(receiverId, page);
	}

}
