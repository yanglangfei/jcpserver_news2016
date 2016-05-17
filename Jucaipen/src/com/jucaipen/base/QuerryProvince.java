package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Province;
import com.jucaipen.service.ProvinceServer;
import com.jucaipen.utils.JsonUtil;

/**
 * @author Administrator
 * 
 *         ��ѯʡ����Ϣ
 * 
 */
@SuppressWarnings("serial")
public class QuerryProvince extends HttpServlet {
	private String result;
	private List<Province> provinces = new ArrayList<Province>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initProvinceInfo();
		result = JsonUtil.getObject(provinces);
		out.print(result);
		out.flush();
		out.close();
	}

	private void initProvinceInfo() {
		provinces.clear();
		provinces = ProvinceServer.getProvinces();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
