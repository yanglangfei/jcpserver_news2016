package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.service.AdverSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * 获取广告页面
 * 
 * type ---1 首页广告 ----3 股票频道首页 --- 5新三板幻灯片
 */
@SuppressWarnings("serial")
public class QuerryAdvise extends HttpServlet {

	private Object advertives;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("type");
		if (StringUtil.isNotNull(typeId)) {
			if (StringUtil.isInteger(typeId)) {
				int type = Integer.parseInt(typeId);
				if (type == 1) {
					// 首页广告幻灯片
					initIndexPageData();
					result = JsonUtil.getObject(advertives);
				} else if (type == 3) {
					// 股票频道首页幻灯片
					result = JsonUtil.getRetMsg(2, "广告类型参数数字格式化异常");
				} else if (type == 5) {
					// 新三股幻灯片
					result = JsonUtil.getRetMsg(3, "广告类型参数数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "广告类型参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(4, "参数不能为空");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initIndexPageData() {
		// 加载首页广告
		advertives = AdverSer.findAdverByPid(6);
	}

}
