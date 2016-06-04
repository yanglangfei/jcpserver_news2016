package com.jucaipen.main.live;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.Marker;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.MarkerSer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *   获取最新榜单信息   type     0     日榜单         1   月榜单
 */
@SuppressWarnings("serial")
public class LatestList extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext sc=getServletContext();
		sc.setAttribute("name", "张三");
		String userAgent=request.getParameter("User-Agent");
		ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);
		int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			String type=request.getParameter("type");
			String liveId=request.getParameter("liveId");
		    if(!StringUtil.isNotNull(type)){
		    	result=JsonUtil.getRetMsg(1, "type 参数不能为空");
		    }else{
		    	if(StringUtil.isInteger(type)){
		    		int t=Integer.parseInt(type);
		    		if(StringUtil.isNotNull(liveId)&&StringUtil.isInteger(liveId)){
		    			int lId=Integer.parseInt(liveId);
		    			result=initlist(t,lId);
		    		}else{
		    			result=JsonUtil.getRetMsg(3,"liveId 参数异常");
		    		}
		    	}else{
		    		result=JsonUtil.getRetMsg(2,"type 参数数字格式化异常");
		    	}
		    }
		}else{
			result=StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	public String initlist(int t, int lId) {
		//初始化榜单信息  
		int mc = 0;
		VideoLive vl=VideoLiveServer.getRoomInfo(lId);
		int tId=vl.getTeacherId();
		if(t==0){
			//日榜单
			//打赏讲师聚财币
			//List<Marker> markers = MarkerSer.findMarkerByTeacherId(tId, 1);
			
			List<Marker> markers=MarkerSer.findAll();
			for(Marker marker : markers){
				int type=marker.getType();
				int fkId=marker.getIdeaId();
				int userId=marker.getUserId();
				HotIdea idea = HotIdeaServ.findIdeaById(tId);
				int teaId=idea.getTeacherId();
				if((type==1&&fkId==tId)||(type==2&&teaId==tId)){
					//打赏讲师日志
					mc+=marker.getMarkerCount();
				}
				
			}
			
		}else{
			//月榜单
		}
		return null;
		
		
	}

}
