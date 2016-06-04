package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.VideoLive;
/**
 * @author YLF
 * 
 *   直播室
 *
 */
public interface VideoLiveDao {
	
	/**
	 * @return   获取所有房间名称
	 */
	public List<VideoLive> getRoomList();
	/**
	 * @param id
	 * @return  根据id 获取房间详细信息
	 */
	public VideoLive getRoomInfo(int id);
	
	/**
	 * @param id
	 * @return  根据id 获取视频播放URL
	 */
	public VideoLive  getLiveUrl(int id);
	
	/**
	 * @return   获取所有房间信息
	 */
	public List<VideoLive> getAllRoom(int page);
	
	/**
	 * @param tId
	 * @return  获取讲师下的视频直播
	 */
	public List<VideoLive>  findLiveBytId(int tId);

}
