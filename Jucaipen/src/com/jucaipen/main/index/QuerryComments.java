package com.jucaipen.main.index;

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

/**
 * @author Administrator
 * 
 *         ��ȡ������Ϣ commType �������� 0 �������� 1 ��Ƶ���� 2 �۵�����
 */
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
							// ��������
							initNewsComms(index, p);
							result=JsonUtil.getNewsCommList(nComments, users);
						} else if (type == 1) {
							// ��Ƶ����
							initVideoComments(index, p);
							result=JsonUtil.getNewsCommList(nComments, users);
						} else {
							// �۵�����
							initIdeaComments(index, p);
							result = JsonUtil.getIdeaCommList(logComms, users);
						}
					} else {
						result = JsonUtil.getRetMsg(4, "page �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "id �����쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "commType �������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "commType ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private void initIdeaComments(int index, int page) {
		// ��ʼ���۵�����
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
		// ��ʼ����Ƶ��������
		nComments = NewsCommSer.findCommByTypeId(page, index, 1);
		// �������ۻ�ȡ�����û���Ϣ
		users.clear();
		for (int i = 0; i < nComments.size(); i++) {
			int userId = nComments.get(i).getuId();
			User user = UserServer.findUserById(userId);
			users.add(user);
		}

	}

	private void initNewsComms(int index, int page) {
		// ��ʼ����������
		nComments = NewsCommSer.findCommByTypeId(page, index, 2);
		// �������ۻ�ȡ�����û���Ϣ
		users.clear();
		for (int i = 0; i < nComments.size(); i++) {
			int userId = nComments.get(i).getuId();
			User user = UserServer.findUserById(userId);
			users.add(user);
		}

	}

}
