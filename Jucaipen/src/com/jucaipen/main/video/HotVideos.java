package com.jucaipen.main.video;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Video;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.JsonUtil;

/**
 * @author Administrator
 *
 *  获取热门搜索视频
 */
@SuppressWarnings("serial")
public class HotVideos extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		result=initHotVideoList();
		out.println(result);
		out.flush();
		out.close();
	}

	private String initHotVideoList() {
		List<Video> videos = VideoServer.findHotVideoList(8);
		return JsonUtil.getHotVideo(videos);
	}

}
