package com.jucaipen.dao;


import java.util.List;

import com.jucaipen.model.VideoColumn;

/**
 * @author Administrator
 *
 *  ֱ����Ŀ
 */
public interface VideoColnumnDao {
	
	/**
	 * @param id
	 * @return ͨ��id��ȡ��Ŀ����
	 */
	public VideoColumn findVideoColumnById(int id);
	
	/**
	 * @return ��ȡȫ������Ƶ��Ŀ
	 */
	public List<VideoColumn> findAllColumn();

}
