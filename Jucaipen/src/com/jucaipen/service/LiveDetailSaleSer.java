package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.LiveDetailSaleDao;
import com.jucaipen.daoimp.LiveDetailSaleImp;
import com.jucaipen.model.LiveDetailSale;

public class LiveDetailSaleSer{

	/**
	 * @param id
	 * @return ͨ��id��ȡ������Ϣ
	 */
	public static LiveDetailSale findSaleById(int id) {
		LiveDetailSaleDao dao=new LiveDetailSaleImp();
		return dao.findSaleById(id);
	}

	/**
	 * @param uId
	 * @param page
	 * @return �����û�id��ȡ������Ϣ
	 */
	public static List<LiveDetailSale> findSaleByUid(int uId, int page) {
		LiveDetailSaleDao dao=new LiveDetailSaleImp();
		return dao.findSaleByUid(uId, page);
	}

	/**
	 * @param sale
	 * @return ��ӹ�����Ϣ
	 */
	public static int addSale(LiveDetailSale sale) {
		LiveDetailSaleDao dao=new LiveDetailSaleImp();
		return dao.addSale(sale);
	}

}
