package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.News;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.NewServer;
import com.jucaipen.service.ResourceFromServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取新闻详细信息       type    (0   新闻详细信息)    （1   观点详细信息）
 */
@SuppressWarnings("serial")
public class NewsDetail extends HttpServlet {
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
			String typeId=request.getParameter("typeId");
			String newsId = request.getParameter("newsId");
			if (StringUtil.isNotNull(newsId)) {
				if (StringUtil.isInteger(newsId)) {
					int id = Integer.parseInt(newsId);
					if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
						int type=Integer.parseInt(typeId);
						result=initNewsDetail(id,type);
					}else{
						result=JsonUtil.getRetMsg(3,"typeId 参数异常");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "newsId 参数数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "newsId 参数不能为空");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initNewsDetail(int id, int type) {
		// 初始化新闻详细信息
		News news;
		HotIdea idea;
		if(type==0){
			//新闻详细信息
			news=NewServer.findNewsById(id);
			int fromId=news.getFromId();
			String from=ResourceFromServer.getRSources(fromId);
			news.setFrom(from);
			return JsonUtil.getNewsDetails(news);
		}else {
			//观点详细信息
			idea=HotIdeaServ.findIdeaById(id);
			int tId=idea.getTeacherId();
			FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(tId);
			if(teacher==null){
				teacher=new FamousTeacher();
			}
			return JsonUtil.getIdeaDetails(idea,teacher);
		}
		
	}

}
