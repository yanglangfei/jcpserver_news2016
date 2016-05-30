package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Comment;
import com.jucaipen.model.User;
import com.jucaipen.service.CommentSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator   getlogcomments
 * 
 *         ��ȡ��־ ����ֱ�� ���ۻظ���Ϣ commType �������� 0 ��־���� 1 ����ֱ������
 */
@SuppressWarnings("serial")
public class QuerryComments extends HttpServlet {
	private String result;
	private List<User> users = new ArrayList<User>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String commType = request.getParameter("commType");
			String id = request.getParameter("id");
			String page = request.getParameter("page");
			String parentId = request.getParameter("parentId");
			if (StringUtil.isNotNull(commType)) {
				if (StringUtil.isInteger(commType)) {
					int type = Integer.parseInt(commType);
					if (StringUtil.isNotNull(id) && StringUtil.isInteger(id)) {
						int index = Integer.parseInt(id);
						if (StringUtil.isNotNull(parentId)
								&& StringUtil.isInteger(parentId)) {
							int pId = Integer.parseInt(parentId);
							if (StringUtil.isNotNull(page)
									&& StringUtil.isInteger(page)) {
								int p = Integer.parseInt(page);
								result = initLogAndTxtComms(index, p, pId, type);
							} else {
								result = JsonUtil.getRetMsg(4, "page �����쳣");
							}
						} else {
							result = JsonUtil.getRetMsg(5, "parentId �����쳣");
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
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initLogAndTxtComms(int index, int p, int pId, int type) {
		// ��ʼ�� ��־ ����ֱ������ �ظ���Ϣ
		users.clear();
		List<Comment> comms;
		if (type == 0) {
			comms = CommentSer.findCommenBykId(index, p, pId, 1);
		} else {
			comms = CommentSer.findCommenBykId(index, p, pId, 2);
		}
		for (Comment comment : comms) {
			int uId = comment.getUserId();
			User user = UserServer.findUserById(uId);
			if (user == null) {
				user = new User();
			}
			users.add(user);
		}
		return JsonUtil.getLogAndTxtComms(comms, users);

	}

}
