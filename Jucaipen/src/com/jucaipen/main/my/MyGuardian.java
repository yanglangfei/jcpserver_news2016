package com.jucaipen.main.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Guardian;
import com.jucaipen.model.User;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ�ҵ��ػ� type 0 ���ػ��� 1 �ػ��ҵ� ����Խ�ʦ��
 */
public class MyGuardian extends HttpServlet {
	private static final long serialVersionUID = -8293459433867652032L;
	private String result;
	private List<FamousTeacher> teachers = new ArrayList<FamousTeacher>();
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
			String userId = request.getParameter("userId");
			String page = request.getParameter("page");
			String type = request.getParameter("type");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							if (StringUtil.isNotNull(type)
									&& StringUtil.isInteger(type)) {
								int t = Integer.parseInt(type);
								result = initMyGuardian(uId, t, p);
							} else {
								result = JsonUtil.getRetMsg(2, "type �����쳣");
							}
						} else {
							result = JsonUtil.getRetMsg(4, "page �����쳣");
						}

					} else {
						result = JsonUtil.getRetMsg(3, "���û���û��¼");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "userId �������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(1, " userId ��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initMyGuardian(int uId, int t, int p) {
		// ��ʼ���ҵ��ػ� /�ػ��ҵ�
		teachers.clear();
		users.clear();
		List<Guardian> guardians;
		if (t == 0) {
			// ���ػ���
			guardians = GuardianSer.findGurdianByUid(uId, p);
		} else {
			// �ػ��ҵ�
			guardians = GuardianSer.findGuradianByTeacherId(uId, p);
		}
		for (Guardian guardian : guardians) {
			int tId = guardian.getTeacherId();
			int uid = guardian.getUserId();
			if (t == 0) {
				FamousTeacher teacher = FamousTeacherSer
						.findFamousTeacherById(tId);
				teachers.add(teacher);
			} else {
				User user = UserServer.findUserById(uid);
				users.add(user);
			}
		}
		if (t == 0) {
			return JsonUtil.getMyGuardian(guardians, teachers);
		} else {
			return JsonUtil.getGuardianMy(guardians, users);
		}
	}

}
