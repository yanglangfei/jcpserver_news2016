package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Video;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取视频列表 非直播 isIndex 0 首页推荐视频 返回参数：id title desc image
 *         {"id":94,"title":"111","imageUrl":"","comms":0,"hits":5,"desc":"1"} 1
 *         全部
 */
@SuppressWarnings("serial")
public class VideoList extends HttpServlet {
	private String result;
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
						// 首页推荐视频
						result=initIndexData();
					} else {
						// 全部视频
						String page = request.getParameter("page");
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p=Integer.parseInt(page);
							result=initAllData(p);
						} else {
							result = JsonUtil.getRetMsg(2, "page参数异常");
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
		out.print(result);
		out.flush();
		out.close();
	}

	private String initAllData(int p) {
		// 初始化全部数据
		List<Video> videos = VideoServer.findVideoByClassId(1,p);
		return JsonUtil.getVideoList(videos);
	}

	private String initIndexData() {
		// 初始化首页数据
		List<Video> videos = VideoServer.findVideoByClassIdLast(2, 1);
		return  JsonUtil.getVideoList(videos);
	}

}
