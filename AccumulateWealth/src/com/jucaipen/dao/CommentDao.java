package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Comment;
/**
 * @author Administrator
 *
 * �۵㡢����ֱ�� ����       JCP_LogOrLive_Comm
 */
public interface CommentDao {
	/**
	 * @param uId
	 * @param nId
	 * @return �������   �ظ�
	 */
	public int insertComm( Comment comment);

	/**
	 * @param uId
	 * @param nId
	 * @return ɾ������  �ظ�
	 */
	public int cancelComm(int id);

	/**
	 * @param uId
	 * @return ��ѯ��ǰ�û������еĹ۵㡢����ֱ�� �������ۡ��ظ�
	 */
	public List<Comment> findComment(int uId, int type, int pager,int parentId);
	
	/**
	 * @param uId
	 * @return ��ѯ��ǰ�û������еĹ۵㡢����ֱ�� �������ۡ��ظ�
	 */
	public List<Comment> findComment(int uId, int type, int page);

	/**
	 * @param nId
	 * @return ��ѯ��ǰ֤ȯ ��Ƶ����������  �ظ�
	 */
	public List<Comment> findCommenBykId(int fkId, int pager,int parentId,int type);

	/**
	 * @param id
	 * @return  ����id��ȡ���� �ظ���Ϣ
	 */
	public Comment findCommentById(int id);

	/**
	 * @param id
	 * @return �޸�������Ϣ  �ظ���Ϣ  ������
	 */
	public int updateCommentGoods(int id, int goodNum);
	
	/**
	 * @param id
	 * @return �޸�������Ϣ �ظ���
	 */
	public int updateCommentRespCount(int id, int respCount);

}
