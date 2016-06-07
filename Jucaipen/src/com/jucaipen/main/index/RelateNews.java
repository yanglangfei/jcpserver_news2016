package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.News;
import com.jucaipen.service.NewServer;
import com.jucaipen.service.ResourceFromServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取相关新闻 返回参数: id title from remarks insertDate image
 * 
 */
@SuppressWarnings("serial")
public class RelateNews extends HttpServlet {
	private String result;
	private List<News> news;

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
			String newsId = request.getParameter("id");
			if (StringUtil.isInteger(newsId)) {
				int id = Integer.parseInt(newsId);
				initReleData(id);
				if (news != null) {
					result = JsonUtil.getIndxKnownList(news);
				} else {
					result = JsonUtil.getRetMsg(0, "数据异常");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "新闻id参数数字格式化异常");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initReleData(int id) {
		// 初始化数据
		news = NewServer.findLastNews(3);
		if (news != null) {
			for (News n : news) {
				int fromId = n.getFromId();
				String from = ResourceFromServer.getRSources(fromId);
				n.setFrom(from);
			}
		}

	}

}
