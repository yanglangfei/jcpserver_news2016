package com.jucaipen.dao;
import com.jucaipen.model.LiveRecoderSale;
/**
 * @author ���ʷ�
 *2017��3��11��  ����1:40:12
 *
 *  ֱ�����򵥴μ�¼
 */
public interface LiveRecoderSaleDao {
	
	/**
	 * @param uId
	 * @param liveId
	 * @return  ��ȡ�û�����ĵ���ֱ��
	 */
	public  LiveRecoderSale  getLiveSaleByUidAndLiveId(int uId,int liveId);
	
	/**
	 * @param sale
	 * @return  ��ӹ��򵥴�ֱ������
	 */
	public int addLiveSale(LiveRecoderSale sale);

}
