package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.City;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.CityServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator ��ѯ���г�����Ϣ
 */

@SuppressWarnings("serial")
public class QuerryCity extends HttpServlet {
	private String result;
	private List<City> cities = new ArrayList<City>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent=request.getParameter("User-Agent");
		ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);
		int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			String provinceId=request.getParameter("provinceId");
			if(StringUtil.isInteger(provinceId)){
				int pId=Integer.parseInt(provinceId);
				initCityInfo(pId);
				result = JsonUtil.getObject(cities);
			}else {
				result=JsonUtil.getRetMsg(1, "ʡ��id�������ָ�ʽ���쳣");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initCityInfo(int pId) {
		cities.clear();
		cities = CityServer.getCitys(pId);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
