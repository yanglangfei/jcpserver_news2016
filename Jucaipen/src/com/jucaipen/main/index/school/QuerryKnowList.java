package com.jucaipen.main.index.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Knowledge;
import com.jucaipen.model.KnowledgeClass;
import com.jucaipen.service.KnowledgeClassSer;
import com.jucaipen.service.KnowledgetSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *  ��ȡ֪ʶ�б�
 */
@SuppressWarnings("serial")
public class QuerryKnowList extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId=request.getParameter("typeId");
		String page=request.getParameter("page");
		if(StringUtil.isNotNull(typeId)){
			if(StringUtil.isInteger(typeId)){
				int type=Integer.parseInt(typeId);
				if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
					int p=Integer.parseInt(page);
					result=initKnowList(type,p);
				}else{
					result=JsonUtil.getRetMsg(3,"page �����쳣");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"typeId �������ָ�ʽ���쳣");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"typeId ��������Ϊ��");
		}
		
		out.println(result);
		out.flush();
		out.close();
	}
	private String initKnowList(int type, int page) {
		//��ʼ��֪ʶ�б�
		KnowledgeClass kc=KnowledgeClassSer.findKnowledgeById(type);
		List<Knowledge> knows = KnowledgetSer.findKnowledgeByClassId(type, page);
		return JsonUtil.getKnowList(knows,kc);
	}

}
