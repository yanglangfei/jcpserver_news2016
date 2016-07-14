package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.FamousTeacherDao;
import com.jucaipen.daoimp.FamousTeacherImp;
import com.jucaipen.model.FamousTeacher;

public class FamousTeacherSer {

	/**
	 * @return ��ȡ���н�ʦ��Ϣ   ��ҳ
	 */
	public static List<FamousTeacher> findAllFamousTeacher(int page) {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findAllFamousTeacher(page);
	}
	
	/**
	 * @return  ��ȡ���н�ʦ   ����ҳ
	 */
	public static List<FamousTeacher> findAllTeacher(){
		FamousTeacherDao dao=new FamousTeacherImp();
		return dao.findAllTeacher();
	}

	/**
	 * @return  ��ȡ��ҳͳ������  ������    �۵�   �ش���   ��˿����
	 */
	public static List<FamousTeacher> findIndexData() {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findIndexData();
	}
	
	public static FamousTeacher findTeacherBaseInfo(int tId){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findTeacherBaseInfo(tId);
	}
	
	public static int updateFansNum(int fans,int id){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.updateFansNum(fans, id);
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
	
	/**
	 * @param id
	 * @return ��ȡ���������
	 */
	public static int findMaxAsk(int id){
		FamousTeacherDao dao=new FamousTeacherImp();
		return dao.findMaxAsk(id);
	}

}
