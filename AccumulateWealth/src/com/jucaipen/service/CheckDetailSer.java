package com.jucaipen.service;

import com.jucaipen.dao.CheckDetailDao;
import com.jucaipen.daoimp.CheckDetailImp;
import com.jucaipen.model.CheckDetail;

/**
 * @author Administrator
 *
 *  �����Ϣ
 */
public class CheckDetailSer {

	/**
	 * @param id
	 * @return  ͨ��id��ȡ������Ϣ
	 */
	public static CheckDetail findCheckById(int id) {
		CheckDetailDao dao=new CheckDetailImp();
		return dao.findCheckById(id);
	}

	/**
	 * @param applyId
	 * @return ͨ������id��ȡ�����Ϣ
	 */
	public static CheckDetail findCheckByApplyId(int applyId) {
		CheckDetailDao dao=new CheckDetailImp();
		return dao.findCheckByApplyId(applyId);
	}

}
