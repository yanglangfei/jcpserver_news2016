package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.jucaipen.utils.StringUtil;

@SuppressWarnings("serial")
public class UpdatePhone extends HttpServlet {
	private String result;
	// 加密手机号 参数
	private String encrypePath = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=GetEncryptMobileNum";
	private Map<String, String> param = new HashMap<String, String>();
	private int isSuccess;
	private boolean isPassed;
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
			String telPhone = request.getParameter("telPhone");
			String actionCode = request.getParameter("actionCode");
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(actionCode)) {
						if (StringUtil.isNotNull(telPhone)) {
							if (StringUtil.isMobileNumber(telPhone)) {
								checkMobileCode(telPhone, actionCode);
								if (isPassed) {
									result = insertPhone(telPhone, uId);
								} else {
									result = JsonUtil.getRetMsg(7, "手机验证码错误");
								}
							} else {
								result = JsonUtil.getRetMsg(2, "非法手机号");
							}

						} else {
							result = JsonUtil.getRetMsg(1, "手机号不能为空");
						}

					} else {
						result = JsonUtil.getRetMsg(6, "手机验证码不能为空");
					}

				} else {
					result = JsonUtil.getRetMsg(4, "您还没登录");
				}

			} else {
				result = JsonUtil.getRetMsg(3, "用户ID数字格式化异常");
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
			return JsonUtil.getRetMsg(0, "手机号修改成功");
		} else {
			return JsonUtil.getRetMsg(5, "手机号修改失败");
		}

	}

	private void checkMobileCode(String mobile, String actionCode) {
		try {
			// 验证手机验证码是否正确
			List<MobileMessage> mobileList = MobileMessageSer
					.findMobileMessageByMobileNumLast(1, mobile);
			if (mobileList.size() > 0) {
				String checkCode = mobileList.get(0).getActionCode();
				String sendDate = mobileList.get(0).getSendDate();
				mobileList.get(0).getMsgid();
				long sendTime = sdf.parse(sendDate).getTime();
				long currrentTime = System.currentTimeMillis();
				if ((actionCode.equals(checkCode))
						&& ((currrentTime - sendTime) <= (3 * 60 * 1000))) {
					isPassed = true;
				} else {
					isPassed = false;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/*
	 * private void insertCheckInfo(String mobileNum, String checkDate,String
	 * qsName) { //修改短信激活状态 MobileMessage mobileMessage=new MobileMessage();
	 * if(isPassed){ mobileMessage.setMsgType(2);
	 * mobileMessage.setCheckDate(checkDate); mobileMessage.setRemark(qsName);
	 * }else { mobileMessage.setMsgType(3); }
	 * MobileMessageSer.upDateMessageType(msgId, mobileMessage);
	 * 
	 * }
	 */
}
