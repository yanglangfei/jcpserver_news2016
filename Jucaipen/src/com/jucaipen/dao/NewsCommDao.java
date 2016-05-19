package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Comment;
/**
 * @author ylf
 * 
 *         ��������
 * 
 */
public interface NewsCommDao {
	/**
	 * @param uId
	 * @param nId
	 * @return �������
	 */
	public int insertNewsComm(int uId, Comment comment);

	/**
	 * @param uId
	 * @param comment
	 * @return ������Żظ�
	 */
	public int insertNewsRes(int uId, Comment comment);

	/**
	 * @param uId
	 * @param nId
	 * @return ȡ������
	 */
	public int cancelNewsComm(int uId, int nId);

	/**
	 * @param uId
	 *            (type 0 ���� ��0 �ظ�)
	 * @return ��ѯ��ǰ�û������е���������
	 */
	public List<Comment> findNewsComment(int uId, int type, int pager);

	/**
	 * @param uId
	 * @param type
	 * @param pager
	 * @return ��ѯ��ǰ�û��µĻظ�
	 */
	public List<Comment> findNewsCommentRes(int uId, int type, int pager);

	/**
	 * @param nId
	 * @return ��ѯ��ǰ��������������
	 */
	public List<Comment> findCommenByNews(int nId, int pager);

	/**
	 * @param id
	 * @return ��ѯ��������
	 */
	public Comment findComment(int id);

	/**
	 * @param id
	 * @return �޸�������Ϣ
	 */
	public int updateCommentGoods(int id, int goodNum);

	/**
	 * @param pager
	 * @param id
	 * @param type
	 * @return ���ݷ��ࡢid �����ѯ������Ϣ
	 */
	public List<Comment> findCommentByTypeId(int pager, int id, int type);

}
