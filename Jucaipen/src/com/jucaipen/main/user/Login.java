package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��¼
 */
@SuppressWarnings("serial")
public class Login extends HttpServlet {

	private String result;

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
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int id = Integer.parseInt(userId);
					if (id <= 0) {
						result = userLogin(request);
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

	private String userLogin(HttpServletRequest request) {
		// �����¼
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (userName.isEmpty()) {
			return JsonUtil.getRetMsg(4, "�û�������Ϊ��");
		}
		if (!StringUtil.isUserName(userName)) {
			return JsonUtil.getRetMsg(5, "�û�������Ϊ1-10λ");
		}
		if (password.isEmpty()) {
			return JsonUtil.getRetMsg(6, "���벻��Ϊ��");
		}
		if (!StringUtil.isPassword(password)) {
			return JsonUtil.getRetMsg(7, "�������Ϊ6-23λ");
		}

		return null;
	}

}
