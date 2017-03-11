package com.jucaipen.utils;

import com.jucaipen.model.LiveRecoder;
import com.jucaipen.model.LiveRecoderSale;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.LiveRecoderSaleSer;
import com.jucaipen.service.LiveRecoderSer;

public class LiveUtil {
	
	public static void main(String[] args) {
		if(!isFree()){
			//�շ�
			if(!isGradian(1,1)){
				//δ�ػ�
				if(!isPurch(1,1)){
					LiveRecoderSale sale = null;
					//����δ����
					purchLive(sale);
				}
			}
		}
		//����ֱ����
		
	}
	
	/**
	 *   ���򵥴�ֱ��
	 */
	private static boolean purchLive(LiveRecoderSale sale) {
		return LiveRecoderSaleSer.addLiveSale(sale)>0 ? true : false;
	}

	/**
	 *    �Ƿ��շ�
	 * @return 
	 */
	public static  boolean isFree(){
		
		return false;
	}
	
	
	/**
	 * @return  �Ƿ�ͨ�ػ�
	 */
	public static boolean isGradian(int teacherId,int userId){
		return GuardianSer.findIsGuardian(teacherId, userId)!=null ? true : false;
	}
	
	
	/**
	 * @return  �����Ƿ���
	 */
	public static boolean isPurch(int userId,int liveId){
		LiveRecoder recoder = LiveRecoderSer.getRecoderByLiveId(liveId);
		return LiveRecoderSaleSer.getLiveSaleByUidAndLiveId(userId, recoder.getId())!=null ? true : false;
	}
	
	
	

}