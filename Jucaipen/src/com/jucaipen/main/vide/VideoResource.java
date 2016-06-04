package com.jucaipen.main.vide;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取视频资源
 */
@SuppressWarnings("serial")
public class VideoResource extends HttpServlet {
	private String result;
	private VideoLive live;

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
			String videoId = request.getParameter("videoId");
			String userId = request.getParameter("userId");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (StringUtil.isNotNull(videoId)) {
						if (StringUtil.isInteger(videoId)) {
							int id = Integer.parseInt(videoId);
							if (id == 1 && uId > 0) {
								initVideoResource(id);
								result = JsonUtil.getLiveUrl(live);
							} else {
								result = JsonUtil.getRetMsg(5, "用户还没登录");
							}
						} else {
							result = JsonUtil.getRetMsg(1, "参数videoId 数字格式化异常");
						}
					} else {
						result = JsonUtil.getRetMsg(2, "参数videoId 不能为空");
					}
				} else {
					result = JsonUtil.getRetMsg(4, "参数userId 数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(3, "参数 userId 不能为空");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private void initVideoResource(int id) {
		// 获取视频资源
		live = VideoLiveServer.getRoomLiveUrl(id);
	}

}
