package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.News;
import com.jucaipen.model.SiteConfig;
import com.jucaipen.model.TacticsDetails;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.NewServer;
import com.jucaipen.service.ResourceFromServer;
import com.jucaipen.service.SiteConfigSer;
import com.jucaipen.service.TacticsDetailSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取新闻详细信息       type    (0  新闻详细信息)    （1   观点详细信息）  (2  战法详细信息)
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
			String page=request.getParameter("page");
			if (StringUtil.isNotNull(newsId)) {
				if (StringUtil.isInteger(newsId)) {
					int id = Integer.parseInt(newsId);
					if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
						int type=Integer.parseInt(typeId);
						result=initNewsDetail(id,type,page);
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

	private String initNewsDetail(int id, int type, String page) {
		// 初始化新闻详细信息
		if(type==0){
			//新闻详细信息
			News news = NewServer.findNewsById(id);
			int fromId=news.getFromId();
			String from=ResourceFromServer.getRSources(fromId);
			news.setFrom(from);
			return JsonUtil.getNewsDetails(news);
		}else if(type==1){
			//观点详细信息
			HotIdea idea = HotIdeaServ.findIdeaById(id);
			int tId=idea.getTeacherId();
			FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(tId);
			if(teacher==null){
				teacher=new FamousTeacher();
			}
			initIdeaHits(tId,id,idea.getHits(),idea.getXnHits(),teacher.getArticleReadCount(),teacher.getXnArticleReadNum());
			return JsonUtil.getIdeaDetails(idea,teacher);
		}else{
			if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
				int p=Integer.parseInt(page);
				List<TacticsDetails> detailsArray=TacticsDetailSer.findDetailsByFkId(id,p);
				return JsonUtil.getTacticsDetailInfo(detailsArray);
			}else{
				return JsonUtil.getRetMsg(7,"page 参数异常");
			}
		}
		
	}

	/**
	 * @param id
	 *   更新观点点击数
	 * @param hits 
	 */
	private void initIdeaHits(int tId,int id, int hits,int xnHits,int ideaReadNum,int xnIdeaReadNum) {
		SiteConfig config = SiteConfigSer.findSiteConfig();
		HotIdeaServ.addHit(id, hits+1,xnHits+config.getNewsMom());
		FamousTeacherSer.updateIdeaReadNum(tId,ideaReadNum+1, xnIdeaReadNum+config.getNewsMom());
	}

}
