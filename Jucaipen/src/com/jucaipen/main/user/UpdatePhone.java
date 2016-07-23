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
import com.jucaipen.model.User;
import com.jucaipen.service.MobileMessageSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *  �޸��ֻ���
 */
@SuppressWarnings("serial")
public class UpdatePhone extends HttpServlet {
	private String result;
	// �����ֻ��� ����
	private String encrypePath = "http://www.jcplicai.com/ashx/AndroidUser.ashx?action=GetEncryptMobileNum";
	private Map<String, String> param = new HashMap<String, String>();
	private int isSuccess;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
			String oldPhone = request.getParameter("oldPhone");
			String actionCode1 = request.getParameter("actionCode1");
			String newPhone=request.getParameter("newPhone");
			String actionCode2=request.getParameter("actionCode2");
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(oldPhone)&&StringUtil.isNotNull(newPhone)) {
						if (StringUtil.isNotNull(actionCode1)&&StringUtil.isNotNull(actionCode2)) {
							if (StringUtil.isMobileNumber(oldPhone)&&StringUtil.isMobileNumber(newPhone)) {
								boolean isPassed = checkMobileCode(oldPhone, actionCode1,newPhone,actionCode2);
								if (isPassed) {
									result = insertPhone(newPhone, uId);
								} else {
									result = JsonUtil.getRetMsg(7, "�ֻ���֤�����");
								}
							} else {
								result = JsonUtil.getRetMsg(2, "�Ƿ��ֻ���");
							}

						} else {
							result = JsonUtil.getRetMsg(6, "�ֻ���֤�벻��Ϊ��");
						}

					} else {
						result = JsonUtil.getRetMsg(1, "�ֻ��Ų���Ϊ��");
					}

				} else {
					result = JsonUtil.getRetMsg(4, "����û��¼");
				}

			} else {
				result = JsonUtil.getRetMsg(3, "�û�ID���ָ�ʽ���쳣");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String insertPhone(String telPhone, int id) {
		param.put("mobilenum", telPhone);
		String resJson = LoginUtil.sendHttpPost(encrypePath, param);
		org.json.JSONObject object = new org.json.JSONObject(resJson);
		boolean isRes = object.getBoolean("Result");
		if (isRes) {
			String tel = object.getString("MobileNum");
			return updatePhone(tel, id);
		} else {
			String msg = object.getString("Msg");
			return JsonUtil.getRetMsg(1, msg);
		}
	}

	public String updatePhone(String phone, int id) {
		isSuccess = UserServer.updatePhoneById(id, phone);
		if (isSuccess > 0) {
			return JsonUtil.getRetMsg(0, "�ֻ����޸ĳɹ�");
		} else {
			return JsonUtil.getRetMsg(5, "�ֻ����޸�ʧ��");
		}

	}

	private boolean checkMobileCode(String oldPhone, String actionCode1, String newPhone, String actionCode2) {
		try {
			// ��֤���ֻ���֤���Ƿ���ȷ
			List<MobileMessage> mobileList = MobileMessageSer
					.findMobileMessageByMobileNumLast(1, oldPhone);
			// ��֤���ֻ���֤���Ƿ���ȷ
			List<MobileMessage> messages=MobileMessageSer.findMobileMessageByMobileNumLast(1, newPhone);
			if (mobileList.size() > 0&&messages.size()>0) {
				String oldCode = mobileList.get(0).getActionCode();
				String oldSendDate = mobileList.get(0).getSendDate();
				String oldMId=mobileList.get(0).getMsgid();
				
				
				String newCode=messages.get(0).getActionCode();
				String newSendDate=messages.get(0).getSendDate();
				String newMId=messages.get(0).getMsgid();
				
				long oldSendTime = sdf.parse(oldSendDate).getTime();
				long newSendTime=sdf.parse(newSendDate).getTime();
				long currrentTime = System.currentTimeMillis();
				
				if ((oldCode.equals(actionCode1))&&(newCode.equals(actionCode2))
						&& ((currrentTime - newSendTime) <= (3 * 60 * 1000))&&((currrentTime - oldSendTime) <= (3 * 60 * 1000))) {
					//��֤���ֻ����Ƿ��ѱ�ʹ��
					User user=UserServer.findUserByTelPhone(newPhone);
					insertCheckInfo(newPhone,sdf.format(new Date()),newMId,true);
					insertCheckInfo(oldPhone, sdf.format(new Date()), oldMId, true);
					return user==null ? true : false;
				} else {
					insertCheckInfo(newPhone,sdf.format(new Date()),newMId,false);
					insertCheckInfo(oldPhone, sdf.format(new Date()), oldMId, false);
					return  false;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;

	}

	private void insertCheckInfo(String mobileNum, String checkDate,
			String msgId, boolean isPassed) {
		// �޸Ķ��ż���״̬
		MobileMessage mobileMessage = new MobileMessage();
		if (isPassed) {
			mobileMessage.setMsgType(2);
			mobileMessage.setCheckDate(checkDate);
		} else {
			mobileMessage.setMsgType(3);
		}
		MobileMessageSer.upDateMessageType(msgId, mobileMessage);

	}
}
