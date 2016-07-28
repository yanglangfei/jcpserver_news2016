package com.jucaipen.utils;

import java.text.DecimalFormat;
/**
 * @author Administrator
 *   
 */
public class MoneyUtils {
	private static DecimalFormat def = new DecimalFormat("0.00");

	private static DecimalFormat df = new DecimalFormat("0");

	/**
	 * @param jiao
	 * @return  ��ת��Ԫ
	 */
	public static String getJiaoToYuan(float jiao) {
		float yuan = jiao / 10;
		return def.format(yuan);
	}

	/**
	 * @param fen
	 * @return ��ת��Ԫ
	 */
	public static String getFenToYuan(float fen) {
		float yuan = fen / 100;
		return def.format(yuan);
	}

	/**
	 * @param yuan
	 * @return  Ԫת����
	 */
	public static String getYuanToFen(float yuan) {
		float fen = yuan * 100;
		return df.format(fen);
	}

	/**
	 * @param yuan
	 * @return  Ԫת����
	 */
	public static String getYuanToJiao(float yuan) {
		float jiao = yuan * 10;
		return df.format(jiao);
	}

}
