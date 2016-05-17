package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.VideoComm;

public interface VideoCommDao {
	
	/**
	 * @return  ��ѯ������Ƶ����
	 */
	public List<VideoComm> findAll();
	/**
	 * @param uId
	 * @return  �����û�id��ѯ������Ƶ����
	 */
	public List<VideoComm>  findVideoCommByUid(int uId);
	/**
	 * @param videoId
	 * @return    ��ѯ��ǰ��Ƶ�µ���������
	 */
	public List<VideoComm> findVideoCommByVid(int videoId);
	/**
	 * @param id
	 * @return   ����id��ѯ��Ƶ������ϸ��Ϣ
	 */
	public VideoComm findVideoCommById(int id);
	/**
	 * @param isShow
	 * @return   ��ѯ��ʾ������ʾ����Ƶ����
	 */
	public List<VideoComm> findVideoCommByIsShow(int isShow);

}
