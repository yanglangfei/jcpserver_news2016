package com.jucaipen.main.push;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author ���ʷ�
 *2017��3��13��  ����9:30:55
 *
 *  ����ϵͳ��Ϣ
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
