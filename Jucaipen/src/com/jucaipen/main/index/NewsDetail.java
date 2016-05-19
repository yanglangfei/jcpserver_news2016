package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.News;
import com.jucaipen.model.ResourceSources;
import com.jucaipen.service.NewServer;
import com.jucaipen.service.ResourceFromServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *   获取新闻详细信息
 */
@SuppressWarnings("serial")
public class NewsDetail extends HttpServlet {

	private String result;
	private News news;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    String newsId=request.getParameter("newsId");
	    if(StringUtil.isNotNull(newsId)){
	    	if(StringUtil.isInteger(newsId)){
	    		int id=Integer.parseInt(newsId);
	    		initNewsDetail(id);
	    		result=JsonUtil.getObject(news);
	    	}else{
	    		result=JsonUtil.getRetMsg(1, "newsId 参数数字格式化异常");
	    	}
	    }else{
	    	result=JsonUtil.getRetMsg(2,"newsId 参数不能为空");
	    }
		
		out.println(result);
		out.flush();
		out.close();
	}

	private void initNewsDetail(int id) {
		//初始化新闻详细信息
		news = NewServer.findNewsById(id);
		if(news!=null){
			int fromId=news.getFromId();
			ResourceSources source = ResourceFromServer.getRSources(fromId);
			if(source!=null){
				news.setFrom(source.getFromName());
			}
		}
		
		
	}

}
