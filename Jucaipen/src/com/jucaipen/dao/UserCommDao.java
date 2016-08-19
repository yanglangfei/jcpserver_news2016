package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.UserComm;
/**
 * @author ylf
 * 
 *         ֤ȯ ��  ��Ƶ ����
 * 
 */
public interface UserCommDao {
	/**
	 * @param uId
	 * @param nId
	 * @return �������   �ظ�
	 */
	public int insertComm( UserComm comment);
	

	/**
	 * @param uId
	 * @param nId
	 * @return ɾ������  �ظ�
	 */
	public int cancelComm(int id);
	
	/**
	 * @param uId
	 * @return ��ѯ��ǰ�û������е�֤ȯ��Ƶ ����
	 */
	public List<UserComm> findComment(int uId, int type, int page);

	/**
	 * @param uId
	 * @return ��ѯ��ǰ�û������е�֤ȯ��Ƶ ����
	 */
	public List<UserComm> findComment(int uId, int type, int pager,int parentId);

	/**
	 * @param nId
	 * @return ��ѯ��ǰ֤ȯ ��Ƶ����������  �ظ�
	 */
	public List<UserComm> findCommenBykId(int fkId, int pager,int parentId,int type);

	/**
	 * @param id
	 * @return  ����id��ȡ���� �ظ���Ϣ
	 */
	public UserComm findCommentById(int id);

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
