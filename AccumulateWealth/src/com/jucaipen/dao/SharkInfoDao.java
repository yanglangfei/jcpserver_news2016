package com.jucaipen.dao;

import com.jucaipen.model.SharkInfo;

public interface SharkInfoDao {
	
	/**
	 * @return   ��ȡ��ǰ��ҡһҡ��Ϣ
	 */
	public SharkInfo getSharkInfo();
	
	/**
	 * @param data
	 * @return  ����ʣ����
	 */
	public int updatePrice(int rest);
	
	/**
	 * @param date
	 * @return   ��ѯ�Ѿ��������ǻ�û��ʼ
	 */
	public SharkInfo getSharkByIsEnd(String date);
	
	
	

}
