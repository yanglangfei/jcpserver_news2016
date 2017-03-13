package com.jucaipen.main.push;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author 杨朗飞
 *2017年3月13日  上午9:30:55
 *
 *  推送系统消息
 */
public class PushSysMessage extends HttpServlet {
	private static final long serialVersionUID = 3463292037748376005L;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		out.println(result);
		out.flush();
		out.close();
	}

}
