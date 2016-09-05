package com.jucaipen.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ServerManager;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��¼��̨����ϵͳ
 * 
 */
public class LoginServer extends HttpServlet {
	private static final long serialVersionUID = -2446747156672320315L;
	private String result;
	private Connection dbConn; 
	private ServerManager manager;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if (StringUtil.isNotNull(account)) {
			if (StringUtil.isNotNull(password)) {
				// ��ѯ�û���Ϣ
				manager = querryServerManagerInfo(account);
				if (manager != null) {
					// ��ǰ�˺Ŵ���
					String pwd = manager.getPassword();
					if (password.equals(pwd)) {
						// ��¼�ɹ�
						request.getRequestDispatcher("index.jsp").forward(
								request, response);
					} else {
						// �������
						result = JsonUtil.getRetMsg(3, "�����������");
					}
				} else {
					// ��ǰ�˺Ų�����
					result = JsonUtil.getRetMsg(4, "�˺��������");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "���벻��Ϊ��");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "�˺Ų���Ϊ��");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private ServerManager querryServerManagerInfo(String account) {
		// ��ѯ����Ա��Ϣ
		try {
			dbConn = JdbcUtil.connMySql();
			Statement sta = dbConn.createStatement();
			ResultSet res = sta
					.executeQuery("select * from manager where userName='"
							+ account + "'");
			while (res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String telPhone = res.getString("telPhone");
				String userName = res.getString("userName");
				String password = res.getString("password");
				manager = new ServerManager();
				manager.setId(id);
				manager.setName(name);
				manager.setTelPhone(telPhone);
				manager.setUserName(userName);
				manager.setPassword(password);
			}
			return manager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
