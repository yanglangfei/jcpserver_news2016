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
 *         获取学院视频教程列表
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
			String page=request.getParameter("page");
			if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
				int p=Integer.parseInt(page);
				result=initTeachList(p);
			}else{
				result=JsonUtil.getRetMsg(1,"page 参数异常");
			}
			
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}
	
	private String initTeachList(int p) {
		// 初始化视频教程
		List<Video> videos=VideoServer.findVideoByClassIdLast(4, 9);
		//List<Video> videos = VideoServer.findVideoByClassId(9+"", p);
		if(videos!=null){
			for(Video video : videos){
				//是否为付费视频  0为免费视频，1为付费视频
				int specialId=video.getPecialId();
				int videoType=video.getVideoType();
				video.setCharge(videoType==1);
				
				if(specialId>0){
					Special special = SpecialSer.findSpecialById(specialId);
					video.setCharge(special.getIsFree()==2);
				}
			}
		}
		return JsonUtil.getTeachVideList(videos);
	}

}
