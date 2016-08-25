package com.jucaipen.main.news;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.JcpNews;
import com.jucaipen.service.JcpNewsSer;
import com.jucaipen.service.ResourceFromServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         ���ݷ����ȡ��Ѷ��Ϣ
 */
@SuppressWarnings("serial")
public class NewsByType extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String page = request.getParameter("page");
		String smallType = request.getParameter("smallId");
		if (StringUtil.isNotNull(smallType) && StringUtil.isInteger(smallType)) {
			int small = Integer.parseInt(smallType);
			if (StringUtil.isNotNull(page) && StringUtil.isInteger(page)) {
				int p = Integer.parseInt(page);
				result = getNewsByType(small, p);
			} else {
				result = JsonUtil.getRetMsg(2, "page �����쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "smallId �����쳣");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String getNewsByType(int small, int page) {
		List<JcpNews> news;
		if(small==0){
			//��ȡ�Ƽ���Ѷ��Ϣ
			news = JcpNewsSer.findAll(page);
		}else{
			//���ݷ����ȡ��Ѷ��Ϣ
			 news = JcpNewsSer.findNewsBybigId(2, small, page);
		}
		if(news!=null){
			for (JcpNews n : news) {
				int fromId = n.getComeFrom();
				String from = ResourceFromServer.getRSources(fromId);
				n.setFrom(from);
			}
		}
		return JsonUtil.getNewsList(news);
	}

}
