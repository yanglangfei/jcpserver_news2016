package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.VideoLiveMsgDao;
import com.jucaipen.daoimp.VideoLiveMsgImp;
import com.jucaipen.model.VideoLiveMsg;

public class VideoLiveMsgSer{

	/**
	 * @param count
	 * @param liveId
	 * @param isCheck
	 * @return  ��ȡ����������¼
	 */
	public static List<VideoLiveMsg> findLastLiveMsg(int count, int liveId,
			boolean isCheck) {
		VideoLiveMsgDao dao=new VideoLiveMsgImp();
		return dao.findLastLiveMsg(count, liveId, isCheck);
	}
	
	/**
	 * @param maxId
	 * @param liveId
	 * @param isCheck
	 * @return   ��ȡ�����������Ϣ
	 */
	public static List<VideoLiveMsg>  findVideoMsgByMaxId(int maxId,int liveId,boolean isCheck){
		VideoLiveMsgDao dao=new VideoLiveMsgImp();
		return dao.findLiveMsgByMaxId(maxId, liveId, isCheck);
	}

	/**
	 * @param msg
	 * @return ��������¼
	 */
	public static int addMsg(VideoLiveMsg msg) {
		VideoLiveMsgDao dao=new VideoLiveMsgImp();
		return dao.addMsg(msg);
	}

}
