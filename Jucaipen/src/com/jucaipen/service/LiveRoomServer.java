package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.LiveRoomDao;
import com.jucaipen.daoimp.LiveRoomImp;
import com.jucaipen.model.ChatRoom;

/**
 * @author Administrator ֱ����
 */
public class LiveRoomServer {

	/**
	 * @return ��ȡ����ֱ�����б�
	 */
	public static List<ChatRoom> getRoomList() {
		LiveRoomDao dao = new LiveRoomImp();
		return dao.getRoomList();
	}

	/**
	 * @param id
	 * @return   ����id ��ȡֱ������Ƶ��Ϣ
	 */
	public static ChatRoom getRoomLiveUrl(int id) {
		LiveRoomDao dao = new LiveRoomImp();
		return dao.getLiveUrl(id);
	}

}
