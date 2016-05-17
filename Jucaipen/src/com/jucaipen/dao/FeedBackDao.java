package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.FeedBack;
/**
 * @author Administrator
 *
 *  ���
 */
public interface FeedBackDao {
	
	
	/**
	 * @param feedBack
	 * @return  ������
	 */
	public int insertFeedBack(FeedBack feedBack);
	/**
	 * @return  ��ȡ�������
	 */
	public List<FeedBack> findAllFeedBack();
	/**
	 * @param uId
	 * @return �����û�id��ѯ���
	 */
	public List<FeedBack> findFeedBaceByUserId(int uId);
	/**
	 * @param type
	 * @return ����������Ͳ�ѯ���
	 */
	public List<FeedBack> findFeedBackByType(int type);
	/**
	 * @param uId
	 * @param type
	 * @return  �����û�id �����״̬��ȡ�����Ϣ
	 */
	public List<FeedBack> findFeedBackByUidAndType(int uId,int type);
	/**
	 * @param id
	 * @return �������id����ѯ�����ϸ����
	 */
	public FeedBack findFeedBackById(int id);
	

}
