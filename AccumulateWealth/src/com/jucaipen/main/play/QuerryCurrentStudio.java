package com.jucaipen.main.play;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Studio;
import com.jucaipen.service.StudioSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ��ȡ�ݲ�
 */
public class QuerryCurrentStudio extends HttpServlet {
	private static final long serialVersionUID = 845421431112793609L;
	private String result;
	private String userAgent;
	private String playUrl;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		userAgent = request.getHeader("User-Agent");
		PrintWriter out = response.getWriter();
		if(userAgent.contains("iOS")){
			playUrl=StringUtil.play_IOS;
		}else{
			playUrl=StringUtil.playUrl_MU;
		}
		result = initCurrentStudio();
		out.println(result);
		out.flush();
		out.close();
	}

	private String initCurrentStudio() {
		List<Studio> studios = StudioSer.findStudioByToday(TimeUtils.getWeek());
		for (Studio studio : studios) {
			// �Ƿ���� 1δ��ʼ 2������ 3����
			String startDate = studio.getStartDate();
			String endDate = studio.getEndDate();
			boolean isLive = TimeUtils.isHourLive(startDate, endDate);
			if (isLive) {
				return JsonUtil.getCurrentStudio(studio,playUrl);
			}
		}
		return JsonUtil.getNoStudioState(1,playUrl);
	}
}
