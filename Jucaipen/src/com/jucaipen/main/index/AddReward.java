package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *   ¥Ú…Õ
 */
@SuppressWarnings("serial")
public class AddReward extends HttpServlet {
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String usertAgent=request.getParameter("User-Agent");
		ClientOsInfo os=HeaderUtil.getMobilOS(usertAgent);
		int isDevice=HeaderUtil.isVaildDevice(os, usertAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			
			
		}else{
			result=StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

}
