package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TacticsSaleDao;
import com.jucaipen.daoimp.TacticsSaleImp;
import com.jucaipen.model.TacticsSale;

/**
 * @author Administrator
 * 
 *         ս��������Ϣ
 */
public class TacticsSaleSer {

	/**
	 * @param id
	 * @return ����id��ȡս��������Ϣ
	 */
	public static TacticsSale findSaleById(int id) {
		TacticsSaleDao dao = new TacticsSaleImp();
		return dao.findSaleById(id);
	}

	/**
	 * @param uId
	 * @param page
	 * @return �����û�id��ȡս��������Ϣ
	 */
	public static List<TacticsSale> findSaleByUserId(int uId, int page) {
		TacticsSaleDao dao = new TacticsSaleImp();
		return dao.findSaleByUserId(uId, page);
	}

	/**
	 * @param sale
	 * @return ���ս��������Ϣ
	 */
	public static int addSale(TacticsSale sale) {
		TacticsSaleDao dao = new TacticsSaleImp();
		return dao.addSale(sale);
	}

	/**
	 * @param id
	 * @return ɾ��ս��������Ϣ
	 */
	public static int delSale(int id) {
		TacticsSaleDao dao = new TacticsSaleImp();
		return dao.delSale(id);
	}

	public static TacticsSale findTacticsIsSale(int uId, int tacticsId) {
		TacticsSaleDao dao = new TacticsSaleImp();
		return dao.findTacticsIsSale(uId, tacticsId);
	}

}
