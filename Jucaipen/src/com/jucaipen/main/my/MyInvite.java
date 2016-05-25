package com.jucaipen.main.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Recommder;
import com.jucaipen.model.User;
import com.jucaipen.service.RecommderSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *   ��ȡ�ҵ�����
 */
@SuppressWarnings("serial")
public class MyInvite extends HttpServlet {
	private String result;
	private List<User> users=new ArrayList<User>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		String page=request.getParameter("page");
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
						int p=Integer.parseInt(page);
						result=initMyInvite(uId,p);
					}else{
						result=JsonUtil.getRetMsg(4,"page �����쳣");
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

	private String initMyInvite(int uId, int page) {
		// ��ʼ���ҵ�����
		List<Recommder> recommders = RecommderSer.findRecommderByParentId(uId, page);
		for(Recommder recommder :recommders){
			int userId=recommder.getUserId();
			User user=UserServer.findUserById(userId);
			if(user==null){
				user=new User();
			}
			users.add(user);
		}
		return JsonUtil.getRecommderList(recommders,users);
	}

}
