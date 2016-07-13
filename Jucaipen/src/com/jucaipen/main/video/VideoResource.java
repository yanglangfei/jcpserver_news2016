package com.jucaipen.main.video;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.MySpecial;
import com.jucaipen.model.MyVideo;
import com.jucaipen.model.Special;
import com.jucaipen.model.Video;
import com.jucaipen.service.MySpecialSer;
import com.jucaipen.service.MyVideoSer;
import com.jucaipen.service.SpecialSer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ��ȡ��Ƶ��Դ videoUrl isPurch
 */
@SuppressWarnings("serial")
public class VideoResource extends HttpServlet {
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
			String videoId = request.getParameter("videoId");
			String userId = request.getParameter("userId");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (StringUtil.isNotNull(videoId)) {
						if (StringUtil.isInteger(videoId)) {
							int id = Integer.parseInt(videoId);
							if (uId > 0) {
								result = initVideoResource(id, uId);
							} else {
								result = JsonUtil.getRetMsg(5, "�û���û��¼");
							}
						} else {
							result = JsonUtil.getRetMsg(1, "����videoId ���ָ�ʽ���쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(2, "����videoId ����Ϊ��");
					}
				} else {
					result = JsonUtil.getRetMsg(4, "����userId ���ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(3, "���� userId ����Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initVideoResource(int id, int uId) {
		// ��ȡ��Ƶ��Դ
		Video video = VideoServer.findVideoResourceById(id);
		MyVideo myVideo = MyVideoSer.findIsMyVideo(uId, id);
		int videoType = video.getVideoType();
		int specialId = video.getPecialId();
		video.setCharge(videoType == 1);
		if (myVideo != null) {
			if (TimeUtils.isLive(myVideo.getStartDate(), myVideo.getEndDate())) {
				video.setIsPurch(0);
			} else {
				video.setIsPurch(2);
			}
		} else {
			video.setIsPurch(1);
		}
		if (specialId > 0) {
			Special special = SpecialSer.findSpecialById(specialId);
			int isFree = special.getIsFree();
			video.setCharge(isFree == 2);
			MySpecial mySpecial = MySpecialSer.getIsMySpecial(uId, specialId);
			if (mySpecial != null) {
				if (TimeUtils.isLive(mySpecial.getStartDate(),
						mySpecial.getEndDate())) {
					video.setIsPurch(0);
				} else {
					video.setIsPurch(2);
				}
			}
		}
		return JsonUtil.getLiveUrl(video);
	}
}