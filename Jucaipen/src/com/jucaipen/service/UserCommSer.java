package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.UserCommDao;
import com.jucaipen.daoimp.UserCommImp;
import com.jucaipen.model.UserComm;

/**
 * @author Administrator 0֤ȯ֪ʶ��1Ϊ��Ƶ JCP_User_Comm
 */
public class UserCommSer {

	/**
	 * @param comment
	 * @return �������
	 */
	public static int insertComm(UserComm comment) {
		UserCommDao dao = new UserCommImp();
		return dao.insertComm(comment);
	}

	/**
	 * @param id
	 * @return ɾ������
	 */
	public static int cancelComm(int id) {
		UserCommDao dao = new UserCommImp();
		return dao.cancelComm(id);
	}

	/**
	 * @param uId
	 * @param type
	 * @param pager
	 * @param parentId
	 * @return ��ȡ�û��µķ���������Ϣ
	 */
	public static List<UserComm> findComment(int uId, int type, int pager,
			int parentId) {
		UserCommDao dao = new UserCommImp();
		return dao.findComment(uId, type, pager, parentId);
	}

	
	/**
	 * @param uId
	 * @param type
	 * @param pager
	 * @param parentId
	 * @return ��ȡ�û��µķ���������Ϣ
	 */
	public static List<UserComm> findComment(int uId, int type, int page) {
		UserCommDao dao = new UserCommImp();
		return dao.findComment(uId, type, page);
	}

	/**
	 * @param fkId
	 * @param pager
	 * @param parentId
	 * @param type
	 * @return ��ȡ���id�µķ���������Ϣ
	 */
	public static List<UserComm> findCommenBykId(int fkId, int pager,
			int parentId, int type) {
		UserCommDao dao = new UserCommImp();
		return dao.findCommenBykId(fkId, pager, parentId, type);
	}

	/**
	 * @param id
	 * @return ����id��ȡ������Ϣ
	 */
	public static UserComm findCommentById(int id) {
		UserCommDao dao = new UserCommImp();
		return dao.findCommentById(id);
	}

	/**
	 * @param id
	 * @param goodNum
	 * @return �޸����۵�����
	 */
	public static int updateCommentGoods(int id, int goodNum) {
		UserCommDao dao = new UserCommImp();
		return dao.updateCommentGoods(id, goodNum);
	}

	/**
	 * @param id
	 * @param respCount
	 * @return �޸����ۻظ���
	 */
	public static int updateCommentRespCount(int id, int respCount) {
		UserCommDao dao = new UserCommImp();
		return dao.updateCommentRespCount(id, respCount);
	}

}
