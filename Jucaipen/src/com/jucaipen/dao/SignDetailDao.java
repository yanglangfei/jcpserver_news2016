package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.SignDetail;

public interface SignDetailDao {
	
	/**
	 * @param userId
	 * @param page
	 * @return �����û�id��ȡǩ����Ϣ
	 */
	public List<SignDetail> findSignDetailByUserId(int userId,int page);
	/**
	 * @param detail
	 * @return ���ǩ����ϸ��Ϣ
	 */
	public int addSignDetail(SignDetail detail);

}
