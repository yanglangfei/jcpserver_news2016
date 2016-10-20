package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.User;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author YLF
 * 
 * 
 *         �󶨵������˺� ---------------��� userId ���˺ŵ��û�id accountType ���˺����� ----0
 *         QQ -----1 ΢�� -----2 ���� accountId ���˺ŵ�id
 * 
 * 
 *         opType 1 �� 2 ���
 * 
 */
public class BindOtherAccount extends HttpServlet {
	private static final long serialVersionUID = 4403585027823706943L;
	private String result;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String accountType = request.getParameter("accountType");
		String accountId = request.getParameter("accountId");
		System.out.println("u:" + userId + "    t:" + accountType + "   id:"
				+ accountId);
		if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isNotNull(accountType)
						&& StringUtil.isInteger(accountType)) {
					int type = Integer.parseInt(accountType);
					if (type == 0 || type == 1 || type == 2) {
						User u = checkAccountIsBind(type, accountId);
						if (accountId == null || accountId.trim().length() <= 0) {
							// ����˺�
							if (u == null) {
								// �˺��Ѿ����
								result = JsonUtil.getRetMsg(1, "�˺��Ѿ����");
							} else {
								int res = delOtherAccount(uId, type);
								result = res == 1 ? JsonUtil.getRetMsg(0,
										"�˺Ž���ɹ�") : JsonUtil.getRetMsg(2,
										"�˺Ž��ʧ��");
							}
						} else {
							// ���˺�
							if (u != null) {
								result = JsonUtil.getRetMsg(1, "�˺��Ѿ���");
							} else {
								int res = insertOtherAccount(uId, type,
										accountId);
								result = res == 1 ? JsonUtil.getRetMsg(0,
										"�˺Ű󶨳ɹ�") : JsonUtil.getRetMsg(2,
										"�˺Ű�ʧ��");
							}
						}
					} else {
						result = JsonUtil.getRetMsg(6, "�˺����Ͳ�������Ϊ0��1��2");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "�˺����Ͳ������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(5, "��ǰ�û���û��¼");
			}
		} else {
			result = JsonUtil.getRetMsg(4, "�û�id�������ָ�ʽ���쳣");
		}
		System.out.println("result:" + result);
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param type
	 * @param accountId
	 * 
	 *            ��֤�˺��Ƿ��
	 */
	private User checkAccountIsBind(int type, String accountId) {
		User user;
		if (type == 0) {
			// QQ
			user = UserServer.findUserByQQId(accountId);
		} else if (type == 1) {
			// ΢��
			user = UserServer.findUserByWeixinId(accountId);
		} else if (type == 2) {
			// ����
			user = UserServer.findUserBySinaId(accountId);
		} else {
			user = new User();
		}
		return user;

	}

	/**
	 * @param uId
	 * @param type
	 * @return ����������˺�
	 */
	private int delOtherAccount(int uId, int type) {
		return UserServer.delAccountId(uId, type);
	}

	/**
	 * @param uId
	 * @param type
	 * @param accountId
	 * @return �󶨵������˺�
	 */
	private int insertOtherAccount(int uId, int type, String accountId) {
		return UserServer.updateAccountId(uId, type, accountId);
	}

}
