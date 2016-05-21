package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ApplyTeacher;

/**
 * @author Administrator
 *
 *  ���뽲ʦ
 */
public interface ApplyTeacherDao {
	
	/**
	 * @param uId
	 * @return �����û�id��ȡ������Ϣ
	 */
	public  ApplyTeacher findApplyByUid(int uId);
	
	/**
	 * @param recommId
	 * @return  �����Ƽ��û�id��ȡ������Ϣ
	 */
	public List<ApplyTeacher> findApplyByRecommId(int recommId);
	/**
	 * @param apply
	 * @return  ���������Ϣ
	 */
	public int addApply(ApplyTeacher apply);

}
