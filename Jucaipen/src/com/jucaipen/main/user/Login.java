package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.LoginLog;
import com.jucaipen.model.User;
import com.jucaipen.service.LoginLogServer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ��¼
 */
@SuppressWarnings("serial")
public class Login extends HttpServlet {
	private String loginUrl = "http://www.jcplicai.com/ashx/AndroidUser.ashx?action=login";
	private String result;
	private String loginIp;
	private Map<String, String> param = new HashMap<String, String>();

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
			System.out.println("userId:"+userId);
			loginIp = request.getRemoteAddr();
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int id = Integer.parseInt(userId);
					if (id <= 0) {
						result = userLogin(request, os);
					} else {
						result = JsonUtil.getRetMsg(3, "��ǰ�û��Ѿ���¼");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "userId ������ʽ���쳣");
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

	private String userLogin(HttpServletRequest request, ClientOsInfo os) {
		// �����¼
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(""+userName+"   "+password);
		if (!StringUtil.isNotNull(userName)) {
			return JsonUtil.getRetMsg(4, "�û�������Ϊ��");
		}
		if (!StringUtil.isUserName(userName)) {
			return JsonUtil.getRetMsg(5, "�û�������Ϊ1-10λ");
		}
		if (!StringUtil.isNotNull(password)) {
			return JsonUtil.getRetMsg(6, "���벻��Ϊ��");
		}
		if (!StringUtil.isPassword(password)) {
			return JsonUtil.getRetMsg(7, "�������Ϊ6-23λ");
		}
		param.put("username", userName);
		param.put("pwd", password);
		String result = LoginUtil.sendHttpPost(loginUrl, param);
		JSONObject object = new JSONObject(result);
		boolean res = object.getBoolean("Result");
		String msg = object.getString("Msg");
		int userId = object.getInt("ActionId");
		if (res) {
			// ��¼�ɹ�����
			User user = UserServer.findBaseInfoById(userId);
			//handleLoginLog(userName, 0, userId, password, "��¼�ɹ�", os);
			// initLoginCount(user.getLoginNum()+1,userId);
			return JsonUtil.getLoginResult(user);
		} else {
			// ��¼ʧ�ܴ���
			//handleLoginLog(userName, 1, 0, password, "��¼ʧ��:" + msg, os);
			return JsonUtil.getRetMsg(1, msg);
		}
	}

	/*
	 * private void initLoginCount(int num,int uId) {
	 * //UserServer.updateLoginNum(num, uId,loginIp); }
	 */

	public void handleLoginLog(String userName, int logResult, int userId,
			String password, String remark, ClientOsInfo os) {
		LoginLog log = new LoginLog();
		log.setAccount(userName);
		log.setLoginDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		log.setLoginIp(loginIp);
		log.setLoginResult(logResult);
		log.setLoginType(3);
		log.setPassword(password);
		log.setUserId(userId);
		log.setRemark(remark);
		if (os != null) {
			log.setBrowserName(os.getDeviceType());
			log.setOsName(os.getPhoneType());
		}
		LoginLogServer.insertLog(log);
	}

}
