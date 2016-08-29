package com.jucaipen.main.video;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 *         ��ȡ��Ƶ�б� isIndex 0 ��ҳ�Ƽ���Ƶ ���ز�����id title desc image
 *         {"id":94,"title":"111","imageUrl":"","comms":0,"hits":5,"desc":"1"} 1
 *         ȫ��
 */
public class VideoList extends HttpServlet {
	private static final long serialVersionUID = 1572364249873336315L;
	private String result;
	private int isPurch;
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
			String isIndex = request.getParameter("isIndex");
			String userId=request.getParameter("userId");
			if (StringUtil.isNotNull(isIndex)) {
				if (StringUtil.isInteger(isIndex)) {
					int index = Integer.parseInt(isIndex);
					if (index == 0) {
						// ��ҳ�Ƽ���Ƶ
						result = initIndexData(userId);
					} else {
						// ȫ����Ƶ
						String page = request.getParameter("page");
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							result = initAllData(p,userId);
						} else {
							result = JsonUtil.getRetMsg(2, "page�����쳣");
						}
					}
				} else {
					result = JsonUtil.getRetMsg(2, "isIndex�������ָ�ʽ���쳣");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "isIndex��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initAllData(int p,String userId) {
		int uId=0;
		//�Ƿ���    0  �й���     1    δ����      2  �ѹ���
		if(!StringUtil.isNotNull(userId)||!StringUtil.isInteger(userId)){
			isPurch = 1;
		}else{
			uId=Integer.parseInt(userId);
			if(uId<=0){
				isPurch=1;
			}
		}
		
		
		
		List<Video> videos = VideoServer.findAll(p);
		for (Video video : videos) {
		   createVideo(video, uId);
		}
		return JsonUtil.getVideoList(videos);
	}

	private String initIndexData(String userId) {
		// ��ʼ����ҳ����     ��ҳ +�Ƽ�
		int uId=0;
		//�Ƿ���    0  �й���     1    δ����      2  �ѹ���
		if(!StringUtil.isNotNull(userId)||!StringUtil.isInteger(userId)){
			isPurch = 1;
		}else{
			uId=Integer.parseInt(userId);
			if(uId<=0){
				isPurch=1;
			}
		}
		List<Video> videos = VideoServer.findVideoByLast(4);
		if (videos != null) {
			for (Video video : videos) {
				createVideo(video, uId);
			}
		}
		return JsonUtil.getVideoList(videos);
	}
	
	public void createVideo(Video video,int uId){
		int specialId = video.getPecialId();
		int videoType = video.getVideoType();
		video.setCharge(videoType == 1);
		if (specialId > 0) {
			Special special = SpecialSer.findSpecialById(specialId);
			video.setCharge(special.getIsFree() == 2);
		}
		
		//0  �й���     1    δ����      2  �ѹ���
				if(uId>0&&specialId>0){
					MySpecial mySpecial=MySpecialSer.getIsMySpecial(uId, specialId);
					if(mySpecial!=null){
						if(TimeUtils.isLive(mySpecial.getStartDate(), mySpecial.getEndDate())){
							isPurch=0;
						}else{
							isPurch=2;
						}
					}else{
						isPurch=1;
					}
				}
				
				if(uId>0&&specialId<=0){
					MyVideo myVideo=MyVideoSer.findIsMyVideo(uId, video.getId());
					if(myVideo!=null){
						if(TimeUtils.isLive(myVideo.getStartDate(), myVideo.getEndDate())){
							isPurch=0;
						}else{
							isPurch=2;
						}
					}else{
						isPurch=1;
					}
				}
				
				video.setIsPurch(isPurch);
		
	}

}
