package com.jucaipen.main.video;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         直播 liveType 0 文字直播 返回参数： id image title joinNums isAttention
 * 
 *         1 视频直播 返回参数：id image title joinNums isLive
 * 
 */
@SuppressWarnings("serial")
public class LiveList extends HttpServlet {
	private String result;
	private List<FamousTeacher> teachers = new ArrayList<FamousTeacher>();
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
			String liveType = request.getParameter("liveType");
			String page = request.getParameter("page");
			if (StringUtil.isNotNull(liveType)) {
				if (StringUtil.isInteger(liveType)) {
					int type = Integer.parseInt(liveType);
					if (StringUtil.isNotNull(page)
							&& StringUtil.isInteger(page)) {
						int p = Integer.parseInt(page);
						if (type == 0) {
							// 文字直播
							result = initTxtLive(p);
						} else {
							// 视频直播
							result = initLive(p);
						}
					} else {
						result = JsonUtil.getRetMsg(3, "page 参数异常");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "liveType 参数数字格式异常");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "liveType 参数不能为空");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initLive(int page) {
		// 初始化视频直播    ----正在直播的视频
		teachers.clear();
		List<VideoLive> videos = VideoLiveServer.findLiveByIsEnd(2);
		for (VideoLive live : videos) {
			int tId = live.getTeacherId();
			FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(tId);
			if (teacher == null) {
				teacher = new FamousTeacher();
			}
			teachers.add(teacher);
		}
		return JsonUtil.getLiveList(videos, teachers);

	}

	private String initTxtLive(int page) {
		// 初始化文字直播   ---获取正在直播的文字直播
		teachers.clear();
		List<TextLive> txtLives = TxtLiveSer.findTextLiveByIsEnd(2);
		for (TextLive txt : txtLives) {
			int tId = txt.getTeacherId();
			FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(tId);
			if (teacher == null) {
				teacher = new FamousTeacher();
			}
			teachers.add(teacher);
		}
		return JsonUtil.getTxtLiveList(txtLives, teachers);
	}

}
