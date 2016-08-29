package com.jucaipen.main.index.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.KnowledgeClass;
import com.jucaipen.service.KnowledgeClassSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator ��ȡѧԺ����֪ʶ ������Ϣ 
 * 
 */
public class BaseKnowType extends HttpServlet {
	private static final long serialVersionUID = 7671859603719461192L;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String leavel = request.getParameter("leavel");
		String bigId = request.getParameter("bigId");
		if (StringUtil.isNotNull(bigId)) {
			if (StringUtil.isInteger(bigId)) {
				int bId = Integer.parseInt(bigId);
				if (StringUtil.isNotNull(leavel)
						&& StringUtil.isInteger(leavel)) {
					int lId = Integer.parseInt(leavel);
					result = initBaseType(bId, lId);
				}else{
					result=JsonUtil.getRetMsg(3,"leavel �����쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "bigId �������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "bigId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initBaseType(int pId, int lId) {
		//��ʼ��ѧԺ������Ϣ
		List<KnowledgeClass> knowTypes = KnowledgeClassSer
				.findKnowClassByPid(pId);
		if (lId == 0) {
			return JsonUtil.getSingleKnowType(knowTypes);
		}
		return JsonUtil.getMoreKnowType(knowTypes);
	}

}
