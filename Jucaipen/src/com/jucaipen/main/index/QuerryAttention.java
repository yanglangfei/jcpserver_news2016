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
 *      查询是否关注
 */
@SuppressWarnings("serial")
public class QuerryAttention extends HttpServlet {
	private String result;
	private TeacherAttention attention;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String teacherId=request.getParameter("teacherId");
		String userId=request.getParameter("userId");
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(StringUtil.isInteger(teacherId)){
					int tId=Integer.parseInt(teacherId);
					querryIsAttention(uId,tId);
					if(attention==null){
						result=JsonUtil.getRetMsg(3,"您还没关注");
					}else {
						result=JsonUtil.getRetMsg(0, "已经关注");
					}
				}else {
					result=JsonUtil.getRetMsg(1, "讲师id数字格式化异常");
				}
			}else {
				result=JsonUtil.getRetMsg(2,"您还没登陆");
			}
		}else{
			result=JsonUtil.getRetMsg(4, "userId 参数不能为空");
		}
		
		out.print(result);
		out.flush();
		out.close();
	}

	public void querryIsAttention(int uId, int tId) {
		attention = TeacherAttentionSer.findAttentionByUidAndTid(uId, tId);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request, response);
	}

}
