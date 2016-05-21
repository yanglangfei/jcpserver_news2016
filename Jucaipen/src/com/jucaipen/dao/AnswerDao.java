package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Answer;


/**
 * @author Administrator
 *
 * �ش�
 */
public interface AnswerDao {
	
	/**
	 * @param answer
	 * @return  ��ӻش�
	 */
	public int insertAnswer(Answer answer);
	
	/**
	 * @param id
	 * @return  ����id��ȡ�ش�
	 */
	public Answer findAnswerById(int id);
	
	/**
	 * @return  ��ȡ���лش�
	 */
	public List<Answer> findAllAnswer(int page);
	
	/**
	 * @param teacherId
	 * @return  ���ݽ�ʦid��ȡ�ش�
	 */
	public List<Answer> findAnswerByTeacherId(int teacherId);
	
	/**
	 * @param askId
	 * @return  �������ʻ�ȡ�ش�
	 */
	public  Answer findAnswerByAskId(int askId);
	
	/**
	 * @param teacherId
	 * @param count
	 * @return  ��ȡ��ʦ����ļ����ʴ�
	 */
	public List<Answer> findAnswerByTeacherAndLast(int teacherId,int count);
	
	/**
	 * @param count
	 * @return   ��ѯ��������ش�
	 */
	public List<Answer> findAnswerByLast(int count);
	

}
