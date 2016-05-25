package com.jucaipen.service;

import java.util.List;
import com.jucaipen.dao.AccountDetailDao;
import com.jucaipen.daoimp.AccountDetailImp;
import com.jucaipen.model.AccountDetail;

public class AccountDetailSer{

	/**
	 * @param uId
	 * @return  �����û�id��ȡ�˺���ϸ��Ϣ
	 */
	public static List<AccountDetail> findAccountDetailByuId(int uId,int page) {
		AccountDetailDao  dao=new AccountDetailImp();
		return dao.findAccountDetailByuId(uId,page);
	}

	/**
	 * @param uId
	 * @param state
	 * @return  �����û�id��״̬��ȡ
	 */
	public static List<AccountDetail> findAccountDetailByUIdAndState(int uId, int state,int page) {
		AccountDetailDao dao=new AccountDetailImp(); 
		return dao.findAccountDetailByUIdAndState(uId, state,page);
	}

	/**
	 * @param uId
	 * @param type
	 * @return  �����û�id�ͷ����ȡ
	 */
	public static List<AccountDetail> findAccountDetailByUidAndType(int uId, int type,int page) {
		AccountDetailDao dao=new AccountDetailImp();
		return dao.findAccountDetailByUidAndType(uId, type,page);
	}
	
	/**
	 * @param state
	 * @param type
	 * @param userId
	 * @param page
	 * @return  ��ȡ�û������µĲ�ͬ״̬�˻���Ϣ
	 */
	public static List<AccountDetail> findDetailByUserIdAndStateAndType(int state,int type,int userId,int page){
		AccountDetailDao dao=new AccountDetailImp();
		return dao.findDetailByUidAndTypeAndState(userId, state, type, page);
	}

}