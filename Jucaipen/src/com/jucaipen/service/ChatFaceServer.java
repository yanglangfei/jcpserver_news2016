package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.ChatFaceDao;
import com.jucaipen.daoimp.ChatFaceImp;
import com.jucaipen.model.ChatFace;

/**
 * @author Administrator
 * 
 * 
 *         �������
 */
public class ChatFaceServer {

	/**
	 * @return ��ȡ�����������
	 */
	public static List<ChatFace> findAllFace() {
		ChatFaceDao dao = new ChatFaceImp();
		return dao.findAll();
	}

	/**
	 * @param id
	 * @return  ����id��ѯ������Ϣ
	 */
	public static ChatFace findFaceById(int id) {
		ChatFaceDao dao = new ChatFaceImp();
		return dao.findFaceById(id);
	}

}
