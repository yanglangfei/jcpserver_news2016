package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ApkInfo;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.ApkInfoServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author YLF
 * 
 *         更新apk版本信息
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
		String userAgent=request.getParameter("User-Agent");
        ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);	
        int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			result=initServerVersion();
		}else{
			result=StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initServerVersion() {
		// 获取服务器app最新版本号
		info = ApkInfoServer.findLastApkInfo(-1);
		return JsonUtil.getApkInfo(info);
	}

}
