package com.jucaipen.main.video;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Video;
import com.jucaipen.model.VideoType;
import com.jucaipen.service.VideoServer;
import com.jucaipen.service.VideoTypeSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取视频列表 ---具有分类信息
 */
@SuppressWarnings("serial")
public class QuerryVide extends HttpServlet {
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
			result = initVideoList();
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initVideoList() {
		// 获取视频列表
		JsonArray array = new JsonArray();
		List<VideoType> types = VideoTypeSer.findAll();
		for (VideoType t : types) {
			JsonObject obj1 = new JsonObject();
			int id = t.getId();
			String typeName = t.getTitle();
			obj1.addProperty("typeId", id);
			obj1.addProperty("typeName", typeName);
			JsonArray arr1 = new JsonArray();
			List<Video> videos = VideoServer.findVideoByIsIndexId(2, id);
			for (Video v : videos) {
				JsonObject obj2 = new JsonObject();
				obj2.addProperty("title", v.getTitle());
				obj2.addProperty("image", v.getImages());
				obj2.addProperty("desc", v.getDescript());
				arr1.add(obj2);
			}
			obj1.add("item", arr1);
			array.add(obj1);
		}
		return array.toString();
	}
}
