package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.VideoTypeDao;
import com.jucaipen.daoimp.VideoTypeImp;
import com.jucaipen.model.VideoType;

public class VideoTypeSer {
	/**
	 * @return ��ȡ������Ƶ������Ϣ
	 */
	public static List<VideoType> findAll() {
		VideoTypeDao dao = new VideoTypeImp();
		return dao.findAll();
	}

	/**
	 * @param id
	 * @return ����id ��ѯ������Ϣ
	 */
	public static VideoType findTypeById(int id) {
		VideoTypeDao dao = new VideoTypeImp();
		return dao.findTypeById(id);
	}
}
