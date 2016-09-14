package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.FamousTeacher;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         �༭��ʦ��Ϣ
 */
public class CompleteTeacherInfo extends HttpServlet {
	private static final long serialVersionUID = -3104489283302720134L;
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String teacherId = request.getParameter("teacherId");
		if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isNotNull(teacherId)
						&& StringUtil.isInteger(teacherId)) {
					int tId = Integer.parseInt(teacherId);
					result = completeTeacherInfo(tId, request, uId);
				} else {
					result = JsonUtil.getRetMsg(3, "teacherId �����쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "�û���û��¼");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId �����쳣");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String completeTeacherInfo(int tId, HttpServletRequest request,
			int uId) {
		FamousTeacher checkTeacher = FamousTeacherSer
				.findFamousTeacherByUserId(uId);
		if (checkTeacher == null || checkTeacher.getId() != tId) {
			return JsonUtil.getRetMsg(3, "��ǰ��ʦ��Ϣ�����޸�");
		}
		FamousTeacher teacher = new FamousTeacher();

		String trueName = request.getParameter("trueName");
		if (!StringUtil.isNotNull(trueName)) {
			return JsonUtil.getRetMsg(4, "��������ʵ����");
		}
		teacher.setTrueName(trueName);

		String headFace = request.getParameter("headFace");
		if (!StringUtil.isNotNull(headFace)) {
			
		}
		teacher.setHeadFace(headFace);

		String bankId = request.getParameter("bankId");
		if (StringUtil.isNotNull(bankId) || !StringUtil.isInteger(bankId)) {

		}
		int bId = Integer.parseInt(bankId);
		teacher.setBankId(bId);

		String bankAccount = request.getParameter("bankAccount");

		teacher.setBankAccount(bankAccount);

		String notice = request.getParameter("notice");
		if(!StringUtil.isNotNull(notice)){
			return JsonUtil.getRetMsg(5, "�����뽲ʦ����");
		}

		teacher.setNotice(notice);

		String introduce = request.getParameter("introduce");

		teacher.setIntroduce(introduce);

		String hoby = request.getParameter("hoby");
		if(!StringUtil.isNotNull(hoby)){
			return JsonUtil.getRetMsg(6, "�������ó�����");
		}

		teacher.setHoby(hoby);
		int isSuccess = FamousTeacherSer.updateTeacherBaseInfo(tId, teacher);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "��ʦ��Ϣ�޸ĳɹ�") : JsonUtil
				.getRetMsg(1, "��ʦ��Ϣ�޸�ʧ��");
	}

}
