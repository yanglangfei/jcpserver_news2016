package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Advertive;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.AdverSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * 获取广告页面
 * 
 * type ---10  首页    8 学院 
 */
@SuppressWarnings("serial")
public class QuerryAdvise extends HttpServlet {
	private List<Advertive> advertives;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getHeader("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String typeId = request.getParameter("type");
			if (StringUtil.isNotNull(typeId)) {
				if (StringUtil.isInteger(typeId)) {
					int type = Integer.parseInt(typeId);
					initIndexPageData(type);
					result = JsonUtil.getObject(advertives);
				} else {
					result = JsonUtil.getRetMsg(1, "广告类型参数数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(4, "参数不能为空");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initIndexPageData(int type) {
		// 加载首页广告
		advertives = AdverSer.findAdverByPid(type);
	}

}
