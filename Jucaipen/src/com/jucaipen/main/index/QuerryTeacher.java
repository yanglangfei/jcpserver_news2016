package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取名师信息 isIndex 0 首页推荐名师 返回参数：id image nickname isV notice attentions
 *         leavl isAttention
 *         [{"id":1,"nickName":"源侠","headFace":"","level":"资深投资人",
 *         "isV":0,"notice":"0","fans":17} 1 全部名师列表 返回参数：
 *         [{"page":1,"totlePage":1,"id":1,
 *         "nickName":"源侠","headFace":"","level":"资深投资人",
 *         "isV":0,"notice":"0","fans":17}
 */
@SuppressWarnings("serial")
public class QuerryTeacher extends HttpServlet {
	private String result;
	private List<com.jucaipen.model.FamousTeacher> teachers;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String isIndex = request.getParameter("isIndex");
			if (StringUtil.isNotNull(isIndex)) {
				if (StringUtil.isInteger(isIndex)) {
					int index = Integer.parseInt(isIndex);
					if (index == 0) {
						// 首页推荐名师
						initIndexData();
						result = JsonUtil.getFamousTeacherList(teachers);
					} else {
						// 全部名师列表
						String page = request.getParameter("page");
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							initAllData(p);
							result = JsonUtil.getFamousTeacherList(teachers);
						} else {
							result = JsonUtil.getRetMsg(3, "page参数有误");
						}
					}
				} else {
					result = JsonUtil.getRetMsg(2, "isIndex参数数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "isIndex参数不能为空");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private void initAllData(int page) {
		// 初始化全部名师信息
		teachers = FamousTeacherSer.findAllFamousTeacher(page);
	}

	private void initIndexData() {
		// 初始化首页名师推荐列表信息
		teachers = FamousTeacherSer.findFamousTeacherByIndex(3);
	}

}
