package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.CommentDao;
import com.jucaipen.daoimp.CommentsImp;
import com.jucaipen.model.Comment;

/**
 * @author Administrator
 *   
 *  JCP_LogOrLive_Comm �۵㡢����ֱ�� ����  �ظ���Ϣ
 */
public class CommentSer {

	/**
	 * @param comment
	 * @return �������  �ظ���Ϣ
	 */
	public static  int insertComm(Comment comment) {
		CommentDao dao=new CommentsImp();
		return dao.insertComm(comment);
	}

	/**
	 * @param id
	 * @return ɾ������  �ظ���Ϣ
	 */
	public static int cancelComm(int id) {
		CommentDao dao=new CommentsImp();
		return dao.cancelComm(id);
	}

	/**
	 * @param uId
	 * @param type
	 * @param pager
	 * @param parentId
	 * @return  ��ȡ�û��µķ���  ����  �ظ���Ϣ
	 */
	public static List<Comment> findComment(int uId, int type, int pager, int parentId) {
		CommentDao dao=new CommentsImp();
		return dao.findComment(uId, type, pager, parentId);
	}

	/**
	 * @param fkId
	 * @param pager
	 * @param parentId
	 * @param type
	 * @return  ��ȡ�۵�  ����ֱ��  �µ����ۻظ���Ϣ
	 */
	public static List<Comment> findCommenBykId(int fkId, int pager, int parentId,
			int type) {
		CommentDao dao=new CommentsImp();
		return dao.findCommenBykId(fkId, pager, parentId, type);
	}

	/**
	 * @param id
	 * @return ����id��ȡ����  �ظ���Ϣ
	 */
	public static Comment findCommentById(int id) {
		CommentDao dao=new CommentsImp();
		return dao.findCommentById(id);
	}

	/**
	 * @param id
	 * @param goodNum
	 * @return �޸����۵�����
	 */
	public static int updateCommentGoods(int id, int goodNum) {
		CommentDao dao=new CommentsImp();
		return dao.updateCommentGoods(id, goodNum);
	}

	/**
	 * @param id
	 * @param respCount
	 * @return  �޸����� �ظ���
	 */
	public static  int updateCommentRespCount(int id, int respCount) {
		CommentDao dao=new CommentsImp();
		return dao.updateCommentRespCount(id, respCount);
	}

}
