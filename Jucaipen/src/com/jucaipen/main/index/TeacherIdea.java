package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.HotIdea;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ��ʦ�۵� isIndex 0 1 ȫ���� ���ز����� id image nickname isV level title desc
 *         insertDate comments goods
 *         {"page":1,"totlePage":1,"id":21,"insertDate"
 *         :"2016-03-02","title":"1", "bodys":"1","hits":8,"teacherId":1,
 *         "nickName":"Դ��","level":"����Ͷ����","headFace":"","isV":0}
 *                       2 ���ݽ�ʦid��ѯ
 * 
 */
@SuppressWarnings("serial")
public class TeacherIdea extends HttpServlet {
	private String result;
	private List<HotIdea> hotIdeas;
	private List<FamousTeacher> teachers = new ArrayList<FamousTeacher>();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String isIndex = request.getParameter("isIndex");
		String page = request.getParameter("page");
		if (StringUtil.isNotNull(isIndex)) {
			if (StringUtil.isInteger(isIndex)) {
				int index = Integer.parseInt(isIndex);
				if (StringUtil.isNotNull(page) && StringUtil.isInteger(page)) {
					int p = Integer.parseInt(page);
					if (index == 0) {
						//��ҳ��Ϣ
						initIndexIdea();
					} else if (index == 1) {
						//ȫ����Ϣ
						initAllIdea(p);
						result = JsonUtil.getAllHotIdeaList(hotIdeas, teachers);
					} else if (index == 2) {
						// ���ݽ�ʦid��ѯ
						String teacherId=request.getParameter("teacherId");
						if(StringUtil.isNotNull(teacherId)&&StringUtil.isInteger(teacherId)){
							int tId=Integer.parseInt(teacherId);
							initIdeaByTeacherId(tId,p);
							result=JsonUtil.getAllHotIdeaList(hotIdeas, teachers);
						}else{
							result=JsonUtil.getRetMsg(4,"��ʦid�����쳣");
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
		out.print(result);
		out.flush();
		out.close();
	}

	private void initIdeaByTeacherId(int tId,int page) {
		// ���ݽ�ʦid��ȡ�۵�
		teachers.clear();
		hotIdeas=HotIdeaServ.findIdeaByTeacherId(tId, page);
		for(HotIdea idea : hotIdeas){
			int teacherId=idea.getTeacherId();
			FamousTeacher teacher = FamousTeacherSer
					.findFamousTeacherById(teacherId);
			if(teacher==null){
				teacher=new FamousTeacher();
			}
			teachers.add(teacher);
		}
	}

	private void initIndexIdea() {
		//

	}

	private void initAllIdea(int page) {
		// ��ʼ��ȫ����ʦ�۵�
		teachers.clear();
		hotIdeas = HotIdeaServ.findAllHotIdea(page);
		for (HotIdea idea : hotIdeas) {
			int teacherId = idea.getTeacherId();
			FamousTeacher teacher = FamousTeacherSer
					.findFamousTeacherById(teacherId);
			if(teacher==null){
				teacher=new FamousTeacher();
			}
			teachers.add(teacher);
		}
	}

}
