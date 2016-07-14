package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author Administrator
 *
 *  ≥‰÷µ
 */
@SuppressWarnings("serial")
public class Recharge extends HttpServlet {
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		String jucaiBills=request.getParameter("jucaiBills");
		String ip=request.getRemoteAddr();
		
		
		
		
		
		out.println(result);
		out.flush();
		out.close();
	}

}
