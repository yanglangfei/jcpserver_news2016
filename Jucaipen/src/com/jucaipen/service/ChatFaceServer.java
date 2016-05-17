package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.ChatFaceDao;
import com.jucaipen.daoimp.ChatFaceImp;
import com.jucaipen.model.ChatFace;

/**
 * @author Administrator
 * 
 * 
 *         聊天表情
 */
public class ChatFaceServer {

	/**
	 * @return 获取所有聊天表情
	 */
	public static List<ChatFace> findAllFace() {
		ChatFaceDao dao = new ChatFaceImp();
		return dao.findAll();
	}

	/**
	 * @param id
	 * @return  根据id查询表情信息
	 */
	public static ChatFace findFaceById(int id) {
		ChatFaceDao dao = new ChatFaceImp();
		return dao.findFaceById(id);
	}

}
