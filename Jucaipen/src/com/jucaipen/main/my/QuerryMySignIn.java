package com.jucaipen.main.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.SignDetail;
import com.jucaipen.service.SignDetailSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *  ��ȡ�ҵ�ǩ����Ϣ
 */
@SuppressWarnings("serial")
public class QuerryMySignIn extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					result=initMySignInData(uId);
				}else{
					result=JsonUtil.getRetMsg(3,"�û���û��¼");
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
	private String initMySignInData(int uId) {
		//��ʼ���ҵ�ǩ����Ϣ
		 List<SignDetail> details = SignDetailSer.findMothSignDetailByUserId(uId);
		// User user=UserServer.findBaseInfoById(uId);
		return JsonUtil.getSignDetails(details);
	}

}
