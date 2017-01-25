package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.TextLive;

public interface TxtLiveDao {
	
	/**
	 * @param textLive
	 * @return   �������ֱ����Ϣ
	 */
	public int insertTxtLive(TextLive textLive);
	
	/**
	 * @param condition
	 * @return  ��ȡ����ֱ����ҳ��
	 */
	public int findTotlePage(String condition);

	/**
	 * @param id
	 * @return  ����id��ȡֱ����Ϣ
	 */
	public TextLive findTextLiveById(int id);
	/**
	 * @return  ��ȡȫ��ֱ����Ϣ
	 */
	public List<TextLive>findAllTextLive(int page);
	/**
	 * @return   ��ȡȫ���������͵�ֱ����Ϣ
	 */
	public List<TextLive> findAllNewTextLivesByPush();
	
	/**
	 * @param teacherId
	 * @return  ���ݽ�ʦid��ȡֱ����Ϣ
	 */
	public List<TextLive> findTextLiveByTeacherId(int teacherId,int page);
	
	/**
	 * @param isEnd
	 * @return   �����Ƿ������ȡֱ����Ϣ
	 */
	public List<TextLive> findTextLiveByIsEnd(int isEnd);
	
	/**
	 * @param teacherId
	 * @param count
	 * @return   ��ȡ��ʦ����ļ���ֱ��
	 */
	public List<TextLive> findTxtLiveByTeacherIdAndLast(int teacherId,int count);
	/**
	 * @param lastId
	 * @return   ͨ����ǰֱ��id����ȡ�����ֱ����Ϣ
	 */
	public List<TextLive> findNewLiveByLastId(int lastId);
	/**
	 * @param count
	 * @return   ��ȡ�������Ҫ���͵���Ϣ
	 */
	public List<TextLive> findLastPushLive(int count);
	
	public TextLive findHitsAndGoods(int id);
	
	public int addGoods(int id,int goods);
	
	//��ȡǰһ�������ֱ����Ϣ
	public List<TextLive> findLastDateLive(String date);
	
	/**
	 * @param hits
	 * @param id
	 * @return  ���µ����
	 */
	public int addHits(int hits,int id,int xnHits);
}
