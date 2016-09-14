package com.jucaipen.manager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.utils.StringUtil;
/**
* @author Administrator
*/
public class Control extends HttpServlet {
	private static final long serialVersionUID = 4906602039828919994L;
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId=request.getParameter("typeId");
		if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
			int type=Integer.parseInt(typeId);
			result=control(type);
		}
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println(result);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	private String control(int type) {
		if(type==0){
			return "1";
		}else if(type==1){
			return "2";
		}else if(type==2){
			return "3";
		}else{
			return "other";
		}
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
