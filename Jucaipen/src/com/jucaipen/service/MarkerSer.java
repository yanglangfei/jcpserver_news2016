package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.MarkerDao;
import com.jucaipen.daoimp.MarkerImp;
import com.jucaipen.model.Marker;

public class MarkerSer{

	/**
	 * @param id
	 * @return 根据id获取打赏信息
	 */
	public static Marker findMarkerById(int id) {
		MarkerDao dao=new MarkerImp();
		return dao.findMarkerById(id);
	}

	/**
	 * @param uId
	 * @param page
	 * @return 根据用户id获取打赏信息
	 */
	public static List<Marker> findMarkerByUserId(int uId, int page) {
		MarkerDao dao=new MarkerImp();
		return dao.findMarkerByUserId(uId, page);
	}

	/**
	 * @param type
	 * @param userId
	 * @param page
	 * @return 根据用户id获取分类下的打赏信息
	 */
	public static List<Marker> findMarkerByUserIdAndType(int type, int userId, int page) {
		MarkerDao dao=new MarkerImp();
		return dao.findMarkerByUserIdAndType(type, userId, page);
	}

	/**
	 * @param logId
	 * @param top
	 * @return 根据日志id获取打赏的最近几条记录
	 */
	public static List<Marker> findTopMarkerByLogId(int logId, int top) {
		MarkerDao dao=new MarkerImp();
		return dao.findTopMarkerByLogId(logId, top);
	}

	/**
	 * @param marker
	 * @return 添加打赏记录
	 */
	public static int addMarker(Marker marker) {
		MarkerDao dao=new MarkerImp();
		return dao.addMarker(marker);
	}

}
