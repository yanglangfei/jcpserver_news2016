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
 *  开通守护   
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
						result=JsonUtil.getRetMsg(1, "days 参数异常");
					}
				}else{
					result=JsonUtil.getRetMsg(2, "teacherId 参数异常");
				}
			}else{
				result=JsonUtil.getRetMsg(3,"用户登录失败");
			}
			
		}else{
			result=JsonUtil.getRetMsg(4, "userId 参数异常");
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
		//开通守护
		int isSuccess=GuardianSer.addGuardian(guardian);
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "守护开通成功") : JsonUtil.getRetMsg(1,"开通守护失败");
	}

}
