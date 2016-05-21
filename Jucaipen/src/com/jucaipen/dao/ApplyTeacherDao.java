package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ApplyTeacher;

/**
 * @author Administrator
 *
 *  申请讲师
 */
public interface ApplyTeacherDao {
	
	/**
	 * @param uId
	 * @return 根据用户id获取申请信息
	 */
	public  ApplyTeacher findApplyByUid(int uId);
	
	/**
	 * @param recommId
	 * @return  根据推荐用户id获取申请信息
	 */
	public List<ApplyTeacher> findApplyByRecommId(int recommId);
	/**
	 * @param apply
	 * @return  添加申请信息
	 */
	public int addApply(ApplyTeacher apply);

}
