package com.jucaipen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * ����Util��
 * 
 * @author calvin
 */
public class TimeUtils {
	private static String defaultDatePattern = "yyyy-MM-dd ";
	private static int age;
	
	
	/**
	 * @param date
	 * @return  �ж�ʱ���Ƿ��ǽ���
	 */
	public static boolean compareDate(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date comDate=sdf.parse(date);
			Date currrent=new Date();
			int comYear=comDate.getYear();
			int comMoth=comDate.getMonth();
			int comDay=comDate.getDate();
			int currentYear=currrent.getYear();
			int currentMoth=currrent.getMonth();
			int currentDay=currrent.getDate();
			if(currentYear==comYear&&currentDay==comDay&&currentMoth==comMoth){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param birth
	 * @return   ��������ʱ��������
	 */
	public static int getAge(String birth) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(defaultDatePattern);
			Date birthday = sdf.parse(birth);
			long birthM = birthday.getTime();
			long thisM = new Date().getTime();
			age = (int) ((thisM - birthM) / (1000 * 60 * 60 * 24) / 356);
			return age;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * ���Ĭ�ϵ� date pattern
	 */
	public static String getDatePattern() {
		return defaultDatePattern;
	}

	/**
	 * ����Ԥ��Format�ĵ�ǰ�����ַ���
	 */
	public static String getToday() {
		Date today = new Date();
		return format(today);
	}

	/**
	 * ʹ��Ԥ��Format��ʽ��Date���ַ���
	 */
	public static String format(Date date) {
		return date == null ? " " : format(date, getDatePattern());
	}

	/**
	 * ʹ�ò���Format��ʽ��Date���ַ���
	 */
	public static String format(Date date, String pattern) {
		return date == null ? " " : new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * ʹ��Ԥ���ʽ���ַ���תΪDate
	 */
	public static Date parse(String strDate) throws ParseException {
		return StringUtils.isBlank(strDate) ? null : parse(strDate,
				getDatePattern());
	}

	/**
	 * ʹ�ò���Format���ַ���תΪDate
	 */
	public static Date parse(String strDate, String pattern)
			throws ParseException {
		return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(
				pattern).parse(strDate);
	}

	/**
	 * ��������������������
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	public static String getLastDayOfMonth(String year, String month) {
		Calendar cal = Calendar.getInstance();
		// ��
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		// �£���ΪCalendar������Ǵ�0��ʼ������Ҫ-1
		// cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		// �գ���Ϊһ��
		cal.set(Calendar.DATE, 1);
		// �·ݼ�һ���õ��¸��µ�һ��
		cal.add(Calendar.MONTH, 1);
		// ��һ���¼�һΪ�������һ��
		cal.add(Calendar.DATE, -1);
		return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));// �����ĩ�Ǽ���
	}

	public static Date getDate(String year, String month, String day)
			throws ParseException {
		String result = year + "- "
				+ (month.length() == 1 ? ("0 " + month) : month) + "- "
				+ (day.length() == 1 ? ("0 " + day) : day);
		return parse(result);
	}
}