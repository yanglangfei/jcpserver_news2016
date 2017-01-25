package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.SharkDetailDao;
import com.jucaipen.daoimp.SharkDetailImp;
import com.jucaipen.model.SharkDetail;

public class SharkDetailServer {

	
	/**
	 * @param uId
	 * @return  �����û�id��ȡҡһҡ��Ϣ
	 */
	public static List<SharkDetail> getSharkList(int uId) {
		SharkDetailDao dao=new SharkDetailImp();
		return dao.getSharkList(uId);
	}

	/**
	 * @param uId
	 * @return  �����û�id��ȡҡһҡ����
	 */
	public static int getSharkCount(int uId) {
		SharkDetailDao dao=new SharkDetailImp();
		return dao.getSharkCount(uId);
	}

	/**
	 * @param detail
	 * @return  ���ҡһҡ��Ϣ
	 */
	public static int addDetail(SharkDetail detail) {
		SharkDetailDao dao=new SharkDetailImp();
		return dao.addDetail(detail);
	}
	
	/**
	 * @param min
	 * @param max
	 * @return  ��ȡ��ǰ����ҡһҡ�Ĵ���
	 */
	public static int getMaxCount(int min,int max){
		SharkDetailDao dao=new SharkDetailImp();
		return dao.getMaxCount(min, max);
	}

}
