package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.MyVideo;

/**
 * @author Administrator
 *
 *  �ҵ���Ƶ
 */
public interface MyVideoDao {
	
	/**
	 * @param id
	 * @return  ͨ��id��ȡ��Ƶ��Ϣ
	 */
	public MyVideo findVideoById(int id);
	
	/**
	 * @param userId
	 * @param page
	 * @return �����û�id��ȡ�ҵ���Ƶ��Ϣ
	 */
	public List<MyVideo> findMyVideoByUserId(int userId,int page);
	
	/**
	 * @param video
	 * @return ����ҵ���Ƶ��Ϣ
	 */
	public int addMyVideo(MyVideo video);
	/**
	 * @param id
	 * @return ɾ���ҵ���Ƶ��¼
	 */
	public int removeMyVideo(int id);
	

}
