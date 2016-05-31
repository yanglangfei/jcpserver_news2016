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
 *         注册
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
			String telPhone = request.getParameter("telPhone");
			String checkCode = request.getParameter("checkCode");
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String reptPwd = request.getParameter("reptPwd");
			if (StringUtil.isMobileNumber(telPhone)) {
				if (StringUtil.isNotNull(checkCode) && checkCode.length() >= 4) {
					if (StringUtil.isNotNull(userName)) {
						if (StringUtil.isUserName(userName)) {
							if (StringUtil.isPassword(password)
									&& StringUtil.isPassword(reptPwd)) {
								if (password.equals(reptPwd)) {
									result = regin(userName, password,
											telPhone, checkCode);
								} else {
									result = JsonUtil.getRetMsg(6, "两次密码不一致");
								}
							} else {
								result = JsonUtil.getRetMsg(5, "密码长度在6-23位");
							}

						} else {
							result = JsonUtil.getRetMsg(4, "用户名长度为2-9位");
						}

					} else {
						result = JsonUtil.getRetMsg(3, "用户名不能为空");
					}

				} else {
					result = JsonUtil.getRetMsg(2, "验证码长度不足");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "手机号不符合要求");
			}

		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String regin(String userName, String password, String telPhone,
			String checkCode) {
		return null;

	}

}
