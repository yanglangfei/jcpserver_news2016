package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.NewSmallDao;
import com.jucaipen.daoimp.NewSmallImp;
import com.jucaipen.model.NewsSmallClass;

public class NewSmallSer {
	/**
	 * @return ��ȡ���е����Ŷ���������Ϣ
	 */
	public static List<NewsSmallClass> findAll() {
		NewSmallDao dao = new NewSmallImp();
		return dao.findAllSmallClass();
	}

	/**
	 * @param id
	 * @return ����id ��ȡ����������ϸ��Ϣ
	 */
	public static NewsSmallClass findNewSmallById(int id) {
		NewSmallDao dao = new NewSmallImp();
		return dao.findSmallClassById(id);
	}

	/**
	 * @param bigId
	 * @return   ����һ�������ѯ�±ߵĶ���������Ϣ
	 */
	public static List<NewsSmallClass> findNewSmallByByBigId(int bigId) {
		NewSmallDao dao = new NewSmallImp();
		return dao.findSmallClassByBigId(bigId);
	}
	
	/**
	 * @param id
	 * @param bigId
	 * @return   ����һ��������id��ȡ������Ϣ
	 */
	public static NewsSmallClass findSmallClassBySidAndBigId(int id,int bigId){
		NewSmallDao dao=new NewSmallImp();
		return dao.findSmallClassBySidAndBigId(id, bigId);
	}

}
