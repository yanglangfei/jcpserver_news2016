package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.ApplyTeacherDao;
import com.jucaipen.daoimp.ApplyTeacherImp;
import com.jucaipen.model.ApplyTeacher;

/**
 * @author Administrator
 *
 *  ������ʦ
 */
public class ApplyTeacherSer{

	/**
	 * @param uId
	 * @return �����û�id��ȡ������Ϣ
	 */
	public static ApplyTeacher findApplyByUid(int uId) {
		ApplyTeacherDao dao=new ApplyTeacherImp();
		return dao.findApplyByUid(uId);
	}

	/**
	 * @param recommId
	 * @return �����Ƽ��˻�ȡ������Ϣ
	 */
	public static List<ApplyTeacher> findApplyByRecommId(int recommId) {
		ApplyTeacherDao dao=new ApplyTeacherImp();
		return dao.findApplyByRecommId(recommId);
	}

	/**
	 * @param apply
	 * @return ����������Ϣ
	 */
	public int addApply(ApplyTeacher apply) {
		ApplyTeacherDao dao=new ApplyTeacherImp();
		return dao.addApply(apply);
	}

}