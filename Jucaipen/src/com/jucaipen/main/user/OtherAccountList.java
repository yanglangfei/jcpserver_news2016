package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.User;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ�������˺���Ϣ
 * 
 */
@SuppressWarnings("serial")
public class OtherAccountList extends HttpServlet {
	private User user;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String userId = request.getParameter("userId");
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					querryOtherAccount(uId);
					if (user != null) {
						result = JsonUtil.getOtherAccountList(user);
					} else {
						result = JsonUtil.getRetMsg(1, "��ȡ��Ϣ�쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(5, "��ǰ�û���û��¼");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "�û�id�������ָ�ʽ���쳣");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void querryOtherAccount(int uId) {
		// ��ѯ�������˺���Ϣ
		user = UserServer.querryOtherAccount(uId);

	}

}
