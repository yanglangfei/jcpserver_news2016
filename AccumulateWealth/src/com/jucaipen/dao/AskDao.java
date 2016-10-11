package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Ask;

/**
 * @author Administrator
 *
 *  ��ȡ������Ϣ
 *  
 */
public interface AskDao {
	
	/**
	 * @param condition
	 * @return   ��ȡ��ѯ��Ϣ��ҳ��
	 */
	public int findTotlePage(String condition);
	
	public List<Ask>  findAskByUidAndTeacherId(int userId,int teacherId);
	
	/**
	 * @param pId
	 * @return  
	 */
	public List<Ask> findAskByParentId(int pId);
	
	/**
	 * @return  ��ȡ����������Ϣ
	 */
	public List<Ask> findAllAsk(int page);
	
	/**
	 * @param count
	 * @return ��ȡ����ļ�������
	 */
	public List<Ask> findLstAsk(int count);
	/**
	 * @param userId
	 * @return  ��ȡ��ǰ�û��µ���������
	 */
	public List<Ask> findAskByUserId(int userId);
	/**
	 * @param userId
	 * @return  ��ȡ��ǰ�û��µ���������
	 */
	public List<Ask> findAskByUserId(int userId,int page);
	/**
	 * @param teacherId
	 * @return ��ȡ��ǰ��ʦ�µ���������
	 */
	public List<Ask> findAskByTeacherId(int teacherId,int page);
	
	/**
	 * @param teacherId
	 * @param count
	 * @return ��ȡ��ʦ����ļ����ʴ�
	 */
	public List<Ask> findLastByTeacherId(int teacherId,int count);
	
	/**
	 * @param classId
	 * @return ���ݷ����ѯ������Ϣ
	 */
	public List<Ask> findAskByClassId(int classId);
	/**
	 * @param state
	 * @return  ͨ��״̬����ѯ������Ϣ 2����ʾ1Ϊ��ʾ
	 */
	public List<Ask> findAskByAskState(int state);
	/**
	 * @param isReply
	 * @return ���ݻظ�״̬��ѯ������Ϣ 2δ�ظ���1�ѻظ�
	 */
	public List<Ask> findAskByIsReply(int isReply);
	
	/**
	 * @param id
	 * @return ����id��ѯ������Ϣ
	 */
	public Ask findAskById(int id);
	/**
	 * @param ask
	 * @return ��������
	 */
	public int insertAsk(Ask ask);
	
	
	/**
	 * @param uId
	 * @return    �����û�id��ȡ��ǰ������
	 */
	public int findAskNumByUId(int uId);
	
	/**
	 * @param id
	 * @param hits
	 * @param xnHits
	 * @return  ���µ����
	 */
	public int updateHits(int id,int hits,int xnHits);

}