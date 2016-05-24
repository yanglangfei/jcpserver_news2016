package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.utils.EmailUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *   �����ʼ�
 */

@SuppressWarnings("serial")
public class SendEmail extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		String email=request.getParameter("email");
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					if(StringUtil.isNotNull(email)&&StringUtil.isMail(email)){
						result=EmailUtils.send(email, "������֤����1089", "�۲�������伤����");
					}else{
						result=JsonUtil.getRetMsg(4,"email�������쳣");
					}
				}else{
					result=JsonUtil.getRetMsg(3,"���û���û��¼");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"userId �������ָ�ʽ���쳣");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"userId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

}
