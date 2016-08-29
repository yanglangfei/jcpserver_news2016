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
import com.jucaipen.model.Fans;
import com.jucaipen.model.User;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.FansSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ�ҵĹ�ע type 0 �ҹ�ע�� 1 ��ע�ҵ� ����Խ�ʦ��
 */
public class MyAttention extends HttpServlet {
	private static final long serialVersionUID = -7941347929976544598L;
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
			String hasPage = request.getParameter("hasPage");
			if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(hasPage)
							&& StringUtil.isInteger(hasPage)) {
						int isPage = Integer.parseInt(hasPage);
						if (isPage == 0) {
							// �޷�ҳ
							result = initNoPageAttention(uId);
						} else {
							// ��ҳ
							String page = request.getParameter("page");
							String type = request.getParameter("type");
							if (StringUtil.isNotNull(page)
									&& StringUtil.isInteger(page)) {
								int p = Integer.parseInt(page);
								if (StringUtil.isNotNull(type)
										&& StringUtil.isInteger(type)) {
									int t = Integer.parseInt(type);
									result = initAttention(uId, t, p);
								} else {
									result = JsonUtil.getRetMsg(5, "type �����쳣");
								}
							} else {
								result = JsonUtil.getRetMsg(4, "page �����쳣");
							}
						}
					} else {
						result = JsonUtil.getRetMsg(3, "hasPage �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "�û���û��¼");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "userId �����쳣");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	/**
	 * @param uId
	 * @return
	 */
	private String initNoPageAttention(int uId) {
		teachers.clear();
		List<Fans> fans = FansSer.findFansByUid(uId);
		if (fans != null) {
			for (Fans f : fans) {
				int tid = f.getTeacherId();
				FamousTeacher teacher = FamousTeacherSer
						.findFamousTeacherById(tid);
				teachers.add(teacher);
			}
		}
		return JsonUtil.getAttentioner(teachers);
	}

	/**
	 * @param uId
	 * @param t
	 * @param p
	 * @return ��ʼ����ע��Ϣ �з�ҳ
	 */
	private String initAttention(int uId, int t, int p) {
		teachers.clear();
		users.clear();
		List<Fans> fans;
		if (t == 0) {
			// �ҹ�ע��
			fans = FansSer.findFansByUid(uId, p);
		} else {
			// ��ע�ҵģ���Խ�ʦ��
			fans = FansSer.findFansByTeacherId(uId, p);
		}
		if (fans != null) {
			for (Fans f : fans) {
				int uid = f.getUserId();
				int tid = f.getTeacherId();
				if (t == 0) {
					FamousTeacher teacher = FamousTeacherSer
							.findFamousTeacherById(tid);
					teachers.add(teacher);
				} else {
					User u = UserServer.findUserById(uid);
					users.add(u);
				}
			}
		}
		if (t == 0) {
			return JsonUtil.getTeacherAttention(fans, teachers);
		} else {
			return JsonUtil.getUserAttention(fans, users);
		}
	}

}
