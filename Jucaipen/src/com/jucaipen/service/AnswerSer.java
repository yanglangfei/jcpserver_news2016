package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.AnswerDao;
import com.jucaipen.daoimp.AnswerImp;
import com.jucaipen.model.Answer;

public class AnswerSer{

	/**
	 * @param answer
	 * @return  ��ӻظ�
	 */
	public static int insertAnswer(Answer answer) {
		AnswerDao dao=new AnswerImp();
		return dao.insertAnswer(answer);
	}

	/**
	 * @param id
	 * @return  ����id��ȡ�ظ���Ϣ
	 */
	public static Answer findAnswerById(int id) {
		AnswerDao dao=new AnswerImp();
		return dao.findAnswerById(id);
	}

	/**
	 * @return  ��ȡ���лظ���Ϣ
	 */
	public static List<Answer> findAllAnswer(int page) {
		AnswerDao dao=new AnswerImp();
		return dao.findAllAnswer(page);
	}
	
	/**
	 * @param count
	 * @return  ��ȡ��������ش�
	 */
	public static List<Answer> findAnswerByLast(int count){
		AnswerDao dao=new AnswerImp();
		return dao.findAnswerByLast(count);
	}

	/**
	 * @param teacherId
	 * @return  ���ݽ�ʦid��ȡ�ظ���Ϣ
	 */
	public static List<Answer> findAnswerByTeacherId(int teacherId) {
		AnswerDao dao=new AnswerImp();
		return dao.findAnswerByTeacherId(teacherId);
	}

	/**
	 * @param askId
	 * @return  �������ʻ�ȡ�ظ���Ϣ
	 */
	public static Answer findAnswerByAskId(int askId) {
		AnswerDao dao=new AnswerImp();
		return dao.findAnswerByAskId(askId);
	}

	/**
	 * @param teacherId
	 * @param count
	 * @return  ���ݽ�ʦid ��ȡ����ļ����ظ�
	 */
	public static List<Answer> findAnswerByTeacherAndLast(int teacherId, int count) {
		AnswerDao dao=new AnswerImp();
		return dao.findAnswerByTeacherAndLast(teacherId, count);
	}

}
