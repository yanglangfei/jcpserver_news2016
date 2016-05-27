package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.LiveRoomDao;
import com.jucaipen.daoimp.LiveRoomImp;
import com.jucaipen.model.VideoLive;

/**
 * @author Administrator ֱ����
 */
public class LiveRoomServer {

	/**
	 * @return ��ȡ����ֱ�����б�
	 */
	public static List<VideoLive> getRoomList() {
		LiveRoomDao dao = new LiveRoomImp();
		return dao.getRoomList();
	}

	/**
	 * @param id
	 * @return ����id ��ȡֱ������Ƶ��Ϣ
	 */
	public static VideoLive getRoomLiveUrl(int id) {
		LiveRoomDao dao = new LiveRoomImp();
		return dao.getLiveUrl(id);
	}

	/**
	 * @param page
	 * @return ��ȡ���е�ֱ����Ϣ
	 */
	public static List<VideoLive> findAll(int page) {
		LiveRoomDao dao = new LiveRoomImp();
		return dao.getAllRoom(page);
	}
}
