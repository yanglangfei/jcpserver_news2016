package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.VideoLiveDao;
import com.jucaipen.daoimp.VideoLiveImp;
import com.jucaipen.model.VideoLive;

/**
 * @author Administrator ֱ����
 */
public class VideoLiveServer {

	/**
	 * @return ��ȡ����ֱ�����б�
	 */
	public static List<VideoLive> getRoomList() {
		VideoLiveDao dao = new VideoLiveImp();
		return dao.getRoomList();
	}

	/**
	 * @param id
	 * @return ����id ��ȡֱ������Ƶ��Ϣ
	 */
	public static VideoLive getRoomLiveUrl(int id) {
		VideoLiveDao dao = new VideoLiveImp();
		return dao.getLiveUrl(id);
	}

	/**
	 * @param page
	 * @return ��ȡ���е�ֱ����Ϣ
	 */
	public static List<VideoLive> findAll(int page) {
		VideoLiveDao dao = new VideoLiveImp();
		return dao.getAllRoom(page);
	}
	
	/**
	 * @param id
	 * @return  ����id��ȡֱ������Ϣ
	 */
	public static VideoLive getRoomInfo(int id){
		VideoLiveDao dao=new VideoLiveImp();
		return dao.getRoomInfo(id);
	}
	
	/**
	 * @param tId
	 * @return  ��ȡ��ʦ�µ�ֱ����Ϣ
	 */
	public static List<VideoLive> findLiveBytId(int tId){
		VideoLiveDao dao=new VideoLiveImp();
		return dao.findLiveBytId(tId);
	}
	
	public static int updateRenQi(int id,int renQi){
		VideoLiveDao dao=new VideoLiveImp();
		return dao.updateRenQi(id, renQi);
	}
	
	
	/**
	 * @param isEnd
	 * @return  ��ȡ����ֱ������Ƶ
	 */
	public static List<VideoLive>  findLiveByIsEnd(int isEnd){
		VideoLiveDao dao=new VideoLiveImp();
		return dao.findLiveByIsEnd(isEnd);
	}
	
}
