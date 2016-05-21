package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.AccountDetail;

/**
 * @author Administrator
 *
 *   �˻���ϸ��Ϣ
 */
public interface AccountDetailDao {
	
	/**
	 * @param uId
	 * @return  �����û�id��ȡ�˻���ϸ��Ϣ
	 */
	public List<AccountDetail> findAccountDetailByuId(int uId);
	
	/**
	 * @param uId
	 * @param state
	 * @return �����û�id�����ͻ�ȡ��ϸ��Ϣ
	 */
	public List<AccountDetail> findAccountDetailByUIdAndState(int uId,int state);
	
	/**
	 * @param uId
	 * @param type
	 * @return   �����û�id�� �����ȡ��ϸ��Ϣ
	 */
	public List<AccountDetail> findAccountDetailByUidAndType(int uId,int type);
	
	
	

}
