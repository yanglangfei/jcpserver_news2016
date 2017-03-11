package com.jucaipen.service;
import com.jucaipen.dao.LiveRecoderSaleDao;
import com.jucaipen.daoimp.LiveRecoderSaleImp;
import com.jucaipen.model.LiveRecoderSale;
/**
 * @author ���ʷ�
 *2017��3��11��  ����2:20:50
 *  ����ֱ����¼����
 */
public class LiveRecoderSaleSer{

	/**
	 * @param uId
	 * @param liveId
	 * @return  ��ȡ�û����򵥴�ֱ���ļ�¼
	 */
	public static LiveRecoderSale getLiveSaleByUidAndLiveId(int uId, int liveId) {
		LiveRecoderSaleDao dao=new LiveRecoderSaleImp();
		return dao.getLiveSaleByUidAndLiveId(uId, liveId);
	}

	/**
	 * @param sale
	 * @return  ����û����򵥴�ֱ���ļ�¼
	 */
	public static int addLiveSale(LiveRecoderSale sale) {
		LiveRecoderSaleDao dao=new LiveRecoderSaleImp();
		return dao.addLiveSale(sale);
	}

}
