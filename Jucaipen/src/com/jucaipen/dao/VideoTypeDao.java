package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.VideoType;

public interface VideoTypeDao {
	/**
	 * @return  ��ȡȫ����Ƶ������Ϣ
	 */
	public List<VideoType> findAll();
	/**
	 * @param id
	 * @return   ����id ��ȡ��Ƶ������Ϣ
	 */
	public VideoType findTypeById(int id);
	/**
	 * @param isDelete
	 * @return   ��ѯ��Ƶ�����Ƿ�ɾ��
	 */
	public List<VideoType> findTypeByIsDelete(int isDelete);
	

}
