package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.ApplyTeacherDao;
import com.jucaipen.daoimp.ApplyTeacherImp;
import com.jucaipen.model.ApplyTeacher;

/**
 * @author Administrator
 * 
 *         ������ʦ
 */
public class ApplyTeacherSer {

	/**
	 * @param uId
	 * @return �����û�id��ȡ������Ϣ
	 */
	public static ApplyTeacher findApplyByUid(int uId) {
		ApplyTeacherDao dao = new ApplyTeacherImp();
		return dao.findApplyByUid(uId);
	}
	
	public static int updateApplyInfo(int id, ApplyTeacher apply) {
		ApplyTeacherDao dao = new ApplyTeacherImp();
		return dao.updateApplyInfo(id, apply);
	}
	
	public static ApplyTeacher findLastApplyByUidWithStep(int uId, int count, int step){
		ApplyTeacherDao dao = new ApplyTeacherImp();
		return dao.findLastApplyByUidWithStep(uId, count, step);
	}

	/**
	 * @param recommId
	 * @return �����Ƽ��˻�ȡ������Ϣ
	 */
	public static List<ApplyTeacher> findApplyByRecommId(int recommId) {
		ApplyTeacherDao dao = new ApplyTeacherImp();
		return dao.findApplyByRecommId(recommId);
	}

	public static ApplyTeacher findLastApplyByUid(int uId, int count) {
		ApplyTeacherDao dao = new ApplyTeacherImp();
		return dao.findLastApplyByUid(uId, count);
	}

	/**
	 * @param apply
	 * @return ���������Ϣ
	 */
	public static int addApply(ApplyTeacher apply, int step) {
		ApplyTeacherDao dao = new ApplyTeacherImp();
		return dao.addApply(apply, step);
	}

}
