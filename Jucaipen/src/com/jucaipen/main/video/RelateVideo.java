package com.jucaipen.main.video;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Special;
import com.jucaipen.model.Video;
import com.jucaipen.service.SpecialSer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *   获取(相关视频    typeId    0  
 *        选集    typeId    1
 *        推荐视频   typeId  2
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
		String isIndex=request.getParameter("isIndex");
		String typeId=request.getParameter("typeId");
		String classId=request.getParameter("classId");
		if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
			int type=Integer.parseInt(typeId);
			if(StringUtil.isNotNull(classId)&&StringUtil.isInteger(classId)){
				int cId=Integer.parseInt(classId);
				if(StringUtil.isNotNull(isIndex)&&StringUtil.isInteger(isIndex)){
					int index=Integer.parseInt(isIndex);
					result=initVideoList(cId,type,index);
				}else{
					result=JsonUtil.getRetMsg(3,"isIndex 参数异常");
				}
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

	private String initVideoList(int cId, int type, int index) {
		List<Video> videos;
		if(type==0){
			//相关视频        ----classId       isTop
			videos=VideoServer.findVideoByIsTopId(1, cId);
		}else if(type==1){
			//选集               -----specialId
			videos=VideoServer.findVideoBySpecialId(cId);
		}else{
			//推荐视频     --------classId     isTuijian
			videos=VideoServer.findVideoByIsRecommId(1, cId);
		}
		
		/*if(index==0){
			//首页
			 videos = VideoServer.findVideoByClassIdLast(6, cId);
		}else{
			 videos = VideoServer.findVideoByClassId(cId);
		}*/
		
		if(videos!=null){
			for(Video video : videos){
				//是否为付费视频  0为免费视频，1为付费视频
				int specialId=video.getPecialId();
				int videoType=video.getVideoType();
				video.setCharge(videoType==1);
				Special special = SpecialSer.findSpecialById(specialId);
				video.setSpecial(special!=null);
			}
			
		}
		return JsonUtil.getVideoList(videos);
	}
}
