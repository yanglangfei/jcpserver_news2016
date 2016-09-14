package com.jucaipen.main.userid;

import java.security.KeyPair;

import org.json.JSONException;
import org.json.JSONObject;

public class AllinpayProject {

	public static String url_text = "http://ceshi.allinpay.com/usercenter/merchant/UserInfo/reg.do";
	public static String url_real="https://service.allinpay.com/usercenter/merchant/UserInfo/reg.do";
	public final static String signType = "1";// һ�ڵ�����ֶ���1
	public static String merchantId = "100020091218888";
	public static String partnerUserId = "008310107420024";
	public static String signMsg = "";

	public static String rootPath = ProjectMain.class.getResource("/").getFile().toString();
	
	public static void allinpayRegister(String merchantId, String partnerUserId) {
		AllinpayProject.merchantId = merchantId;
		AllinpayProject.partnerUserId = partnerUserId;
		String result = "";
		String src = getSignSrc();
		
		System.out.println("Դ����"+src);
		// ȡ�ø�Ŀ¼·��
		
		rootPath = rootPath.substring(1, rootPath.length() - 4)
				+ "libs/testMemberKey.keystore";

		KeyPair kp = RegisterUtils.getKeyFromKeyStore(rootPath, "testMemberKey",
				"testMemberKey", "testMemberKey");
		byte[] signBytes = CertSignUtil.signByPriKey(kp.getPrivate(),
				src.getBytes(), Constants.SHA1_WITH_RSA);
		/**
		 * ����̻����ķ���
		 */
		
		// ǩ����תʮ������
		signMsg = CertSignUtil.bytes2HexString(signBytes);
		result = getSignSrcAndSignMsg();
		
		System.out.print("�������ܺ��ñ���:"+result+"\n");
		String callBack = HttpRequest.sendGet(url_text, result);
		System.out.print(callBack+"\n");
		result = getUserIdByJson(callBack);
		System.out.print(result+"\n");
	}

	public static void allinpayRegisterProduct(String merchantId, String partnerUserId) {
		AllinpayProject.merchantId = merchantId;
		AllinpayProject.partnerUserId = partnerUserId;
		String result = "";
		String src = getSignSrc();
		// ȡ�ø�Ŀ¼·��
		rootPath = rootPath.substring(1, rootPath.length() - 4)
				+ "libs/testMemberKey.keystore";
		KeyPair kp = RegisterUtils.getKeyFromKeyStore(rootPath, "testMemberKey",
				"testMemberKey", "testMemberKey");
		byte[] signBytes = CertSignUtil.signByPriKey(kp.getPrivate(),
				src.getBytes(), Constants.SHA1_WITH_RSA);
		// ǩ����תʮ������
		signMsg = CertSignUtil.bytes2HexString(signBytes);
		result = getSignSrcAndSignMsg();
		System.out.print(result+"\n");
		String callBack = HttpRequest.sendGet(url_real, result);
		System.out.print(callBack+"\n");
		result = getUserIdByJson(callBack);
		System.out.print("������ţ�"+result+"\n");
	}

	
	
	public static void allinpayRegisterProductMoreParams(String merchantId, String partnerUserId,
			String keystoreName,String PassWard,String alias) {
		AllinpayProject.merchantId = merchantId;
		AllinpayProject.partnerUserId = partnerUserId;
		String result = "";
		String src = getSignSrc();
		// ȡ�ø�Ŀ¼·��
		String rootPath = ProjectMain.class.getResource("/").getFile()
				.toString();
		rootPath = rootPath.substring(1, rootPath.length() - 4)
				+ "libs/"+keystoreName;

		KeyPair kp = RegisterUtils.getKeyFromKeyStore(rootPath, PassWard,
				PassWard, alias);
		byte[] signBytes = CertSignUtil.signByPriKey(kp.getPrivate(),
				src.getBytes(), Constants.SHA1_WITH_RSA);
		// ǩ����תʮ������
		signMsg = CertSignUtil.bytes2HexString(signBytes);
		result = getSignSrcAndSignMsg();
		System.out.print(result+"\n");
		String callBack = HttpRequest.sendGet(url_real, result);//
		System.out.print(callBack+"\n");
		result = getUserIdByJson(callBack);
		System.out.print(result+"\n");
	}

	
	
	public static String getSignSrc() {
		String result = "";
		result = "&signType=" + signType + "&merchantId=" + merchantId
				+ "&partnerUserId=" + partnerUserId + "&";
		return result;
	}

	// ͨ��Md5���Դ��
	public static String getSignSrcAndSignMsg() {
		String result = "";
		result = "signType=" + signType + "&merchantId=" + merchantId
				+ "&partnerUserId=" + partnerUserId + "&signMsg=" + signMsg
				+ "";
		return result;
	}

	public static String getUserIdByJson(String return_msg) {
		String result = "";
		JSONObject object;
		try {
			object = new JSONObject(return_msg);
			result = object.optString("userId");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;

	}

	public String getKeystorePath(String KeystoreName)
	{
		String result="";
		result = rootPath.substring(1, rootPath.length() - 4)
				+ "libs/"+KeystoreName;
		return result;
	}
	/**
	 * �����µĹ�˽Կ��
	 */
	
	
	
	
}
