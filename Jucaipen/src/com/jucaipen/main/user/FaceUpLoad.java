package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *   ͬ�������û�ͷ����Ϣ
 */
@SuppressWarnings("serial")
public class FaceUpLoad extends HttpServlet {
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String imageFace=request.getParameter("imageFace");
		String userId=request.getParameter("userId");
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					result=initUserFaceUrl(uId,imageFace);
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
	private String initUserFaceUrl(int uId, String imageFace) {
		//��ʼ���û�ͷ��URL��Ϣ
		int isSuccess = UserServer.updateUserLogo(uId, imageFace);
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "�û�ͷ����³ɹ�") : JsonUtil.getRetMsg(1,"�û�ͷ�����ʧ��") ;
	}

}
