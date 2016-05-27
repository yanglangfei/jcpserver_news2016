package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Area;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.AreaServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ����Ϣ
 * 
 */
@SuppressWarnings("serial")
public class QuerryArea extends HttpServlet {
	private String result;
	private List<Area> areas = new ArrayList<Area>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");                         
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent=request.getParameter("User-Agent");
		ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);
		int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			String cityId = request.getParameter("cityId");
			if (StringUtil.isInteger(cityId)) {
				int cId = Integer.parseInt(cityId);
				initAreaData(cId);
				result = JsonUtil.getObject(areas);
			} else {
				result = JsonUtil.getRetMsg(1, "����id�������ָ�ʽ���쳣");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initAreaData(int cId) {
		// ��ʼ������Ϣ
		areas = AreaServer.getAreas(0, cId);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
