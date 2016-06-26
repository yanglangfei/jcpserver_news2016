package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.TxtLiveMsg;
/**
 * @author Administrator
 *
 *
 *   ֱ������
 */
public interface TxtMsgDao {
	/**
	 * @param count
	 * @param liveId
	 * @return  ��ȡָ������ֱ����������ļ�����¼
	 */
	public List<TxtLiveMsg> findLastTxtMsg(int count,int liveId,boolean isCheck);
	/**
	 * @param maxId
	 * @param liveId
	 * @param isCheck
	 * @return  ��������idʵʱ��ȡ���µ�������Ϣ
	 */
	public List<TxtLiveMsg>  findTxtMsgByMaxId(int maxId,int liveId,boolean isCheck);
	
	/**
	 * @param msg
	 * @return  ���������Ϣ
	 */
	public int addMsg(TxtLiveMsg msg);
	

}
