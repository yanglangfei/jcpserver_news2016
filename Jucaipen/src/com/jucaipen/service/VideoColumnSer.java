package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.VideoColnumnDao;
import com.jucaipen.daoimp.VideoColumnImp;
import com.jucaipen.model.VideoColumn;

/**
 * @author Administrator
 *
 *  ֱ����Ŀ
 */
public class VideoColumnSer {

	/**
	 * @param id
	 * @return ����id��ȡ��Ŀ��Ϣ
	 */
	public static VideoColumn findVideoColumnById(int id) {
		VideoColnumnDao dao=new VideoColumnImp();
		return dao.findVideoColumnById(id);
	}

	/**
	 * @return ��ȡ���е�ֱ����Ŀ��Ϣ
	 */
	public static List<VideoColumn> findAllColumn() {
		VideoColnumnDao dao=new VideoColumnImp();
		return dao.findAllColumn();
	}

}
