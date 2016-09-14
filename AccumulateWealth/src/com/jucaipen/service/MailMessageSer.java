package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.MailMessageDao;
import com.jucaipen.daoimp.MailMessageImp;
import com.jucaipen.model.MailMessage;

public class MailMessageSer{

	/**
	 * @param mailMessage
	 * @return  ����ʼ�
	 */
	public static int insertMessage(MailMessage mailMessage) {
		MailMessageDao dao=new MailMessageImp();
		return dao.insertMessage(mailMessage);
	}

	/**
	 * @param id
	 * @param msg
	 * @return  ����  id �޸��ʼ�״̬
	 */
	public static int upDateMessageType(int id,MailMessage msg) {
		MailMessageDao dao=new MailMessageImp();
		return dao.upDateMessageType(id,msg);
	}

	/**
	 * @param uId
	 * @param count
	 * @return   �����û�id��ȡ����յ���Email
	 */
	public static List<MailMessage> findMailMessageByLastCount(int uId, int count) {
		MailMessageDao dao=new MailMessageImp();
		return dao.findMailMessageByLastCount(uId, count);
	}

	/**
	 * @param email
	 * @return  ����Email��ȡ�ʼ�
	 */
	public static List<MailMessage> findMailMessageByEmail(String email) {
		MailMessageDao dao=new MailMessageImp();
		return dao.findMailMessageByEmail(email);
	}

	/**
	 * @param uId
	 * @return  �����û�id��ȡ�ʼ�
	 */
	public static List<MailMessage> findMailMessageByUserId(int uId) {
		MailMessageDao dao=new MailMessageImp();
		return dao.findMailMessageByUserId(uId);
	}

}
