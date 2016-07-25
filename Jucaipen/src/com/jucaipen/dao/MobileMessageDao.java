package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.MobileMessage;

/**
 * @author YLF
 * 
 *    �ֻ�����
 *
 */
public interface MobileMessageDao {
	
	/**
	 * @param message
	 * @return  ���Ͷ���
	 */
	public int insertMessage(MobileMessage message);
	
	/**
	 * @param tel
	 * @param code
	 * @return  ��ȡ�ֻ��ŷ��͵Ķ�Ӧ���һ����֤��       
	 */
	public MobileMessage findIsRegin(String tel,String code);
	
	/**
	 * @param type
	 * @return  ����id�ı����״̬  --�ɹ�
	 */
	public int upDateMessageType(String msgId,MobileMessage message);
	
	/**
	 * @param msgId
	 * @param message
	 * @return  ����id�޸�״̬  --Fail ʧ��
	 */
	public int upDateMessageFailType(String msgId,MobileMessage message);
	
	/**
	 * @param telPhone
	 * @return  ͨ���ֻ��Ų�ѯ����
	 */
	public List<MobileMessage> findMobileMessgageByMobileNum(String telPhone);
	
	/**
	 * @param count
	 * @param mobile
	 * @return  �����ֻ��Ų�ѯ����Ķ�������
	 */
	public List<MobileMessage> findMobileMessageByMobileNumLast(int count,String mobile);

}
