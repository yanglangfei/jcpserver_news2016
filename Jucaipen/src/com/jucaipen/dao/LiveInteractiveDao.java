package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.LiveInteractive;
/**
 * @author Administrator
 *
 *
 *   ֱ������
 */
public interface LiveInteractiveDao {
	
	/**
	 * @param interactive
	 * @return  ��ӻ���
	 */
	public int insertLiveInteractive(LiveInteractive interactive);
	
	/**
	 * @return  ��ȡ���л���
	 */
	public List<LiveInteractive> findAll();
	/**
	 * @param userId
	 * @return  �����û�id��ȡ�û�����
	 */
	public List<LiveInteractive> findByUserId(int userId);
	/**
	 * @param liveId
	 * @return  ����ֱ��id��ȡֱ��������Ϣ
	 */
	public List<LiveInteractive> findByLiveId(int liveId,int page);
	/**
	 * @param uId
	 * @param liveId
	 * @return �����û�id ֱ��id��ȡֱ��������Ϣ
	 */
	public List<LiveInteractive> findByUidAndLiveId(int uId,int liveId);
	/**
	 * @param id
	 * @return ����id��ȡֱ��������ϸ��Ϣ
	 */
	public LiveInteractive findById(int id);
	

}
