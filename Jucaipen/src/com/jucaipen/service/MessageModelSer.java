package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.MessageModelDao;
import com.jucaipen.daoimp.MessageModelImp;
import com.jucaipen.model.MessageModel;

public class MessageModelSer{

	/**
	 * @return  ��ȡ���ж�������
	 */
	public static List<MessageModel> querryAllModel() {
		MessageModelDao dao=new MessageModelImp();
		return dao.querryAllModel();
	}

	/**
	 * @param id
	 * @return  ����id��ȡ��������
	 */
	public static MessageModel findModelById(int id) {
		MessageModelDao dao=new MessageModelImp();
		return dao.findModelById(id);
	}
	

}
