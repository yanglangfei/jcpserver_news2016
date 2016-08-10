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
 */
@SuppressWarnings("serial")
public class BindOtherAccount extends HttpServlet {
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
		if (StringUtil.isNotNull(userId)&&StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isNotNull(accountType)&&StringUtil.isInteger(accountType)) {
					int type = Integer.parseInt(accountType);
					if (type == 0 || type == 1 || type == 2) {
						User u = checkAccountIsBind(type, accountId);
						//�û�������    --��       
						if ((accountId==null||accountId.trim().equals(""))||u == null) {
							int res=insertOtherAccount(uId, type, accountId);
							if (res == 1) {
								result = JsonUtil.getRetMsg(0, "�˺ű���ɹ�");
							} else {
								result = JsonUtil.getRetMsg(1, "�˺ű���ʧ��");
							}
						} else {
							result = JsonUtil.getRetMsg(7, "���˺��Ѱ�");
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
			// qq
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

	private int insertOtherAccount(int uId, int type, String accountId) {
		// �޸ĵ������˺�id
		return  UserServer.updateAccountId(uId, type, accountId);

	}

}
