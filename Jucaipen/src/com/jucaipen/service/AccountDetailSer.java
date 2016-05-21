package com.jucaipen.service;

import java.util.List;
import com.jucaipen.dao.AccountDetailDao;
import com.jucaipen.daoimp.AccountDetailImp;
import com.jucaipen.model.AccountDetail;

public class AccountDetailSer{

	/**
	 * @param uId
	 * @return  根据用户id获取账号详细信息
	 */
	public static List<AccountDetail> findAccountDetailByuId(int uId) {
		AccountDetailDao  dao=new AccountDetailImp();
		return dao.findAccountDetailByuId(uId);
	}

	/**
	 * @param uId
	 * @param state
	 * @return  根据用户id和状态获取
	 */
	public static List<AccountDetail> findAccountDetailByUIdAndState(int uId, int state) {
		AccountDetailDao dao=new AccountDetailImp(); 
		return dao.findAccountDetailByUIdAndState(uId, state);
	}

	/**
	 * @param uId
	 * @param type
	 * @return  根据用户id和分类获取
	 */
	public static List<AccountDetail> findAccountDetailByUidAndType(int uId, int type) {
		AccountDetailDao dao=new AccountDetailImp();
		return dao.findAccountDetailByUidAndType(uId, type);
	}

}
