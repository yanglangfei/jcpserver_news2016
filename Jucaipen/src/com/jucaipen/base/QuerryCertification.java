package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Certification;
import com.jucaipen.service.CertificationSer;
import com.jucaipen.utils.JsonUtil;

/**
 * @author Administrator
 *
 *  ��ȡ�ʸ�֤���б�
 */
@SuppressWarnings("serial")
public class QuerryCertification extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		result=initCertificationList();
		out.println(result);
		out.flush();
		out.close();
	}

	/**
	 * @return  ��ʼ���ʸ�֤���б�
	 */
	private String initCertificationList() {
		List<Certification> certs = CertificationSer.findAllCertification();
		return JsonUtil.getCertificationList(certs);
	}

}
