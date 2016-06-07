package com.jucaipen.main.play;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.User;
import com.jucaipen.model.UserComm;
import com.jucaipen.service.UserCommSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ��Ƶ ֤ȯ֪ʶ ���ۻظ���Ϣ commType �������� 0 ��Ƶ���� 1 ֪ʶ����
 */
@SuppressWarnings("serial")
public class PlayComment extends HttpServlet {
	private String result;
	private List<User> users = new ArrayList<User>();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String usertAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(usertAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, usertAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String fkId = request.getParameter("fkId");
			String typeId = request.getParameter("typeId");
			String page = request.getParameter("page");
			String parentId = request.getParameter("parentId");
			if (StringUtil.isNotNull(fkId)) {
				if (StringUtil.isInteger(fkId)) {
					int fId = Integer.parseInt(fkId);
					if (StringUtil.isNotNull(typeId)
							&& StringUtil.isInteger(typeId)) {
						int tId = Integer.parseInt(typeId);
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							if (StringUtil.isNotNull(parentId)
									&& StringUtil.isInteger(parentId)) {
								int pId = Integer.parseInt(parentId);
								result = initVideComms(fId, tId, p, pId);
							} else {
								result = JsonUtil.getRetMsg(5, "parentId �����쳣");
							}
						} else {
							result = JsonUtil.getRetMsg(4, "page �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "typeId �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "fkId �������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "fkId ��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initVideComms(int fId, int tId, int p, int pId) {
		// ��ʼ����Ƶ֪ʶ ���� �ظ���Ϣ
		users.clear();
		List<UserComm> comms;
		if (tId == 0) {
			// ��Ƶ
			comms = UserCommSer.findCommenBykId(fId, p, pId, 1);
		} else {
			// ֤ȯ֪ʶ
			comms = UserCommSer.findCommenBykId(fId, p, pId, 0);
		}
		for (UserComm comm : comms) {
			int uId = comm.getUserId();
			User user = UserServer.findUserById(uId);
			if (user == null) {
				user = new User();
			}
			users.add(user);
		}
		return JsonUtil.getUserComms(comms, users);
	}
}
