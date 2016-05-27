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
import com.jucaipen.model.ResourceSources;
import com.jucaipen.service.NewServer;
import com.jucaipen.service.ResourceFromServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ�����ȵ� isIndex 0 ��ҳ ���ز����� id title from date remark imageThumb
 *         {"id":7214,"title":"","imageThumb":"","comms":0,
 *         "insertDate":"2016-02-19","from":"��Ѷ�ƾ�"} 1 ȫ������ ���ز�����
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
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String isIndex = request.getParameter("isIndex");
			if (StringUtil.isNotNull(isIndex)) {
				if (StringUtil.isInteger(isIndex)) {
					int index = Integer.parseInt(isIndex);
					if (index == 0) {
						// ��ҳ�����ȵ�
						initIndexData();
						result = JsonUtil.getNewsList(news);
					} else {
						// ��ȡ���н����ȵ�
						String page = request.getParameter("page");
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							initAllData(p);
							result = JsonUtil.getNewsList(news);
						} else {
							result = JsonUtil.getRetMsg(3, "page��������");
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
		out.println(result);
		out.flush();
		out.close();
	}

	private void initAllData(int page) {
		// ��ȡȫ�������ȵ���Ϣ
		news = NewServer.findNewsByClassId(1, page);
		for (News n : news) {
			int from = n.getFromId();
			ResourceSources resource = ResourceFromServer.getRSources(from);
			n.setFrom(resource.getFromName());
		}

	}

	private void initIndexData() {
		// ��ȡ��ҳ�����ȵ���Ϣ
		news = NewServer.findLastNews(3);
		for (News n : news) {
			int from = n.getFromId();
			ResourceSources resource = ResourceFromServer.getRSources(from);
			n.setFrom(resource.getFromName());
		}

	}

}
