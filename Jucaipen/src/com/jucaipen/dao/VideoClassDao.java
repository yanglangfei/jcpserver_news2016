package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.VideoClass;

public interface VideoClassDao {
	
	/**
	 * @return  ��ȡȫ����Ƶ������Ϣ
	 */
	public List<VideoClass> findAll();
	/**
	 * @param id
	 * @return   ����id ��ȡ��Ƶ������Ϣ
	 */
	public VideoClass findClassById(int id);
	
	/**
	 * @param pId
	 * @return  ���ݸ��������ȡ��Ϣ
	 */
	public List<VideoClass>  findClassByPid(int pId);
	
	

}
