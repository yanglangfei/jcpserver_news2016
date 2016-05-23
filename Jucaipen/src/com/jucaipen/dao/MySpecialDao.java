package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.MySpecial;

/**
 * @author Administrator
 *
 *  �ҵ�ר��
 */
public interface MySpecialDao {
	
	/**
	 * @param id
	 * @return ����id��ȡר����Ϣ
	 */
	public MySpecial findSpecialById(int id);
	
	/**
	 * @param id
	 * @return ��ȡ�ҵ�ר����Ϣ
	 */
	public List<MySpecial> findSpecialByUid(int userId,int page);
	
	/**
	 * @param special
	 * @return ���ר����Ϣ
	 */
	public int addSpecial(MySpecial special);
	/**
	 * @param id
	 * @return  ɾ��ר��
	 */
	public int removeSpecial(int id);

}
