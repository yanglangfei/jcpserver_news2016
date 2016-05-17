package com.jucaipen.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author Administrator
 *
 *
 *   ����������   3 160104094331 25653
 *           3  160104103649 37455
 */
public class OrderUtils {
	private static final String yyyyMMddHHmmssSSS="yyyyMMddHHmmssSSS";
	
	/**
	 *   orderType   ��������   1   ��ֵ    2  ����    3  ��Ʒ����
	 */
	public static String  getOrderCode(int orderType){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat(yyyyMMddHHmmssSSS);
		String code=sdf.format(date);
		return orderType+code.substring(2)+RandomUtils.getRandomData(2);
	}
	

}
