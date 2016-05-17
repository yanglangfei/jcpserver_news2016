package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.MailMessage;

/**
 * @author YLF
 * eMAU
 *    �ʼ���Ϣ
 *
 */
public interface MailMessageDao {
	
	/**
	 * @param count
	 * @return  ��ȡ����ļ����ʼ���Ϣ
	 */
	public List<MailMessage> findMailMessageByLastCount(int uId,int count);
	
	/**
	 * @param email
	 * @return  ����Email ��ѯ�ʼ���Ϣ
	 */
	public List<MailMessage> findMailMessageByEmail(String email);
	
	/**
	 * @param uId
	 * @return  �����û�id��ѯ�ʼ���Ϣ
	 */
	public List<MailMessage> findMailMessageByUserId(int uId);	
	/**
	 * @param mailMessage
	 * @return  �����ʼ���Ϣ
	 */
	public int insertMessage(MailMessage mailMessage);
	
	
	/**
	 * @param type
	 * @return   �ı��ʼ���Ϣ״̬
	 */
	public int upDateMessageType(int id,MailMessage msg);

}
