package com.jucaipen.service;

import com.jucaipen.dao.SignDao;
import com.jucaipen.daoimp.SignImp;
import com.jucaipen.model.Sign;

public class SignSer {

	/**
	 * @param userId
	 * @return  ��ȡ�û�ǩ����Ϣ
	 */
	public static Sign findSignByUid(int userId) {
		SignDao dao=new SignImp();
		return dao.findSignByUid(userId);
	}

	public static int addSign(Sign sign) {
		SignDao dao=new SignImp();
		return dao.addSign(sign);
	}
	
	/**
	 * @param sign
	 * @return ����ǩ���ܱ���Ϣ
	 */
	public static int updateSign(Sign sign){
		SignDao dao=new SignImp();
		return dao.updateSign(sign);
	}
	/**
	 * @param uId
	 * @return  ��ȡǩ������
	 */
	public static int findSignCount(int uId){
		SignDao dao=new SignImp();
		return dao.findSignCount(uId);
	}

}
