package com.jucaipen.utils;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringUtil {
	public static final String sendPhoneAccount="jcpxxk";
	public static final String sendPhonePwd="Tch456789";
	
	public static final String isVaild="������Ч";
	
	public static final String playUrl_MU="http://hls-w.quklive.com/live/w1469002576632934/playlist.m3u8";

	public static final String  playUrl_flv="http://hdl-w.quklive.com/live/w1469002576632934.flv";
	
	public static final String play_IOS="http://recordcdn.quklive.com/upload/vod/user1445329249621940/1468907345907846/2/video.m3u8";
	/**
	 * @param string
	 * @return �ж�������ȷ��
	 */
	public static boolean isMail(String string) {
		if (null != string) {
			if (string
					.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * �ж϶�������������ÿһ�������Ƿ�Ϊ��: ����Ϊnull���ַ����г���Ϊ0�������ࡢMapΪempty
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null)
			return true;

		if (obj instanceof CharSequence)
			return ((CharSequence) obj).length() == 0;

		if (obj instanceof Collection)
			return ((Collection) obj).isEmpty();

		if (obj instanceof Map)
			return ((Map) obj).isEmpty();
		if (obj instanceof Object[]) {
			Object[] object = (Object[]) obj;
			if (object.length == 0) {
				return true;
			}
			boolean empty = true;
			for (int i = 0; i < object.length; i++) {
				if (!isNullOrEmpty(object[i])) {
					empty = false;
					break;
				}
			}
			return empty;
		}
		
		return false;
	}
	
	/**
	 * @param card
	 * @return  �ж��Ƿ�������֤
	 */
	public static boolean isIdCard(String card){
		if(isNotNull(card)){
			return EditCheckUtil.IDCardValidate(card);
		}else{
			return false;
		}
	}
	
	
	public static String createMsg(String msg,int type){
		if(type==0){
			return "<img src='"+msg+"'>";
		}else{
			return msg;
		}
	}
	
	public static void main(String[] args) {
		StringBuffer buffer=new StringBuffer();
		buffer.append(createMsg("����˭", 1));
		buffer.append(createMsg("http://img.jucaipen.com/jucaipenUpload/2016/2/15/201621515955.gif",0));
		buffer.append(createMsg("�õ�", 1));
		buffer.append(createMsg("http://img.jucaipen.com/jucaipenUpload/2015/7/15/2015715174157.gif",0));
		buffer.append(createMsg("http://img.jucaipen.com/jucaipenUpload/2015/7/15/2015715174423.gif",0));
		buffer.append(createMsg("�Ǻ�", 1));
		System.out.println(buffer.toString());
	}
	
	  
	/**
	 * @param bank
	 * @return  �ж��Ƿ������п���   
	 * 
	 *   6228 4816 9872 9890 079
	 */
	public static boolean isBankCard(String bank){
		if(isNotNull(bank)){
			return EditCheckUtil.checkBankCard(bank);
		}else{
			return false;
		}
	}
	/**
	 * �ж��ֻ��������ȷ��
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNumber(String mobiles) {
		if (null != mobiles) {
			Pattern p = Pattern
					.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9]))\\d{8}$");
			Matcher m = p.matcher(mobiles);
			return m.matches();
		} else {
			return false;
		}
	}
	
	/**
	 * @param password
	 * @return ���볤���Ƿ���6-23֮��
	 */
	public static boolean isPassword(String password) {
		if (password.length() >= 6 && password.length() <= 23) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param nikName
	 * @return �ж��û��������Ƿ���1-9֮��
	 */
	public static boolean isUserName(String nikName) {
		if (nikName.trim().length() > 1 && nikName.trim().length() < 20) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �Ƿ�Ϊ null ����Ϊ���ַ���
	 * 
	 * @param string
	 * @return false if null || ""
	 */
	public static boolean isNotNull(String string) {

		if (string == null || "".equals(string)) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/**
	 * �ж��ַ����Ƿ�������
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * �ַ������Ȳ���,�����ӡʱ����,������ӡҳ��,�������ļ�������е�����
	 * 
	 * @param strs
	 *            Դ�ַ�
	 * @param len
	 *            ָ���ַ�����
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String Fix_String_Lenth(int type, String strs, int len) {
		String strtemp = strs;
		switch (type) {
		case 0:
			while (strtemp.length() < len * "��".length()) {
				strtemp += " ";
			}
			break;
		case 1:
			while (strtemp.length() < len) {
				strtemp += " ";
			}
			break;
		default:

			break;
		}
		return strtemp;
	}
	
	 /**
	 * @param html
	 * @return  ����HTML ��ǩ
	 */
	public static String clearHTMLCode(String html)
     {
		 String script="<script[\\s\\S]+</script *>";
		 String href=" href *= *[\\s\\S]*script *:";
		 String action=" no[\\s\\S]*=";
		 String ifream="<iframe[\\s\\S]+</iframe *>";
		 String frameset="<frameset[\\s\\S]+</frameset *>";
		 String fm="\\<img[^\\>]+\\>";
		 String p="</p>";
		 String ps="<p>";
		 String n="<[^>]*>";
         html = html.replaceAll(script, ""); //����<script></script>��� 
         html = html.replaceAll(href, ""); //����href=javascript: (<A>) ���� 
         html =  html.replaceAll(action, " _disibledevent="); //���������ؼ���on...�¼� 
         html =  html.replaceAll(ifream, ""); //����iframe 
         html =  html.replaceAll(frameset, ""); //����frameset 
         html =  html.replaceAll(fm, ""); //����frameset 
         html =  html.replaceAll(p, ""); //����frameset 
         html =  html.replaceAll(ps, ""); //����frameset 
         html =  html.replaceAll(n, "");
         html =  html.replaceAll(" ", "");
         html =  html.replaceAll("</strong>", "");
         html = html.replaceAll("<strong>", "");
         return html;
     }
	
	/**
	 * @param str
	 * @return    ���˶����е��ַ���
	 */
	public static String replaceStr(String str){
		String newStr;
		newStr=str.replaceAll("&nbsp;", " ");
		newStr=newStr.replaceAll("<br />", "");
		newStr=newStr.replaceAll("</p>", "");
		newStr=newStr.replaceAll("<p>", "");
		newStr=newStr.replace("{UserName}", "");
		return newStr;
	}
	
	public static String spliteStr(String old,int count){
		if(old.length()<=count){
			return old;
		}
		return old.substring(0, count);
	}
	


}