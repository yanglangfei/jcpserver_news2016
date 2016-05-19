package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.NewsClass;
import com.jucaipen.service.NewsClassSer;
import com.jucaipen.utils.JsonUtil;

/**
 * @author Administrator
 *
 *   ��ȡ�����б�
 */
@SuppressWarnings("serial")
public class QuerryAskType extends HttpServlet {

	private List<NewsClass> askTypes;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    initAskClass();
		result=JsonUtil.getAskClassList(askTypes);
		out.println(result);
		out.flush();
		out.close();
	}

	/**
	 *   ��ʼ�����ʷ����б�
	 */
	private void initAskClass() {
		askTypes=NewsClassSer.getClassByPId(0);
	}

}
