package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.LiveMsg;
/**
 * @author Administrator
 *
 *
 *   ֱ������
 */
public interface TxtMsgDao {
	
	/**
	 * @param interactive
	 * @return  ��ӻ���
	 */
	public int insertLiveInteractive(LiveMsg interactive);
	
	/**
	 * @return  ��ȡ���л���
	 */
	public List<LiveMsg> findAll();
	/**
	 * @param userId
	 * @return  �����û�id��ȡ�û�����
	 */
	public List<LiveMsg> findByUserId(int userId);
	/**
	 * @param liveId
	 * @return  ����ֱ��id��ȡֱ��������Ϣ
	 */
	public List<LiveMsg> findByLiveId(int liveId,int page);
	/**
	 * @param uId
	 * @param liveId
	 * @return �����û�id ֱ��id��ȡֱ��������Ϣ
	 */
	public List<LiveMsg> findByUidAndLiveId(int uId,int liveId);
	/**
	 * @param id
	 * @return ����id��ȡֱ��������ϸ��Ϣ
	 */
	public LiveMsg findById(int id);
	

}
