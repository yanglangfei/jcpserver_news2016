package com.jucaipen.dao;

import com.jucaipen.model.SysDetailAccount;

public interface SysDetailAccountDao {
	/**
	 * @param detail
	 * @return  ������˻���ϸ��Ϣ
	 */
	public int addDetails(SysDetailAccount detail);
	
	/**
	 * @param id
	 * @return  ɾ�����˻���ϸ��Ϣ
	 */
	public int delDetail(int id);

}
