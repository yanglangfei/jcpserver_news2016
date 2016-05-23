package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.MyVideoDao;
import com.jucaipen.daoimp.MyVideoImp;
import com.jucaipen.model.MyVideo;

public class MyVideoSer {

	/**
	 * @param id
	 * @return ����id��ȡ�ҵ���Ƶ��Ϣ
	 */
	public static MyVideo findVideoById(int id) {
		MyVideoDao dao=new MyVideoImp();
		return dao.findVideoById(id);
	}

	/**
	 * @param userId
	 * @param page
	 * @return  �����û�id��ȡ�ҵ���Ƶ��Ϣ
	 */
	public static List<MyVideo> findMyVideoByUserId(int userId, int page) {
		MyVideoDao dao=new MyVideoImp();
		return dao.findMyVideoByUserId(userId, page);
	}

	/**
	 * @param video
	 * @return �����Ƶ��Ϣ
	 */
	public static int addMyVideo(MyVideo video) {
		MyVideoDao dao=new MyVideoImp();
		return dao.addMyVideo(video);
	}

	/**
	 * @param id
	 * @return ɾ����Ƶ��Ϣ
	 */
	public static int removeMyVideo(int id) {
		MyVideoDao dao=new MyVideoImp();
		return dao.removeMyVideo(id);
	}

}
