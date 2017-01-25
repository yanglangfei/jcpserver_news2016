package com.jucaipen.service;

import com.jucaipen.dao.SharkInfoDao;
import com.jucaipen.daoimp.SharkInfoImp;
import com.jucaipen.model.SharkInfo;

public class SharkInfoServer  {

	/**
	 * @return  ��ȡҡһҡ��Ϣ
	 */
	public static SharkInfo getSharkInfo() {
		SharkInfoDao dao=new SharkInfoImp();
		return dao.getSharkInfo();
	}
	
	/**
	 * @param date
	 * @param rest
	 * @return  ����ʣ����
	 */
	public static int updatePrice(int rest){
		SharkInfoDao dao=new SharkInfoImp();
		return dao.updatePrice( rest);
	}
	
	/**
	 * @param date
	 * @return  ��ѯ���յ�ҡһҡ�
	 */
	public static SharkInfo getSharkByIsEnd(String date){
		SharkInfoDao dao=new SharkInfoImp();
		return dao.getSharkByIsEnd(date);
	}

}
