package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.SharkDetail;

public interface SharkDetailDao {
	
	/**
	 * @param uId
	 * @return  �����û�id��ȡҡһҡ����Ϣ
	 */
	public List<SharkDetail>   getSharkList(int uId);
	/**
	 * @param uId
	 * @return   ��ȡ��ǰ�û�ҡһҡ���ܴ���
	 */
	public int getSharkCount(int uId);
	/**
	 * @param uId
	 * @return  ���ҡһҡ���
	 */
	public int addDetail(SharkDetail detail);
	
	/**
	 * @param min
	 * @param max
	 * @return  ��ȡ��ǰ����ҡ���Ĵ���
	 */
	public int getMaxCount(int min,int max);

}
