package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.VideoLive;
/**
 * @author YLF
 * 
 *   ֱ����
 *
 */
public interface LiveRoomDao {
	
	/**
	 * @return   ��ȡ���з�������
	 */
	public List<VideoLive> getRoomList();
	/**
	 * @param id
	 * @return  ����id ��ȡ������ϸ��Ϣ
	 */
	public VideoLive getRoomInfo(int id);
	
	/**
	 * @param id
	 * @return  ����id ��ȡ��Ƶ����URL
	 */
	public VideoLive  getLiveUrl(int id);
	
	/**
	 * @return   ��ȡ���з�����Ϣ
	 */
	public List<VideoLive> getAllRoom(int page);

}
