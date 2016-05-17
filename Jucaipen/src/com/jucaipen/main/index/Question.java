package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Ask;
import com.jucaipen.model.User;
import com.jucaipen.service.AskSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *   �ʴ�   type    0  ȫ��   ���ز����� id  image userName askDate askBody isReply
 *   
 *                   [{"page":1,"totlePage":6,"askId":83,
 *                   "userName":"zhang","insertDate":"2016-03-04",
 *                   "askBodys":"2","headFace":"","isReply":2}
 *                  1 ���ݽ�ʦid��ȡ�� 
 */
@SuppressWarnings("serial")
public class Question extends HttpServlet {

	private String result;
	private List<Ask> asks;
	private List<User> users=new ArrayList<User>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String type=request.getParameter("type");
		String page=request.getParameter("page");
		if(StringUtil.isNotNull(page)){
			if(StringUtil.isInteger(page)){
				int p=Integer.parseInt(page);
				if(StringUtil.isNotNull(type)&&StringUtil.isInteger(type)){
					int t=Integer.parseInt(type);
					if(t==0){
						initAllQuestion(p);
						result=JsonUtil.getAskList(asks, users);
					}else{
						String teacherId=request.getParameter("teacherId");
						if(StringUtil.isNotNull(teacherId)&&StringUtil.isInteger(teacherId)){
							int tId=Integer.parseInt(teacherId);
							initQuestionByTeacherId(tId,p);
							result=JsonUtil.getAskList(asks, users);
						}else{
							result=JsonUtil.getRetMsg(4,"teacherId �����쳣");
						}
					}
				}else{
					result=JsonUtil.getRetMsg(3,"type �����쳣");
				}
			}else{
				result=JsonUtil.getRetMsg(1,"page �������ָ�ʽ���쳣");
			}
		}else{
			result=JsonUtil.getRetMsg(2,"page ��������Ϊ��");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initQuestionByTeacherId(int tId,int page) {
		//���ݽ�ʦid��ȡ������Ϣ
		users.clear();
		asks=AskSer.findAskByTeacherId(tId, page);
		for(Ask ask : asks){
			int userId=ask.getUserId();
			User user=UserServer.findUserNikNameById(userId);
			if(user==null){
				user=new User();
				user.setUserName("");
				user.setFaceImage("");
			}
			users.add(user);
		}
		
	}

	private void initAllQuestion(int page) {
		//��ʼ�������ʴ���Ϣ
		users.clear();
		asks=AskSer.findAllAsk(page);
		for(Ask ask : asks){
			int userId=ask.getUserId();
			User user=UserServer.findUserNikNameById(userId);
			if(user==null){
				user=new User();
				user.setUserName("");
				user.setFaceImage("");
			}
			users.add(user);
		}
		
	}

}
