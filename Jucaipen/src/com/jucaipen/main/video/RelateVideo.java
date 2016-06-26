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
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *   获取相关视频   推荐视频   选集
 */
@SuppressWarnings("serial")
public class RelateVideo extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId=request.getParameter("typeId");
		String classId=request.getParameter("classId");
		if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
			int type=Integer.parseInt(typeId);
			if(StringUtil.isNotNull(classId)&&StringUtil.isInteger(classId)){
				int cId=Integer.parseInt(classId);
				result=initVideoList(cId,type);
			}else{
				result=JsonUtil.getRetMsg(2,"classId 参数异常");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"typeId 参数异常");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initVideoList(int cId, int type) {
		List<Video> videos;
		if(type==0){
			//选集
		    videos = VideoServer.findVideoByClassIdLast(6, cId);
		}else{
			//推荐视频
			videos = VideoServer.findVideoByClassId(cId);
		}
		return JsonUtil.getVideoList(videos);
	}

}
