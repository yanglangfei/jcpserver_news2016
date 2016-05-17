package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.SystemInfo;

public interface SysInfoDao {
	/**
	 * @return  ��ѯ���е�ϵͳ��Ϣ
	 */
	public List<SystemInfo> findAll(int page);
	/**
	 * @param id
	 * @return ��ѯָ����ϵͳ��Ϣ
	 */
	public SystemInfo findSystemInfo(int id);
	/**
	 * @param type
	 * @return   �������ͻ�ȡ���е���Ϣ
	 */
	public List<SystemInfo> findInfoByType(int type,int page);
	/**
	 * @param receiverId
	 * @return  ��ѯ���������е���Ϣ
	 */
	public List<SystemInfo> findInfoByReceiver(int receiverId,int page);
	/**
	 * @param senderId
	 * @return   ��ѯ���������з��͵���Ϣ
	 */
	public List<SystemInfo> findInfoBySender(int senderId,int page);
	/**
	 * @param readDate
	 * @return  ������Ϣ��ȡʱ���ȡ�����Ѷ�/δ����Ϣ
	 */
	public List<SystemInfo> findInfoByIsread(String readDate,int page);
	/**
	 * @param SendDate
	 * @return   ���ݷ���ʱ���ȡ��Ϣ
	 */
	public List<SystemInfo> findInfoBySendDate(String SendDate,int page);
	
	/**
	 * @param userId
	 * @return   ͨ���û�id��ȡϵͳ��Ϣ
	 */
	public List<SystemInfo> findAllSystemInfoByUserId(int userId,int page);

}
