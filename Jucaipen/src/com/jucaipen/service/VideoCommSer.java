package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.VideoCommDao;
import com.jucaipen.daoimp.VideoCommImp;
import com.jucaipen.model.VideoComm;

public class VideoCommSer {

	/**
	 * @param uId
	 * @return �����û�id��ѯ��ǰ�û��µ���Ƶ������Ϣ
	 */
	public static List<VideoComm> findVideoCommByUid(int uId) {
		VideoCommDao dao = new VideoCommImp();
		return dao.findVideoCommByUid(uId);
	}

	/**
	 * @param videoId
	 * @return ������Ƶid ����ѯ��ǰ��Ƶ�µ�������Ϣ
	 */
	public static List<VideoComm> findVideoCommByVid(int videoId) {
		VideoCommDao dao = new VideoCommImp();
		return dao.findVideoCommByVid(videoId);
	}

	/**
	 * @param isShow
	 * @return ��ѯ�Ƿ���ʾ����Ƶ����
	 */
	public static List<VideoComm> findVideoByIsShow(int isShow) {
		VideoCommDao dao = new VideoCommImp();
		return dao.findVideoCommByIsShow(isShow);
	}

	/**
	 * @param id
	 * @return ����id����ѯ��Ƶ������ϸ��Ϣ
	 */
	public static VideoComm findVideoCommById(int id) {
		VideoCommDao dao = new VideoCommImp();
		return dao.findVideoCommById(id);
	}

	/**
	 * @return ��ѯ���е���Ƶ����
	 */
	public static List<VideoComm> findAll() {
		VideoCommDao dao = new VideoCommImp();
		return dao.findAll();
	}

}
