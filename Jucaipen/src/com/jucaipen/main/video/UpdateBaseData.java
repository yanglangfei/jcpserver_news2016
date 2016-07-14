package com.jucaipen.main.video;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Video;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *
 *   更新点击数    点赞数
 */
@SuppressWarnings("serial")
public class UpdateBaseData extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId=request.getParameter("typeId");
		String fkId=request.getParameter("fkId");
		if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
			int type=Integer.parseInt(typeId);
			if(StringUtil.isNotNull(fkId)&&StringUtil.isInteger(fkId)){
				int fId=Integer.parseInt(fkId);
				initHits(type,fId);
			}
		}
		out.flush();
		out.close();
	}

	private void initHits(int type, int fkId) {
		if(type==0){
			//视频
			Video vide=VideoServer.findVideoResourceById(fkId);
			VideoServer.updateHits(vide.getHitCount()+1, vide.getXnHitCount()+1, fkId);
		}
		
	}

}
