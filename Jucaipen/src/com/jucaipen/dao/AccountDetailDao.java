package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.AccountDetail;

/**
 * @author Administrator
 *
 *   账户详细信息
 */
public interface AccountDetailDao {
	
	/**
	 * @param uId
	 * @return  根据用户id获取账户详细信息
	 */
	public List<AccountDetail> findAccountDetailByuId(int uId);
	
	/**
	 * @param uId
	 * @param state
	 * @return 根据用户id和类型获取详细信息
	 */
	public List<AccountDetail> findAccountDetailByUIdAndState(int uId,int state);
	
	/**
	 * @param uId
	 * @param type
	 * @return   根据用户id和 分类获取详细信息
	 */
	public List<AccountDetail> findAccountDetailByUidAndType(int uId,int type);
	
	
	

}
