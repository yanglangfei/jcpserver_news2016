package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TeacherAttentionDao;
import com.jucaipen.daoimp.TeacherAttentionImp;
import com.jucaipen.model.TeacherAttention;

/**
 * @author Administrator
 *
 *
 *  ��ע
 */
public class TeacherAttentionSer {

	/**
	 * @return ��ӹ�ע
	 */
	public static int insertAttention(TeacherAttention attention) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.insertAttention(attention);
	}
	/**
	 * @param teacherId
	 * @param userId
	 * @return   ȡ����ע
	 */
	public static int cancleAttention(int teacherId,int userId){
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.cancleAttention(teacherId, userId);
	}

	/**
	 * @return ��ȡ���еĹ�ע
	 */
	public static List<TeacherAttention> findAllAttention() {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAllAttention();
	}

	/**
	 * @param userId
	 * @return  ��ѯ��ǰ�û��µĹ�ע
	 */
	public static List<TeacherAttention> findAttentionByUid(int userId) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAttentionByUid(userId);
	}

	/**
	 * @param tId
	 * @return  ���ݽ�ʦid��ѯ��ע��Ϣ
	 */
	public static List<TeacherAttention> findAttentionBytid(int tId,int page) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAttentionBytid(tId,page);
	}

	/**
	 * @param uId
	 * @param tId
	 * @return ��ѯ��ǰ
	 */
	public static TeacherAttention findAttentionByUidAndTid(int uId, int tId) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAttentionByUidAndTid(uId, tId);
	}

}
