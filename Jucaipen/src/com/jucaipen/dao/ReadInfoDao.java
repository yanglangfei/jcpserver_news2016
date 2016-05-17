package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ReadInfo;

public interface ReadInfoDao {
	/**
	 * @return ��ȡ���ж�ȡ��Ϣ��¼
	 */
	public List<ReadInfo> findAll(int page);
	/**
	 * @param id
	 * @return ��ȡָ����ȡ����Ϣ
	 */
	public ReadInfo findReadInfo(int id);
	/**
	 * @param userId
	 * @return  ��ѯָ���û���ȡ��������Ϣ
	 */
	public List<ReadInfo> findReadInfoByUser(int userId,int page);
	/**
	 * @param readDate
	 * @return   ���ݶ�ȡʱ���ѯ��ȡ����Ϣ
	 */
	public List<ReadInfo> findReadInfoByReadDate(String readDate,int page);

}
