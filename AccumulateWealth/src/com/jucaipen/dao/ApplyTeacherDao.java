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
	 * @param uId
	 * @param count
	 * @return  ��ȡ���һ��������Ϣ
	 */
	public  ApplyTeacher findLastApplyByUid(int uId,int count);
	
	/**
	 * @param uId
	 * @param count
	 * @return  ��ȡ���һ��������Ϣ
	 */
	public  ApplyTeacher findLastApplyByUidWithStep(int uId,int count,int step);
	
	/**
	 * @param recommId
	 * @return  �����Ƽ��û�id��ȡ������Ϣ
	 */
	public List<ApplyTeacher> findApplyByRecommId(int recommId);
	/**
	 * @param apply
	 * @return  ���������Ϣ
	 */
	public int addApply(ApplyTeacher apply,int step);
	
	public int updateApplyInfo(int id,ApplyTeacher apply);

}
