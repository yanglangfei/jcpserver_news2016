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
 *         ע��
 */
@SuppressWarnings("serial")
public class Regin extends HttpServlet {
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
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			if (userName.isEmpty()) {
				result = JsonUtil.getRetMsg(1, "�û�������Ϊ��");
			} else if (!StringUtil.isUserName(userName)) {
				result = JsonUtil.getRetMsg(2, "�û�������Ϊ1-9λ");
			} else if (password.isEmpty()) {
				result = JsonUtil.getRetMsg(3, "���벻��Ϊ��");
			}
			regin(userName, password);
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private void regin(String userName, String password) {

	}

}
