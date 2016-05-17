package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.ExpressionType;
import com.jucaipen.service.FaceTypeServer;
import com.jucaipen.utils.JsonUtil;

/**
 * @author YLF
 * 
 *   ��ȡ���б������Ϣ
 *
 */
@SuppressWarnings("serial")
public class QuerryExpressType extends HttpServlet {
	private List<ExpressionType> types;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initFaceType();
		result=JsonUtil.getExpressionType(types);
		out.print(result);
		out.flush();
		out.close();
	}
	private void initFaceType() {
		//��ʼ���������Ϣ
		types=FaceTypeServer.findAllFace();
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request, response);
	}

}
