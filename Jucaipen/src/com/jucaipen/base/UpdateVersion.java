package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.ApkInfo;
import com.jucaipen.service.ApkInfoServer;
import com.jucaipen.utils.JsonUtil;
/**
 * @author YLF
 * 
 *         ����apk�汾��Ϣ
 * 
 */
@SuppressWarnings("serial")
public class UpdateVersion extends HttpServlet {
	private String result;
	private ApkInfo info;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initServerVersion();
		result = JsonUtil.getApkInfo(info);
		out.print(result);
		out.flush();
		out.close();
	}

	private void initServerVersion() {
		// ��ȡ������app���°汾��
		info = ApkInfoServer.findLastApkInfo(-1);
	}

}
