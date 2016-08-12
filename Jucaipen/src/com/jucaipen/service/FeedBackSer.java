package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.FeedBackDao;
import com.jucaipen.daoimp.FeedBackImp;
import com.jucaipen.model.FeedBack;

public class FeedBackSer{

	/**
	 * @param feedBack
	 * @return  ������
	 */
	public static int insertFeedBack(FeedBack feedBack) {
		FeedBackDao dao=new FeedBackImp();
		return dao.insertFeedBack(feedBack);
	}

	/**
	 * @return  ��ȡ�������
	 */
	public static List<FeedBack> findAllFeedBack() {
		FeedBackDao dao=new FeedBackImp();
		return dao.findAllFeedBack();
	}

	/**
	 * @param uId
	 * @return  �����û�id��ѯ�����Ϣ
	 */
	public static List<FeedBack> findFeedBaceByUserId(int uId) {
		FeedBackDao dao=new FeedBackImp();
		return dao.findFeedBaceByUserId(uId);
	}

	/**
	 * @param type
	 * @return  �������״̬��ѯ�����Ϣ
	 */
	public static List<FeedBack> findFeedBackByType(int type) {
		FeedBackDao dao=new FeedBackImp();
		return dao.findFeedBackByType(type);
	}

	/**
	 * @param uId
	 * @param type
	 * @return �����û�id�����״̬��ѯ���
	 */
	public static List<FeedBack> findFeedBackByUidAndType(int uId, int type) {
		FeedBackDao dao=new FeedBackImp();
		return dao.findFeedBackByUidAndType(uId, type);
	}

	/**
	 * @param id
	 * @return  ����id ��ѯ�����ϸ��Ϣ
	 */
	public static FeedBack findFeedBackById(int id) {
		FeedBackDao dao=new FeedBackImp();
		return dao.findFeedBackById(id);
	}

}
