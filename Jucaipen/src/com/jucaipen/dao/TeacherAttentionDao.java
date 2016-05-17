package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.TeacherAttention;

public interface TeacherAttentionDao {
	
	/**
	 * @return ��ӹ�ע
	 */
	public int insertAttention(TeacherAttention attention);
	/**
	 * @param tId
	 * @param uId
	 * @return    ȡ����ע
	 */
	public int cancleAttention(int tId,int uId);
	/**
	 * @return ��ȡ���еĹ�ע��Ϣ
	 */
	public List<TeacherAttention> findAllAttention();
	/**
	 * @param userId
	 * @return �����û�id��ѯ��ע��Ϣ
	 */
	public List<TeacherAttention> findAttentionByUid(int userId);
	/**
	 * @param tId
	 * @return ���ݽ�ʦid��ѯ��ע��Ϣ
	 */
	public List<TeacherAttention> findAttentionBytid(int tId,int page);
	/**
	 * @param uId
	 * @param tId
	 * @return �����û�id����ʦid��ȡ��ע����Ϣ
	 */
	public TeacherAttention findAttentionByUidAndTid(int uId,int tId);
	

}
