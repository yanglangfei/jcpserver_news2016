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
 *   ��ȡ(�����Ƶ    typeId    0  
 *        ѡ��    typeId    1
 *        �Ƽ���Ƶ   typeId  2
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
					result=JsonUtil.getRetMsg(3,"isIndex �����쳣");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"classId �����쳣");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"typeId �����쳣");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initVideoList(int cId, int type, int index) {
		List<Video> videos;
		if(type==0){
			//�����Ƶ        ----classId  
			videos=VideoServer.findVideoByClassIdLast(4, cId);
		}else if(type==1){
			//ѡ��               -----specialId
			videos=VideoServer.findVideoBySpecialId(cId);
		}else{
			//�Ƽ���Ƶ     -------- isJingXuan
			videos=VideoServer.findVideoByIsBestLast(4, 1);
		}
		if(videos!=null){
			for(Video video : videos){
				//�Ƿ�Ϊ������Ƶ  0Ϊ�����Ƶ��1Ϊ������Ƶ
				int specialId=video.getPecialId();
				int videoType=video.getVideoType();
				video.setCharge(videoType==1);
				if(specialId>0){
					Special special = SpecialSer.findSpecialById(specialId);
					video.setCharge(special.getIsFree()==2);
				}
			}
		}
		return JsonUtil.getVideoList(videos);
	}
}
