package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.TeacherAttention;
import com.jucaipen.service.TeacherAttentionSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         关注名师   opType    0 添加关注
 *                          1 取消关注
 * 
 */
@SuppressWarnings("serial")
public class Attention extends HttpServlet {
	private String result;
	private int isSuccess;      
	private TeacherAttention attention;


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8")  ;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String opType=request.getParameter("opType");
		String userId = request.getParameter("userId");
		String teacherId = request.getParameter("teacherId");
		if(StringUtil.isInteger(opType)){
			int type=Integer.parseInt(opType);
			if (StringUtil.isInteger(userId)) {
				// 用户id数字格式化正常
				int uId = Integer.parseInt(userId);
				if (StringUtil.isInteger(teacherId)) {
					int tId = Integer.parseInt(teacherId);
					if(type==0){
						//添加关注
						checkIsAttention(uId,tId);
						if(attention==null){
							insertAttention(uId, tId);
							if (isSuccess == 1) {
								result = JsonUtil.getRetMsg(0, "关注讲师成功");
							} else {
								result = JsonUtil.getRetMsg(3, "关注讲师失败");
							}
						}else {
							result=JsonUtil.getRetMsg(6,"已经关注该讲师");
						}
					}else if(type==1){
						checkIsAttention(uId,tId);
						if(attention!=null){
						   cancelAttention(uId, tId);
						   if (isSuccess == 1) {
								result = JsonUtil.getRetMsg(0, "取消关注讲师成功");
							} else {
								result = JsonUtil.getRetMsg(3, "取消关注讲师失败");
							}
						}else {
							result=JsonUtil.getRetMsg(6,"还没关注该讲师");
						}
						
					}else {
						result=JsonUtil.getRetMsg(5, "操作id不符合要求");
					}
				
				} else {
					result = JsonUtil.getRetMsg(1, "讲师id数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "用户id数字格式化异常");
			}
			
		}else {
			result=JsonUtil.getRetMsg(4,"操作id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void    cancelAttention(int uId, int tId) {
		// 取消关注
		isSuccess=TeacherAttentionSer.cancleAttention(tId, uId);
		
	}

	private void checkIsAttention(int uId, int tId) {
		//检查之前是否关注过
		attention = TeacherAttentionSer.findAttentionByUidAndTid(uId, tId);
		
	}

	private void insertAttention(int uId, int tId) {
		TeacherAttention attention = new TeacherAttention(
				0, uId, tId);
		isSuccess = TeacherAttentionSer.insertAttention(attention);

	}

}
