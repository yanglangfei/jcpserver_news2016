package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 *         获取今日热点 isIndex 0 首页    返回参数： id  title from date remark imageThumb
 *                                       {"id":7214,"title":"","imageThumb":"","comms":0,
 *                                       "insertDate":"2016-02-19","from":"腾讯财经"}
 *                           1 全部数据 返回参数： 
 *                           
 */
@SuppressWarnings("serial")
public class HotNews extends HttpServlet {
	private String result;
	private List<News> news;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String isIndex = request.getParameter("isIndex");
		if (StringUtil.isNotNull(isIndex)) {
			if (StringUtil.isInteger(isIndex)) {
               int index=Integer.parseInt(isIndex);
               if(index==0){
            	   //首页今日热点
            	   initIndexData();
            	   result=JsonUtil.getNewsList(news);
               }else{
            	   //获取所有今日热点
            	   String page=request.getParameter("page");
            	   if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
            		   int p=Integer.parseInt(page);
                	   initAllData(p);
                	   result=JsonUtil.getNewsList(news);
            	   }else{
            		   result=JsonUtil.getRetMsg(3,"page参数有误");
            	   }
               }
			} else {
				result = JsonUtil.getRetMsg(2, "isIndex参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "isIndex参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private void initAllData(int page) {
		// 获取全部今日热点信息
		news=NewServer.findNewsByClassId(1, page);
		for(News n :news){
			int from=n.getFromId();
			ResourceSources resource=ResourceFromServer.getRSources(from);
			n.setFrom(resource.getFromName());
		}
		
	}
	private void initIndexData() {
		// 获取首页今日热点信息
		news=NewServer.findLastNews(3);
		for(News n : news){
			int from=n.getFromId();
			ResourceSources resource = ResourceFromServer.getRSources(from);
			n.setFrom(resource.getFromName());
		}
		
	}

}
