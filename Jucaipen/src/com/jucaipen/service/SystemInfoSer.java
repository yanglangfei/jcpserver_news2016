package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.SysInfoDao;
import com.jucaipen.daoimp.SysInfoImp;
import com.jucaipen.model.SystemInfo;

public class SystemInfoSer {
	/**
	 * @return 查询所有的信息
	 */
	public static List<SystemInfo> findAllInfo(int page) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findAll(page);
	}

	/**
	 * @param id
	 * @return 根据id获取所有的信息
	 */
	public static SystemInfo findInfoById(int id) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findSystemInfo(id);
	}

	/**
	 * @param reId
	 * @param page
	 * @return 根据收件人id查询用户的收件箱
	 */
	public static List<SystemInfo> findInfoByReceiveId(int reId, int page) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findInfoByReceiver(reId, page);
	}
	/**
	 * @param sendId
	 * @param page
	 * @return   根据发件人id 查询用户的发件箱
	 */
	public static List<SystemInfo> findInfoBySendId(int sendId,int page){
		SysInfoDao dao=new SysInfoImp();
		return dao.findInfoBySender(sendId, page);
	}
	
	/**
	 * @param userId
	 * @param page
	 * @return   根据用户id获取系统消息
	 */
	public static List<SystemInfo> findInfoByUserId(int userId,int page){
		SysInfoDao dao=new SysInfoImp();
		return dao.findAllSystemInfoByUserId(userId, page);
	}
}
