package com.jucaipen.dao;

import com.jucaipen.model.LiveRecoder;

/**
 * @author ���ʷ�
 *2017��3��11��  ����1:44:37
 *
 *   ֱ����¼
 */
public interface LiveRecoderDao {
	
	/**
	 * @return  ��ȡ�����ֱ����Ϣ
	 */
	public LiveRecoder getRecoderByRect();
	
	/**
	 * @param liveId
	 * @return    ����ֱ��id��ȡֱ����¼��Ϣ
	 */
	public LiveRecoder getRecoderByLiveId(int liveId);

}
