package com.jucaipen.service;

import com.jucaipen.dao.LiveRecoderDao;
import com.jucaipen.daoimp.LiveRecoderImp;
import com.jucaipen.model.LiveRecoder;

/**
 * @author ���ʷ�
 *2017��3��11��  ����2:22:28
 *
 *  ֱ����¼����
 */
public class LiveRecoderSer {

	/**
	 * @return  ��ȡ�����ֱ����¼
	 */
	public static LiveRecoder getRecoderByRect() {
		LiveRecoderDao dao=new LiveRecoderImp();
		return dao.getRecoderByRect();
	}
	
	/**
	 * @param liveId
	 * @return  ����ֱ��id��ȡֱ����¼��Ϣ
	 */
	public static LiveRecoder getRecoderByLiveId(int liveId){
		LiveRecoderDao dao=new LiveRecoderImp();
		return dao.getRecoderByLiveId(liveId);
	}

}
