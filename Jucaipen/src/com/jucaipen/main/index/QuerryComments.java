/*package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.LogCommen;
import com.jucaipen.model.NewsComment;
import com.jucaipen.model.User;
import com.jucaipen.service.LogCommSer;
import com.jucaipen.service.NewsCommSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

*//**
 * @author Administrator
 * 
 *         获取评论信息 commType 评论类型 0 新闻评论 1 视频评论 2 观点评论
 *//*
@SuppressWarnings("serial")
public class QuerryComments extends HttpServlet {
	private String result;
	private List<LogCommen> logComms;
	private List<User> users = new ArrayList<User>();
	private List<NewsComment> nComments;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String commType = request.getParameter("commType");
		String id = request.getParameter("id");
		String page = request.getParameter("page");
		if (StringUtil.isNotNull(commType)) {
			if (StringUtil.isInteger(commType)) {
				int type = Integer.parseInt(commType);
				if (StringUtil.isNotNull(id) && StringUtil.isInteger(id)) {
					int index = Integer.parseInt(id);
					if (StringUtil.isNotNull(page)
							&& StringUtil.isInteger(page)) {
						int p = Integer.parseInt(page);
						if (type == 0) {
							// 新闻评论
							initNewsComms(index, p);
							result=JsonUtil.getNewsCommList(nComments, users);
						} else if (type == 1) {
							// 视频评论
							initVideoComments(index, p);
							result=JsonUtil.getNewsCommList(nComments, users);
						} else {
							// 观点评论
							initIdeaComments(index, p);
							result = JsonUtil.getIdeaCommList(logComms, users);
						}
					} else {
						result = JsonUtil.getRetMsg(4, "page 参数异常");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "id 参数异常");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "commType 参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "commType 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private void initIdeaComments(int index, int page) {
		// 初始化观点评论
		users.clear();
		logComms = LogCommSer.findLogCommByLogId(index, page);
		if (logComms.size() > 0) {
			for (LogCommen comm : logComms) {
				int uId = comm.getUserId();
				User user = UserServer.findUserNikNameById(uId);
				users.add(user);
			}
		}

	}

	private void initVideoComments(int index, int page) {
		// 初始化视频评论数据
		nComments = NewsCommSer.findCommByTypeId(page, index, 1);
		// 根据评论获取评论用户信息
		users.clear();
		for (int i = 0; i < nComments.size(); i++) {
			int userId = nComments.get(i).getuId();
			User user = UserServer.findUserById(userId);
			users.add(user);
		}

	}

	private void initNewsComms(int index, int page) {
		// 初始化新闻评论
		nComments = NewsCommSer.findCommByTypeId(page, index, 2);
		// 根据评论获取评论用户信息
		users.clear();
		for (int i = 0; i < nComments.size(); i++) {
			int userId = nComments.get(i).getuId();
			User user = UserServer.findUserById(userId);
			users.add(user);
		}

	}

}
*/