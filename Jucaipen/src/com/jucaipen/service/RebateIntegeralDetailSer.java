package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.RebateIntegeralDetailDao;
import com.jucaipen.daoimp.RebateIntegeralDetailImp;
import com.jucaipen.model.RebateIntegeralDetail;

public class RebateIntegeralDetailSer {

	/**
	 * @param id
	 * @return ����id��ȡ���������Ϣ
	 */
	public static RebateIntegeralDetail findRebateIntegeralById(int id) {
		RebateIntegeralDetailDao dao=new RebateIntegeralDetailImp();
		return dao.findRebateIntegeralById(id);
	}

	/**
	 * @param userId
	 * @param page
	 * @return �����û�id��ȡ����������Ϣ   ��ҳ
	 */ 
	public static List<RebateIntegeralDetail> findRebateIntegeralByUserId(int userId,
			int page) {
		RebateIntegeralDetailDao dao=new RebateIntegeralDetailImp();
		return dao.findRebateIntegeralByUserId(userId, page);
	}
	
	/**
	 * @param uId
	 * @return ����id��ȡ������Ϣ    �޷�ҳ
	 */
	public static List<RebateIntegeralDetail> findRebateIntegeralByUserId(int uId){
		RebateIntegeralDetailDao dao=new RebateIntegeralDetailImp();
		return dao.findRebateIntegeralByUserId(uId);
	}

	/**
	 * @param inDetail
	 * @return ��ӷ���������Ϣ
	 */
	public static int addRebateIntegeral(RebateIntegeralDetail inDetail) {
		RebateIntegeralDetailDao dao=new RebateIntegeralDetailImp();
		return dao.addRebateIntegeral(inDetail);
	}

}
