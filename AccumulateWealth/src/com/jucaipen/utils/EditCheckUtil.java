package com.jucaipen.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @describe ���֤���п��ţ�email,�ֻ�������֤������
 * @author jinkx
 * @data 2015-05-04
 */
public class EditCheckUtil {
	/*********************************** ���֤��֤��ʼ ****************************************/
	/**
	 * ���֤������֤ 1������Ľṹ ������ݺ�������������룬��ʮ��λ���ֱ������һλУ������ɡ�����˳�������������Ϊ����λ���ֵ�ַ�룬
	 * ��λ���ֳ��������룬��λ����˳�����һλ����У���롣 2����ַ��(ǰ��λ����
	 * ��ʾ�������ס����������(�С��졢��)�������������룬��GB/T2260�Ĺ涨ִ�С� 3�����������루����λ��ʮ��λ��
	 * ��ʾ�������������ꡢ�¡��գ���GB/T7408�Ĺ涨ִ�У��ꡢ�¡��մ���֮�䲻�÷ָ����� 4��˳���루��ʮ��λ��ʮ��λ��
	 * ��ʾ��ͬһ��ַ������ʶ������Χ�ڣ���ͬ�ꡢͬ�¡�ͬ�ճ������˱ඨ��˳��ţ� ˳�����������������ԣ�ż�������Ů�ԡ� 5��У���루��ʮ��λ����
	 * ��1��ʮ��λ���ֱ������Ȩ��͹�ʽ S = Sum(Ai * Wi), i = 0, ... , 16 ���ȶ�ǰ17λ���ֵ�Ȩ���
	 * Ai:��ʾ��iλ���ϵ����֤��������ֵ Wi:��ʾ��iλ���ϵļ�Ȩ���� Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4
	 * 2 ��2������ģ Y = mod(S, 11) ��3��ͨ��ģ�õ���Ӧ��У���� Y: 0 1 2 3 4 5 6 7 8 9 10 У����: 1 0
	 * X 9 8 7 6 5 4 3 2
	 */
	/**
	 * ���ܣ����֤����Ч��֤
	 * 
	 * @param IDStr
	 *            ���֤�� [url=home.php?mod=space&uid=7300]@return[/url] ��Ч������""
	 *            ��Ч������String��Ϣ
	 */
	public static boolean IDCardValidate(String IDStr) {
		String errorInfo = "";// ��¼������Ϣ
		String[] ValCodeArr = { "1", "0", "X", "9", "8", "7", "6", "5", "4",
				"3", "2" };
		String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
				"9", "10", "5", "8", "4", "2" };
		String Ai = "";
		// ================ ����ĳ��� 15λ��18λ ================
		if (IDStr.length() != 15 && IDStr.length() != 18) {
			errorInfo = "���֤���볤��Ӧ��Ϊ15λ��18λ��";
			System.out.println(IDStr + " err: " + errorInfo);
			return false;
		}
		// =======================(end)========================
		// ================ ���� �������Ϊ��Ϊ���� ================
		if (IDStr.length() == 18) {
			Ai = IDStr.substring(0, 17);
		} else if (IDStr.length() == 15) {
			Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
		}
		if (isNumeric(Ai) == false) {
			errorInfo = "���֤15λ���붼ӦΪ���� ; 18λ��������һλ�⣬��ӦΪ���֡�";
			System.out.println(IDStr + " err: " + errorInfo);
			return false;
		}
		// =======================(end)========================
		// ================ ���������Ƿ���Ч ================
		String strYear = Ai.substring(6, 10);// ���
		String strMonth = Ai.substring(10, 12);// �·�
		String strDay = Ai.substring(12, 14);// �·�
		if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
			errorInfo = "���֤������Ч��";
			System.out.println(IDStr + " err: " + errorInfo);
			return false;
		}
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
					|| (gc.getTime().getTime() - s.parse(
							strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
				errorInfo = "���֤���ղ�����Ч��Χ��";
				System.out.println(IDStr + " err: " + errorInfo);
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
			errorInfo = "���֤�·���Ч";
			System.out.println(IDStr + " err: " + errorInfo);
			return false;
		}
		if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
			errorInfo = "���֤������Ч";
			System.out.println(IDStr + " err: " + errorInfo);
			return false;
		}
		// =====================(end)=====================
		// ================ ������ʱ����Ч ================
		Map<String, String> h = GetAreaCode();
		System.out.println("" + h.get(Ai.substring(0, 2)));
		if (h.get(Ai.substring(0, 2)) == null) {
			errorInfo = "���֤�����������";
			System.out.println(IDStr + " err: " + errorInfo);
			return false;
		}
		// ==============================================
		// ================ �ж����һλ��ֵ ================
		int TotalmulAiWi = 0;
		for (int i = 0; i < 17; i++) {
			TotalmulAiWi = TotalmulAiWi
					+ Integer.parseInt(String.valueOf(Ai.charAt(i)))
					* Integer.parseInt(Wi[i]);
		}
		int modValue = TotalmulAiWi % 11;
		String strVerifyCode = ValCodeArr[modValue];
		Ai = Ai + strVerifyCode;
		if (IDStr.length() == 18) {
			if (Ai.equals(IDStr) == false) {
				errorInfo = "���֤��Ч�����ǺϷ������֤����";
				System.out.println(IDStr + " err: " + errorInfo);
				return false;
			}
		}
		// =====================(end)=====================
		return true;
	}

	/**
	 * ���ܣ����õ�������
	 * 
	 * @return Hashtable ����
	 */
	private static Map<String, String> GetAreaCode() {
		Map<String, String> hashtable = new HashMap<String, String>();
		hashtable.put("11", "����");
		hashtable.put("12", "���");
		hashtable.put("13", "�ӱ�");
		hashtable.put("14", "ɽ��");
		hashtable.put("15", "���ɹ�");
		hashtable.put("21", "����");
		hashtable.put("22", "����");
		hashtable.put("23", "������");
		hashtable.put("31", "�Ϻ�");
		hashtable.put("32", "����");
		hashtable.put("33", "�㽭");
		hashtable.put("34", "����");
		hashtable.put("35", "����");
		hashtable.put("36", "����");
		hashtable.put("37", "ɽ��");
		hashtable.put("41", "����");
		hashtable.put("42", "����");
		hashtable.put("43", "����");
		hashtable.put("44", "�㶫");
		hashtable.put("45", "����");
		hashtable.put("46", "����");
		hashtable.put("50", "����");
		hashtable.put("51", "�Ĵ�");
		hashtable.put("52", "����");
		hashtable.put("53", "����");
		hashtable.put("54", "����");
		hashtable.put("61", "����");
		hashtable.put("62", "����");
		hashtable.put("63", "�ຣ");
		hashtable.put("64", "����");
		hashtable.put("65", "�½�");
		hashtable.put("71", "̨��");
		hashtable.put("81", "���");
		hashtable.put("82", "����");
		hashtable.put("91", "����");
		return hashtable;
	}

	/**
	 * ���ܣ��ж��ַ����Ƿ�Ϊ����
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (isNum.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ���ܣ��ж��ַ����Ƿ�Ϊ���ڸ�ʽ
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDate(String strDate) {
		String regxStr = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		Pattern pattern = Pattern.compile(regxStr);
		Matcher m = pattern.matcher(strDate);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/*********************************** ���֤��֤���� ****************************************/
	// �֙C̖�a��C
	public static boolean isMobileNO(String mobiles) {
		/**
		 * ƥ�����¿�ͷ�ĺ��� �ƶ���134��135��136��137��138��139��150��151��157(TD)��158��159��187��188
		 * ��ͨ��130��131��132��152��155��156��185��186 ���ţ�133��153��180��189����1349��ͨ�� ����183
		 ***/
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,3,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	/**
	 * ��֤����
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * У�����п�����
	 * 
	 * @param cardId
	 * @return
	 */
	public static boolean checkBankCard(String cardId) {
		char bit = getBankCardCheckCode(cardId
				.substring(0, cardId.length() - 1));
		if (bit == 'N') {
			return false;
		}
		return cardId.charAt(cardId.length() - 1) == bit;
	}

	/**
	 * �Ӳ���У��λ�����п����Ų��� Luhm У���㷨���У��λ
	 * 
	 * @param nonCheckCodeCardId
	 * @return
	 */
	public static char getBankCardCheckCode(String nonCheckCodeCardId) {
		if (nonCheckCodeCardId == null
				|| nonCheckCodeCardId.trim().length() == 0
				|| !nonCheckCodeCardId.matches("\\d+")) {
			// ������Ĳ������ݷ���N
			return 'N';
		}
		char[] chs = nonCheckCodeCardId.trim().toCharArray();
		int luhmSum = 0;
		for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
			int k = chs[i] - '0';
			if (j % 2 == 0) {
				k *= 2;
				k = k / 10 + k % 10;
			}
			luhmSum += k;
		}
		return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
	}
}