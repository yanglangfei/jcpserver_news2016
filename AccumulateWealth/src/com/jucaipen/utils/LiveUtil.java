package com.jucaipen.utils;

import com.jucaipen.model.LiveRecoder;
import com.jucaipen.model.LiveRecoderSale;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.LiveRecoderSaleSer;
import com.jucaipen.service.LiveRecoderSer;

public class LiveUtil {
	
	public static void main(String[] args) {
		if(!isFree()){
			//收费
			if(!isGradian(1,1)){
				//未守护
				if(!isPurch(1,1)){
					LiveRecoderSale sale = null;
					//单次未购买
					purchLive(sale);
				}
			}
		}
		//进入直播间
		
	}
	
	/**
	 *   购买单次直播
	 */
	private static boolean purchLive(LiveRecoderSale sale) {
		return LiveRecoderSaleSer.addLiveSale(sale)>0 ? true : false;
	}

	/**
	 *    是否收费
	 * @return 
	 */
	public static  boolean isFree(){
		
		return false;
	}
	
	
	/**
	 * @return  是否开通守护
	 */
	public static boolean isGradian(int teacherId,int userId){
		return GuardianSer.findIsGuardian(teacherId, userId)!=null ? true : false;
	}
	
	
	/**
	 * @return  单次是否购买
	 */
	public static boolean isPurch(int userId,int liveId){
		LiveRecoder recoder = LiveRecoderSer.getRecoderByLiveId(liveId);
		return LiveRecoderSaleSer.getLiveSaleByUidAndLiveId(userId, recoder.getId())!=null ? true : false;
	}
	
	
	

}
