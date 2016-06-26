package com.jucaipen.main.play;

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
 *  获取往期演播信息
 */
@SuppressWarnings("serial")
public class LastPlay extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String studioId=request.getParameter("studioId");
		String isMore=request.getParameter("isMore");
		if(StringUtil.isNotNull(studioId)&&StringUtil.isInteger(studioId)){
			int sId=Integer.parseInt(studioId);
			if(StringUtil.isNotNull(isMore)&&StringUtil.isInteger(isMore)){
				int more=Integer.parseInt(isMore);
				result=initLastPlayList(more,sId,request);
			}else{
				result=JsonUtil.getRetMsg(2, "isMore 参数异常");
			}
		}else{
			result=JsonUtil.getRetMsg(1, "studioId 参数异常");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initLastPlayList(int isMore, int sId,HttpServletRequest req) {
		if(isMore==0){
			List<Video> videos = VideoServer.findLastVideoByCommId(sId, 3);
			for(Video v : videos){
				Special special=SpecialSer.findSpecialById(v.getPecialId());
			    v.setSpecial(special!=null);
			}
			return JsonUtil.getLastPlayList(videos);
		}else{
			String page=req.getParameter("page");
			if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
				int p=Integer.parseInt(page);
				List<Video> videos=VideoServer.findAllVideoByCommId(sId, p);
				for(Video v : videos){
					Special special=SpecialSer.findSpecialById(v.getPecialId());
				    v.setSpecial(special!=null);
				}
				return JsonUtil.getLastPlayList(videos);
			}else{
				return JsonUtil.getRetMsg(1, "page 参数异常");
			}
			
		}
		
	}

}
