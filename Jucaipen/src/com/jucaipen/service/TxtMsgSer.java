package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TxtMsgDao;
import com.jucaipen.daoimp.TxtMsgImp;
import com.jucaipen.model.TxtLiveMsg;

public class TxtMsgSer {

	/**
	 * @param count
	 * @param liveId
	 * @param isCheck
	 * @return  ��ȡ�����ʮ�������¼
	 */
	public static List<TxtLiveMsg> findLastTxtMsg(int count, int liveId,
			boolean isCheck) {
		TxtMsgDao dao=new TxtMsgImp();
		return dao.findLastTxtMsg(count, liveId, isCheck);
	}

	/**
	 * @param maxId
	 * @param liveId
	 * @param isCheck
	 * @return  ��ȡ���µ�������Ϣ
	 */
	public static List<TxtLiveMsg> findTxtMsgByMaxId(int maxId, int liveId,
			boolean isCheck) {
		TxtMsgDao dao=new TxtMsgImp();
		return dao.findTxtMsgByMaxId(maxId, liveId, isCheck);
	}

	/**
	 * @param msg
	 * @return  ���������Ϣ
	 */
	public static int addMsg(TxtLiveMsg msg) {
		TxtMsgDao dao=new TxtMsgImp();
		return dao.addMsg(msg);
	}

}
