package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.LoginLog;
import com.jucaipen.model.User;
import com.jucaipen.service.LoginLogServer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author YLF
 * 
 *         �������˺ŵ�¼ accountType ---�������˺����� accountId ---�������˺�id
 * 
 */
@SuppressWarnings("serial")
public class OtherAccountLogin extends HttpServlet {
	private User user;
	private String result;
	private int uId;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String clientAddress;


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
			String accountType = request.getParameter("accountType");
			String accountId = request.getParameter("accountId");
			clientAddress = request.getRemoteAddr();
			if (StringUtil.isInteger(accountType)) {
				int type = Integer.parseInt(accountType);
				if (StringUtil.isNotNull(accountId)) {
					loginUser(type, accountId);
					if (user != null) {
						result = JsonUtil.getLoginResult(user);
						uId = user.getId();
						handleLoginResult(1, user);
					} else {
						// δ�󶨵ĵ�������¼
						result = JsonUtil.getRetMsg(3, "���˻�δ��");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "�˺�id����Ϊ��");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "�˺����Ͳ������ָ�ʽ���쳣");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void handleLoginResult(int i, User user) {
		// �����¼���
		LoginLog log = new LoginLog();
		log.setLoginDate(sdf.format(new Date()));
		log.setUserId(uId);
		log.setAccount(user.getUserName());
		log.setPassword(user.getPassword());
		log.setRemark("��¼�ɹ�");
		log.setLoginIp(clientAddress);
		LoginLogServer.insertLog(log);

	}

	private void loginUser(int type, String accountId) {
		// ���õ������˺ŵ�¼����
		user = UserServer.otherAccountLogin(type, accountId);

	}

}
