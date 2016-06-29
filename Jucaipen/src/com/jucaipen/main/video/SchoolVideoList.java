package com.jucaipen.main.video;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Special;
import com.jucaipen.model.Video;
import com.jucaipen.service.SpecialSer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡѧԺ��Ƶ�̳��б�
 */
@SuppressWarnings("serial")
public class SchoolVideoList extends HttpServlet {
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
			result=initTeachList();
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}
	
	private String initTeachList() {
		// ��ʼ����Ƶ�̳�
		List<Video> videos = VideoServer.findVideoByClassIdLast(4, 9);
		if(videos!=null){
			for(Video video : videos){
				//�Ƿ�Ϊ������Ƶ  0Ϊ�����Ƶ��1Ϊ������Ƶ
				int specialId=video.getPecialId();
				int videoType=video.getVideoType();
				video.setCharge(videoType==1);
				Special special = SpecialSer.findSpecialById(specialId);
				video.setSpecial(special!=null);
			}
		}
		return JsonUtil.getTeachVideList(videos);
	}

}
