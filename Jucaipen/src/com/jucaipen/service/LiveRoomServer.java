package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.LiveRoomDao;
import com.jucaipen.daoimp.LiveRoomImp;
import com.jucaipen.model.VideoLive;

/**
 * @author Administrator 直播室
 */
public class LiveRoomServer {

	/**
	 * @return 获取所有直播间列表
	 */
	public static List<VideoLive> getRoomList() {
		LiveRoomDao dao = new LiveRoomImp();
		return dao.getRoomList();
	}

	/**
	 * @param id
	 * @return   根据id 获取直播间视频信息
	 */
	public static VideoLive getRoomLiveUrl(int id) {
		LiveRoomDao dao = new LiveRoomImp();
		return dao.getLiveUrl(id);
	}

}
