package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.VideoLiveMsg;

/**
 * @author Administrator
 *
 *  ֱ��������Ϣ
 */
public interface VideoLiveMsgDao {
	
	/**
	 * @param count
	 * @param liveId
	 * @return  ��ȡָ��ֱ����������ļ�����¼
	 */
	public List<VideoLiveMsg> findLastLiveMsg(int count,int liveId);
	
	/**
	 * @param msg
	 * @return  ���������Ϣ
	 */
	public int addMsg(VideoLiveMsg msg);
	

}
