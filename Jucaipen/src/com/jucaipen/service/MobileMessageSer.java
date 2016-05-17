package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.MobileMessageDao;
import com.jucaipen.daoimp.MobileMessageImp;
import com.jucaipen.model.MobileMessage;

public class MobileMessageSer{

	/**
	 * @param message
	 * @return  ��Ӷ���
	 */
	public static int insertMessage(MobileMessage message) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.insertMessage(message);
	}

	/**
	 * @param id
	 * @param message
	 * @return  �޸Ķ�����֤״̬
	 */
	public static int upDateMessageType(String msgId, MobileMessage message) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.upDateMessageType(msgId, message);
	}
	
	/**
	 * @param msgId
	 * @param message
	 * @return  �޸Ķ���״̬ --��֤ʧ��
	 */
	public static int upDateMessageFailType(String msgId, MobileMessage message){
		MobileMessageDao dao=new MobileMessageImp();
		return dao.upDateMessageFailType(msgId, message);
	}

	/**
	 * @param telPhone
	 * @return  �����ֻ��Ż�ȡ���н��ܶ���
	 */
	public static List<MobileMessage> findMobileMessgageByMobileNum(String telPhone) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.findMobileMessgageByMobileNum(telPhone);
	}

	/**
	 * @param count
	 * @param mobile
	 * @return �����ֻ��Ż�ȡ������ܵ��ļ�������
	 */
	public static List<MobileMessage> findMobileMessageByMobileNumLast(int count,
			String mobile) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.findMobileMessageByMobileNumLast(count, mobile);
	}}
