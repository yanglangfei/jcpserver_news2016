package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.VideoLiveMsg;

/**
 * @author Administrator
 *
 *  直播互动消息
 */
public interface VideoLiveMsgDao {
	
	/**
	 * @param count
	 * @param liveId
	 * @return  获取指定直播聊天最近的几条记录
	 */
	public List<VideoLiveMsg> findLastLiveMsg(int count,int liveId);
	
	/**
	 * @param msg
	 * @return  添加聊天信息
	 */
	public int addMsg(VideoLiveMsg msg);
	

}
