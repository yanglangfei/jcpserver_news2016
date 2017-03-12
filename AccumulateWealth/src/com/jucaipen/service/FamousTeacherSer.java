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
	 * @param userId
	 * @return  �����û�id��ȡ��ʦ
	 */
	public static FamousTeacher findFamousTeacherByUserId(int userId){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findFamousTeacherByUserId(userId);
	}
	
	/**
	 * @param teacherId
	 * @param teacher
	 * @return  ���½�ʦ������Ϣ
	 */
	public static int updateTeacherBaseInfo(int teacherId, FamousTeacher teacher){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.updateTeacherBaseInfo(teacherId, teacher);
	}
	
	/**
	 * @return  ��ȡ���н�ʦ   ����ҳ
	 */
	public static List<FamousTeacher> findAllTeacher(){
		FamousTeacherDao dao=new FamousTeacherImp();
		return dao.findAllTeacher();
	}
	
	/**
	 * @param tId
	 * @return  ��ȡ�ػ���ʦ��Ϣ
	 */
	public static FamousTeacher findPurchInfo(int tId){
		FamousTeacherDao dao=new FamousTeacherImp();
		return dao.findPurchInfo(tId);
	}
	
	/**
	 * @param id
	 * @param readNum
	 * @param xnNum
	 * @return  ���¹۵��Ķ���
	 */
	public static int updateIdeaReadNum(int id,int readNum,int xnNum){
		FamousTeacherDao dao=new FamousTeacherImp();
		return dao.updateIdeaReadNum(id, readNum, xnNum);
	}

	/**
	 * @return  ��ȡ��ҳͳ������  ������    �۵�   �ش���   ��˿����
	 */
	public static List<FamousTeacher> findIndexData() {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findIndexData();
	}
	
	/**
	 * @param tId
	 * @return  ��ȡ��ʦ������Ϣ
	 */
	public static FamousTeacher findTeacherBaseInfo(int tId){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findTeacherBaseInfo(tId);
	}
	
	/**
	 * @param fans
	 * @param id
	 * @return  ���·�˿����
	 */
	public static int updateFansNum(int fans,int id){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.updateFansNum(fans, id);
	}
	
	/**
	 * @param keyWord
	 * @return  ���ݹؼ���������ʦ
	 */
	public static List<FamousTeacher> findTeacherByKeyWord(String keyWord){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findTeacherByKeyWord(keyWord);
	}
	
	/**
	 * @param num
	 * @param id
	 * @return ����������
	 */
	public static int updateAskNum(int num,int id){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.updateAskNum(num, id);
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
