package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.MobileMessage;
import com.jucaipen.service.MobileMessageSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.MD5Util;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         �޸�����
 */
@SuppressWarnings("serial")
public class ChangePassword extends HttpServlet {
	private String result;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private boolean isPassed;
	private String encrypePath = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=GetEncryptMobileNum";
	private Map<String, String> map = new HashMap<String, String>();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String userId = request.getParameter("userId");
			String oldPwd = request.getParameter("oldPwd");
			String telPhone = request.getParameter("telPhone");
			String actionCode = request.getParameter("actionCode");
			String newPwd = request.getParameter("newPwd");
			String reptPwd = request.getParameter("reptPwd");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						result = changePassword(uId, oldPwd, telPhone,
								actionCode, newPwd, reptPwd);
					} else {
						result = JsonUtil.getRetMsg(3, "��ǰ�û���û��¼");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "userId �������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String changePassword(int uId, String oldPwd, String telPhone,
			String actionCode, String newPwd, String reptPwd) {
		// �޸�����
		// 1 ���жϲ����Ϸ��� 2����֤��������ȷ�� 3����֤�ֻ���֤���Ƿ���ȷ 4���������벢�޸�����

		// �����ֻ���
		map.put("mobilenum", telPhone);
		String resJson = LoginUtil.sendHttpPost(encrypePath, map);
		org.json.JSONObject object = new org.json.JSONObject(resJson);
		boolean isRes = object.getBoolean("Result");
		if (isRes) {
			String tel = object.getString("MobileNum");
			checkMobileCode(tel, actionCode);
			if (!isPassed) {
				return JsonUtil.getRetMsg(5, "�ֻ���֤�����");
			}
			if (StringUtil.isNotNull(telPhone)
					&& StringUtil.isMobileNumber(telPhone)) {
				if (StringUtil.isNotNull(actionCode)) {
					if (StringUtil.isNotNull(oldPwd)
							&& StringUtil.isNotNull(newPwd)
							&& StringUtil.isNotNull(reptPwd)) {
						String oldMd5Pwd = MD5Util.MD5(oldPwd);
						if (newPwd.equals(reptPwd)) {
							String password = UserServer.findPasswordById(uId);
							if (oldMd5Pwd.equals(password)) {
								// �û�������֤ͨ��
								String newMd5Pwd = MD5Util.MD5(newPwd);
								int isSuccess = UserServer.updatePassword(uId,
										newMd5Pwd);
								return isSuccess == 1 ? JsonUtil.getRetMsg(0,
										"�����޸ĳɹ�") : JsonUtil.getRetMsg(1, "�����޸�ʧ��");
							} else {
								return JsonUtil.getRetMsg(6, "ԭʼ�������");
							}
						} else {
							return JsonUtil.getRetMsg(5, "�������벻һ��");
						}
					} else {
						return JsonUtil.getRetMsg(4, "���벻��Ϊ��");
					}
				} else {
					return JsonUtil.getRetMsg(3, "��֤�벻��Ϊ��");
				}
			} else {
				return JsonUtil.getRetMsg(2, "�ֻ��Ų��Ϸ�");
			}
		} else {
			String msg = object.getString("Msg");
			return JsonUtil.getRetMsg(1, msg);
		}
	}

	private void checkMobileCode(String mobile, String actionCode) {
		try {
			// ��֤�ֻ���֤���Ƿ�Ϸ�
			List<MobileMessage> mobileList = MobileMessageSer
					.findMobileMessageByMobileNumLast(1, mobile);
			if (mobileList != null && mobileList.size() > 0) {
				String checkCode = mobileList.get(0).getActionCode();
				String sendDate = mobileList.get(0).getSendDate();
				String msgId = mobileList.get(0).getMsgid();
				long sendTime = sdf.parse(sendDate).getTime();
				long currrentTime = System.currentTimeMillis();
				if ((actionCode.equals(checkCode))
						&& ((currrentTime - sendTime) <= (3 * 60 * 1000))) {
					isPassed = true;
					insertCheckInfo(mobile, sdf.format(new Date()), "�޸��ֻ���",
							msgId);
				} else {
					isPassed = false;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void insertCheckInfo(String mobileNum, String checkDate,
			String qsName, String msgId) {
		// �޸Ķ��ż���״̬
		MobileMessage mobileMessage = new MobileMessage();
		if (isPassed) {
			mobileMessage.setMsgType(2);
			mobileMessage.setCheckDate(checkDate);
			mobileMessage.setRemark(qsName);
		} else {
			mobileMessage.setMsgType(3);
		}
		MobileMessageSer.upDateMessageType(msgId, mobileMessage);

	}
}
