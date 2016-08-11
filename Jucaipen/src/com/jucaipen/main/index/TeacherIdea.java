package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.HotIdea;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         ��ȡ��ʦ�۵� isIndex 
 *                   0   ��ҳ 
 *                   1   ȫ�� 
 *                   2   ���ݽ�ʦid��ѯ
 */
@SuppressWarnings("serial")
public class TeacherIdea extends HttpServlet {
	private String result;
	private List<HotIdea> hotIdeas;
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
			String isIndex = request.getParameter("isIndex");
			String page = request.getParameter("page");
			if (StringUtil.isNotNull(isIndex)) {
				if (StringUtil.isInteger(isIndex)) {
					int index = Integer.parseInt(isIndex);
					if (StringUtil.isNotNull(page)
							&& StringUtil.isInteger(page)) {
						int p = Integer.parseInt(page);
						if (index == 0) {
							// ��ҳ��Ϣ
							result = initIndexIdea();
						} else if (index == 1) {
							// ȫ����Ϣ
							result = initAllIdea(p);
						} else if (index == 2) {
							// ���ݽ�ʦid��ѯ
							String teacherId = request
									.getParameter("teacherId");
							if (StringUtil.isNotNull(teacherId)
									&& StringUtil.isInteger(teacherId)) {
								int tId = Integer.parseInt(teacherId);
								result = initIdeaByTeacherId(tId, p);
							} else {
								result = JsonUtil.getRetMsg(4, "��ʦid�����쳣");
							}
						}
					} else {
						result = JsonUtil.getRetMsg(3, "page �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "isIndex �������ָ�ʽ���쳣");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "isIndex��������Ϊ��");
			}

		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initIdeaByTeacherId(int tId, int page) {
		// ���ݽ�ʦid��ȡ�۵�
		FamousTeacher teacher = FamousTeacherSer
				.findFamousTeacherById(tId);
		hotIdeas = HotIdeaServ.findIdeaByTeacherId(tId, page);
		for (HotIdea idea : hotIdeas) {
			if (teacher == null) {
				teacher = new FamousTeacher();
			}
			idea.setTeacherFace(teacher.getHeadFace());
			idea.setTeacherIsV(teacher.getIsV());
			idea.setTeacherLeavel(teacher.getLevel());
			idea.setTeacherName(teacher.getNickName());
		}
		return JsonUtil.getAllHotIdeaList(hotIdeas);
	}

	private String initIndexIdea() {
		// ��ȡ��ҳ���Ź۵���Ϣ ��ҳ ��ѡ
		hotIdeas = HotIdeaServ.findIndexIdea(3);
		return JsonUtil.getIndexList(hotIdeas);
	}

	private String initAllIdea(int page) {
		// ��ʼ��ȫ����ʦ�۵�
		hotIdeas = HotIdeaServ.findAllHotIdea(page);
		for (HotIdea idea : hotIdeas) {
			int teacherId = idea.getTeacherId();
			FamousTeacher teacher = FamousTeacherSer
					.findFamousTeacherById(teacherId);
			if (teacher == null) {
				teacher = new FamousTeacher();
			}
			idea.setTeacherFace(teacher.getHeadFace());
			idea.setTeacherIsV(teacher.getIsV());
			idea.setTeacherLeavel(teacher.getLevel());
			idea.setTeacherName(teacher.getNickName());
		}
		return JsonUtil.getAllHotIdeaList(hotIdeas);
	}

}
