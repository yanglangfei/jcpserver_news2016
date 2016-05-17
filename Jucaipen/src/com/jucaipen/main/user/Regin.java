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
 *    注册
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
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		if(userName.isEmpty()){
			result=JsonUtil.getRetMsg(1,"用户名不能为空");
		}else if(!StringUtil.isUserName(userName)){
			result=JsonUtil.getRetMsg(2,"用户名必须为1-9位");
		}else if(password.isEmpty()){
			result=JsonUtil.getRetMsg(3,"密码不能为空");
		}
		regin(userName,password);
		out.println(result);
		out.flush();
		out.close();
	}

	
	private void regin(String userName, String password) {
		
		
	}

}
