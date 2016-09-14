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
	public List<VideoLiveMsg> findLastLiveMsg(int count,int liveId,boolean isCheck);
	/**
	 * @param maxId
	 * @param liveId
	 * @param isCheck
	 * @return  ��������idʵʱ��ȡ���µ�������Ϣ
	 */
	public List<VideoLiveMsg>  findLiveMsgByMaxId(int maxId,int liveId,boolean isCheck);
	
	/**
	 * @param msg
	 * @return  ���������Ϣ
	 */
	public int addMsg(VideoLiveMsg msg);
	

}
