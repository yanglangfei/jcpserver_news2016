package com.jucaipen.main.index;

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
 *   ��ȡ���°���Ϣ   type     0     �հ�         1   �°�
 */
@SuppressWarnings("serial")
public class LatestList extends HttpServlet {

	
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    String type=request.getParameter("type");
	    if(StringUtil.isInteger(type)){
	    	result=JsonUtil.getRetMsg(1, "type ��������Ϊ��");
	    }else{
	    	if(StringUtil.isInteger(type)){
	    		int t=Integer.parseInt(type);
	    		result=initlist(t);
	    	}else{
	    		result=JsonUtil.getRetMsg(2,"type �������ָ�ʽ���쳣");
	    	}
	    }
		out.println(result);
		out.flush();
		out.close();
	}

	public String initlist(int t) {
		//��ʼ������Ϣ
		if(t==0){
			//�հ�
		}else{
			//�°�
		}
		return null;
		
		
	}

}
