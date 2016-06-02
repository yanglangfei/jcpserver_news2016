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
 * @author Administrator
 *      ��ȡѧԺ����֪ʶ ������Ϣ   getbasetype
 *      
 */
@SuppressWarnings("serial")
public class BaseKnowType extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String bigId=request.getParameter("bigId");
		if(StringUtil.isNotNull(bigId)){
			if(StringUtil.isInteger(bigId)){
				int bId=Integer.parseInt(bigId);
				result=initBaseType(bId);
			}else{
				result=JsonUtil.getRetMsg(2,"bigId �������ָ�ʽ���쳣");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"bigId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}
	private String initBaseType(int pId) {
		//��ʼ��ѧԺ������Ϣ
		List<KnowledgeClass> knowTypes = KnowledgeClassSer.findKnowClassByPid(pId);
		return JsonUtil.getKnowType(knowTypes);
	}

}
