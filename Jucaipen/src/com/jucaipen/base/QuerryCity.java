package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Administrator 查询所有城市信息
 */

@SuppressWarnings("serial")
public class QuerryCity extends HttpServlet {
	private String result;
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
				result=initCityInfo(pId);
			}else {
				result=JsonUtil.getRetMsg(1, "省份id参数数字格式化异常");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initCityInfo(int pId) {
		List<City> cities = CityServer.getCitys(pId);
		return JsonUtil.getObject(cities);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
