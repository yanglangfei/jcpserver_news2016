package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.HotIdea;
public interface HotIdeaDao {
	
	/**
	 * @param ideaId
	 * @param hits
	 * @return  ��ӵ����
	 */
	public int addHit(int ideaId,int hits);
	
	/**
	 * @param ideaId
	 * @return  ���������
	 */
	public int addComment(int ideaId,int commCount);
	
	/**
	 * @param ideaId
	 * @return   ����
	 */
	public int addGood(int ideaId,int googs);
	
	/**
	 * @param id
	 * @return  ����id��ȡ���������������������
	 */
	public HotIdea findGoodAndHitAndComm(int id);
	
	/**
	 * @param condition
	 * @return  ��ѯ������ҳ��
	 */
	public int findTotlePage(String condition);
	
	/**
	 * @return  ��ȡ���е����Ź۵�
	 */
	public List<HotIdea> findAllHotIdea(int page);
	/**
	 * @param count
	 * @return  ��ȡ��������ǹ۵�
	 */
	public List<HotIdea> findIdeaByCount(int count);
	/**
	 * @param teacherId
	 * @return ���ݽ�ʦid��ȡ���ǹ۵�
	 */
	public List<HotIdea> findIdeaByTeacherId(int teacherId,int page);
	/**
	 * @param id
	 * @return ����id��ȡ���Ź۵�
	 */
	public HotIdea findIdeaById(int id);
	

}
