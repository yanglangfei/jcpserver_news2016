package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取评论信息 commType 评论类型 0 新闻评论 1 视频评论 2 观点评论
 */
@SuppressWarnings("serial")
public class QuerryComments extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String commType = request.getParameter("commType");
		String id = request.getParameter("id");
		String page = request.getParameter("page");
		if (StringUtil.isNotNull(commType)) {
			if (StringUtil.isInteger(commType)) {
				int type = Integer.parseInt(commType);
				if (StringUtil.isNotNull(id) && StringUtil.isInteger(id)) {
					int index = Integer.parseInt(id);
					if (StringUtil.isNotNull(page)
							&& StringUtil.isInteger(page)) {
						int p = Integer.parseInt(page);
						if (type == 0) {
							// 新闻评论
							initNewsComms(index, p);
							//result=JsonUtil.getNewsCommList(nComments, users);
						} else if (type == 1) {
							// 视频评论
							initVideoComments(index, p);
							//result=JsonUtil.getNewsCommList(nComments, users);
						} else {
							// 观点评论
							initIdeaComments(index, p);
							//result = JsonUtil.getIdeaCommList(logComms, users);
						}
					} else {
						result = JsonUtil.getRetMsg(4, "page 参数异常");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "id 参数异常");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "commType 参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "commType 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private void initIdeaComments(int index, int page) {
		// 初始化观点评论
		

	}

	private void initVideoComments(int index, int page) {
		// 初始化视频评论数据
		

	}

	private void initNewsComms(int index, int page) {
		// 初始化新闻评论
		

	}

}
