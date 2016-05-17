package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.FamousTeacherDao;
import com.jucaipen.daoimp.FamousTeacherImp;
import com.jucaipen.model.FamousTeacher;

public class FamousTeacherSer {

	/**
	 * @return ��ȡ���н�ʦ��Ϣ
	 */
	public static List<FamousTeacher> findAllFamousTeacher(int page) {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findAllFamousTeacher(page);
	}

	/**
	 * @return  ��ȡ��ҳͳ������  ������    �۵�   �ش���   ��˿����
	 */
	public static List<FamousTeacher> findIndexData() {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findIndexData();
	}

	/**
	 * @param count
	 * @return ��ȡ�Ƽ��Ľ�ʦ��Ϣ
	 */
	public static List<FamousTeacher> findFamousTeacherByIndex(int count) {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findFamousTeacherByIndex(count);
	}

	/**
	 * @param id
	 * @return ����id��ѯ��ʦ��Ϣ
	 */
	public static FamousTeacher findFamousTeacherById(int id) {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findFamousTeacherById(id);
	}

}
