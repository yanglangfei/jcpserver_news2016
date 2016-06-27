package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Guardian;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 *
 *  ��ͨ�ػ�   
 */
@SuppressWarnings("serial")
public class OpenGurdian extends HttpServlet {
	private String result;
	private String ip;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ip=request.getRemoteAddr();
		String days=request.getParameter("days");
		String userId=request.getParameter("userId");
		String teacherId=request.getParameter("teacherId");
		if(StringUtil.isNotNull(userId)&&StringUtil.isInteger(userId)){
			int uId=Integer.parseInt(userId);
			if(uId>0){
				if(StringUtil.isNotNull(teacherId)&&StringUtil.isInteger(teacherId)){
					int tId=Integer.parseInt(teacherId);
					if(StringUtil.isNotNull(days)&&StringUtil.isInteger(days)){
						int d=Integer.parseInt(days);
						result=openGurdian(uId,tId,d);
					}else{
						result=JsonUtil.getRetMsg(1, "days �����쳣");
					}
				}else{
					result=JsonUtil.getRetMsg(2, "teacherId �����쳣");
				}
			}else{
				result=JsonUtil.getRetMsg(3,"�û���¼ʧ��");
			}
			
		}else{
			result=JsonUtil.getRetMsg(4, "userId �����쳣");
		}
		out.println(result);
		out.flush();
		out.close();
	}
	
	
	private String openGurdian(int uId, int tId, int d) {
		Guardian guardian=new Guardian();
		guardian.setIp(ip);
		guardian.setTeacherId(tId);
		guardian.setUserId(uId);
		guardian.setStartDate(TimeUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
		guardian.setEndDate(TimeUtils.format(TimeUtils.addMonth(new Date(), d/30),"yyyy-MM-dd HH:mm:ss"));
		guardian.setState(0);
		//��ͨ�ػ�
		int isSuccess=GuardianSer.addGuardian(guardian);
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "�ػ���ͨ�ɹ�") : JsonUtil.getRetMsg(1,"��ͨ�ػ�ʧ��");
	}

}
