package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TxtMsgDao;
import com.jucaipen.daoimp.LiveMsgImp;
import com.jucaipen.model.LiveMsg;

public class LiveInteractiveSer{

	/**
	 * @param interactive
	 * @return  添加直播互动
	 */
	public static int insertLiveInteractive(LiveMsg interactive) {
		TxtMsgDao dao=new LiveMsgImp();
		return dao.insertLiveInteractive(interactive);
	}

	/**
	 * @return  获取所有直播互动
	 */
	public static List<LiveMsg> findAll() {
		TxtMsgDao dao=new LiveMsgImp();
		return dao.findAll();
	}

	/**
	 * @param userId
	 * @return  根据用户id获取直播互动
	 */
	public static List<LiveMsg> findByUserId(int userId) {
		TxtMsgDao dao=new LiveMsgImp();
		return dao.findByUserId(userId);
	}

	/**
	 * @param liveId
	 * @return  根据直播id获取直播互动
	 */
	public static List<LiveMsg> findByLiveId(int liveId,int page) {
		TxtMsgDao dao=new LiveMsgImp();
		return dao.findByLiveId(liveId,page);
	}

	public List<LiveMsg> findByUidAndLiveId(int uId, int liveId) {
		TxtMsgDao dao=new LiveMsgImp();
		return dao.findByUidAndLiveId(uId, liveId);
	}

	/**
	 * @param id
	 * @return  根据id获取直播互动详细信息
	 */
	public LiveMsg findById(int id) {
		TxtMsgDao dao=new LiveMsgImp();
		return dao.findById(id);
	}

}
