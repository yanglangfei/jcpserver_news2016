package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         登录
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
		String userId = request.getParameter("userId");
		if (StringUtil.isNotNull(userId)) {
			if (StringUtil.isInteger(userId)) {
				int id = Integer.parseInt(userId);
				if (id > 0) {
					result = userLogin(request);
				} else {
					result = JsonUtil.getRetMsg(3, "当前用户已经登录");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "userId 参数格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId 参数不能为空");
		}

		out.println(result);
		out.flush();
		out.close();
	}

	private String userLogin(HttpServletRequest request) {
		// 处理登录
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (userName.isEmpty()) {
			return JsonUtil.getRetMsg(4, "用户名不能为空");
		}
		if (!StringUtil.isUserName(userName)) {
             return JsonUtil.getRetMsg(5, "用户名必须为1-10位");
		}
		if (password.isEmpty()) {
			return JsonUtil.getRetMsg(6, "密码不能为空");
		}
		if(!StringUtil.isPassword(password)){
			return JsonUtil.getRetMsg(7,"密码必须为6-23位");
		}
        
		
		return null;
	}

}
