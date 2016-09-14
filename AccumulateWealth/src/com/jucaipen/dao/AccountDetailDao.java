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
	public List<AccountDetail> findAccountDetailByuId(int uId,int page);
	
	/**
	 * @param uId
	 * @param state
	 * @return �����û�id�����ͻ�ȡ��ϸ��Ϣ
	 */
	public List<AccountDetail> findAccountDetailByUIdAndState(int uId,int state,int page);
	
	/**
	 * @param uId
	 * @param type
	 * @return   �����û�id�� �����ȡ��ϸ��Ϣ
	 */
	public List<AccountDetail> findAccountDetailByUidAndType(int uId,int type,int page);
	/**
	 * @param uId
	 * @param state
	 * @param type
	 * @param page
	 * @return  ��ȡ�û������µĲ�ͬ״̬�˻���Ϣ
	 */
	public List<AccountDetail> findDetailByUidAndState(int uId,int state,int page);
	/**
	 * @param detail
	 * @return  ����˻���ϸ��Ϣ
	 */
	public int addAccountDetails(AccountDetail detail);
	/**
	 * @param id
	 * @return  ɾ���˻���ϸ��Ϣ
	 */
	public int delAccountDetails(int id);
	

}
