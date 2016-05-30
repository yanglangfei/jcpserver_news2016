package com.jucaipen.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jucaipen.model.ClientOsInfo;
/***
 *   ��ȡ�����豸����    
 */
public class HeaderUtil {
	public static final String OSTYPE_ANDROID="Android";
	public static final String OSTYPE_IOS="Ios";
	public static final String OSTYPE_WP="WINDOWS PHONE";
	public static final String OSTYPE_BLACKBERRY="BLACKBERRY";
	private static boolean isDebug=true;
	/***
	 * pad
	 */
	public static final String DEVICE_TYPE_PAD="Pad";
	/***
	 * �ֻ�
	 */
	public static final String DEVICE_TYPE_PHONE="Phone";
	/**
	 *  �ֻ�app ����
	 */
	public static final int PHONE_APP=0;
	/**
	 *  �ֻ����������
	 */
	public static final int PHONE_CHAROM=1;
	/**
	 *  ���������
	 */
	public static final int CHAROM=2;

	/***
	 * У�������ն˰汾���Ƿ�Ϸ�,eg:0.0.0.3
	 * 
	 * @param clientVersion
	 * @return true-->�Ϸ� ;false-->�Ƿ�
	 */
	public static boolean verifyClientVersion(String clientVersion) {
		boolean result = Pattern.matches("[\\d\\.]+", clientVersion);
		if (result) {
			result = Pattern.matches("^\\d\\.\\d\\.\\d\\.\\d$", clientVersion);
			return result;
		} else {
			return false;
		}
	}
	
	public static int isVaildDevice(ClientOsInfo os,String UA){
		if(isDebug){
			return PHONE_APP;
		}
		if(UA==null||os==null){
			return CHAROM;
		}
		String osType=os.getDeviceType();
		if(StringUtil.isNotNull(osType)){
			String type=osType.toLowerCase();
			if((type.equals("pad")||type.equals("phone"))&&UA.contains("Dalvik")){
				return PHONE_APP;
			}else{
				return PHONE_CHAROM;
			}
		}else{
			return CHAROM;
		}
		
	}
	
	
	/**
	 * ����useragent���ֻ����̲��ֻ��ͺ�
	 * 
	 * @param UA
	 * @param vendor
	 * @return
	 */
	public static String getMobModel(String UA, String operatingSystem) {
		if (UA == null) {
			return null;
		}
		// ���������ʽ
		String rex = "";
		// ƻ����Ʒ
		if (operatingSystem.indexOf("IOS") != -1) {
			if (UA.indexOf("IPAD") != -1) {// �ж��Ƿ�Ϊipad
				return "IPAD";
			}
			if (UA.indexOf("IPOD") != -1) {// �ж��Ƿ�Ϊipod
				return "IPOD";
			}
			if (UA.indexOf("IPONE") != -1) {// �ж��Ƿ�Ϊipone
				return "IPONE";
			}
			return "IOS DEVICE";

		}
		// ��׿ϵͳ��Ʒ
		if (operatingSystem.indexOf("ANDROID") != -1) {
			String re = "BUILD";
			rex = ".*" + ";" + "(.*)" + re;
			Pattern p = Pattern.compile(rex, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(UA);
			boolean rs = m.find();
			if (rs) {
				return m.group(1);
			}
		}
		return null;
	}

	/**
	 * �ж��ֻ��Ĳ���ϵͳ IOS/android/windows phone/BlackBerry
	 * 
	 * @param UA
	 * @return
	 */
	public static ClientOsInfo getMobilOS(String UA) {
		if (UA == null) {
			return null;
		}
		UA=UA.toUpperCase();
		ClientOsInfo osInfo=new  ClientOsInfo();
		// ���������ʽ
		String rex = "";
		// IOS �ж��ַ���
		String iosString = " LIKE MAC OS X";
		if (UA.indexOf(iosString) != -1) {
			if(isMatch(UA, "\\([\\s]*iPhone[\\s]*;", Pattern.CASE_INSENSITIVE)){
				osInfo.setDeviceType(DEVICE_TYPE_PHONE);
			}else if(isMatch(UA, "\\([\\s]*iPad[\\s]*;", Pattern.CASE_INSENSITIVE)){
				osInfo.setDeviceType(DEVICE_TYPE_PAD);
			}
			rex = ".*" + "[\\s]+(\\d[_\\d]*)" + iosString;
			Pattern p = Pattern.compile(rex, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(UA);
			boolean rs = m.find();
			if (rs) {
				String osVersion= m.group(1).replace("_", ".");
				osInfo.setVersion(osVersion);     
				osInfo.setOsTypeVersion(OSTYPE_IOS+"_" + osVersion);
				return osInfo;
			}
			osInfo.setOsTypeVersion(OSTYPE_IOS);
			return osInfo;
		}
		// Android �ж�
		String androidString = "ANDROID";
		if (UA.indexOf(androidString) != -1) {
			if(isMatch(UA, "\\bMobi", Pattern.CASE_INSENSITIVE)){
				osInfo.setDeviceType(DEVICE_TYPE_PHONE);
			}else {
				osInfo.setDeviceType(DEVICE_TYPE_PAD);
			}
			rex = ".*" + androidString + "[\\s]*(\\d*[\\._\\d]*)";
			Pattern p = Pattern.compile(rex, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(UA);
			boolean rs = m.find();
			if (rs) {
				String version=m.group(1).replace("_", ".");
				osInfo.setVersion(version);
				osInfo.setOsTypeVersion(OSTYPE_ANDROID+"_" + version);
				return osInfo;
			}
			osInfo.setOsTypeVersion(OSTYPE_ANDROID);
			return osInfo;
		}
		// windows phone �ж�
		String wpString = "WINDOWS PHONE";
		if (UA.indexOf(wpString) != -1) {
			rex = ".*" + wpString + "[\\s]*[OS\\s]*([\\d][\\.\\d]*)";
			Pattern p = Pattern.compile(rex, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(UA);
			boolean rs = m.find();
			if (rs) {
				String version=m.group(1);
				osInfo.setVersion(version);
				osInfo.setOsTypeVersion(OSTYPE_WP+"_" + version);
				return osInfo;
			}
			osInfo.setOsTypeVersion(OSTYPE_WP);
			return osInfo;
		}
		// BlackBerry ��ݮϵͳ�ж�
		String bbString = "BLACKBERRY";
		if (UA.indexOf(bbString) != -1) {
			rex = ".*" + bbString + "[\\s]*([\\d]*)";
			Pattern p = Pattern.compile(rex, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(UA);
			boolean rs = m.find();
			if (rs) {
				String version=m.group(1);
				osInfo.setVersion(version);
				osInfo.setOsTypeVersion(OSTYPE_BLACKBERRY+"_" + version);
				return osInfo;
			}
			osInfo.setOsTypeVersion(OSTYPE_BLACKBERRY);
			return osInfo;
		}
		if(UA.contains("LINUX")){//android
			if(isMatch(UA, "\\bMobi", Pattern.CASE_INSENSITIVE)){
				osInfo.setDeviceType(DEVICE_TYPE_PHONE);
			}else {
				osInfo.setDeviceType(DEVICE_TYPE_PAD);
			}
			
			 Pattern p = Pattern.compile("U;\\s*(Adr[\\s]*)?(\\d[\\.\\d]*\\d)[\\s]*;",Pattern.CASE_INSENSITIVE);
		        Matcher m = p.matcher(UA);
		        boolean result = m.find();
		        String find_result = null;
		        if (result)
		        {
		            find_result = m.group(2);
		        }
		        if(StringUtil.isNullOrEmpty(find_result)){
		        	osInfo.setOsTypeVersion(OSTYPE_ANDROID);
		        	return osInfo;
		        }else{
		        	osInfo.setVersion(find_result);
		        	osInfo.setOsTypeVersion(OSTYPE_ANDROID+"_"+find_result);
		        	return osInfo;
		        }
		}
		
		//UCWEB/2.0 (iOS; U; iPh OS 4_3_2; zh-CN; iPh4)
		if(UA.matches(".*((IOS)|(iPAD)).*(IPH).*")){
			if(isMatch(UA, "[\\s]*iPh[\\s]*", Pattern.CASE_INSENSITIVE)){
				osInfo.setDeviceType(DEVICE_TYPE_PHONE);
			}else {
				osInfo.setDeviceType(DEVICE_TYPE_PAD);
			}
			 Pattern p = Pattern.compile("U;\\s*(IPH[\\s]*)?(OS[\\s]*)?(\\d[\\._\\d]*\\d)[\\s]*;",Pattern.CASE_INSENSITIVE);
		        Matcher m = p.matcher(UA);
		        boolean result = m.find();
		        String find_result = null;
		        if (result)
		        {
		            find_result = m.group(3);
		        }
		        if(StringUtil.isNullOrEmpty(find_result)){
		        	osInfo.setOsTypeVersion(OSTYPE_IOS);
		        	return osInfo;
		        }else{
		        	String version=find_result.replace("_", ".");
		        	osInfo.setVersion(version);
		        	osInfo.setOsTypeVersion(OSTYPE_IOS+"_"+version);
		        	return osInfo;
		        }
		}
		return osInfo;
	}
	public static boolean isMatch(String source,String regx,int flags){
		Pattern p = Pattern.compile(regx,flags);
        Matcher m = p.matcher(source);
        boolean result = m.find();
        return result;
	}

}
