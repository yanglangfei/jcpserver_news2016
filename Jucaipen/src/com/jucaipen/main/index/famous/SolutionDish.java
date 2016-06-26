package com.jucaipen.main.index.famous;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.TxtLiveDetails;
import com.jucaipen.service.TxtLiveDetaileSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 浏览解盘
 */
@SuppressWarnings("serial")
public class SolutionDish extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String liveId=request.getParameter("liveId");
		if(StringUtil.isNotNull(liveId)){
			if(StringUtil.isInteger(liveId)){
				int lId=Integer.parseInt(liveId);
				result=initDishInfo(lId);
			}else{
				result=JsonUtil.getRetMsg(1,"liveId 参数数字格式化异常");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"liveId 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initDishInfo(int liveId) {
		List<TxtLiveDetails> details = TxtLiveDetaileSer.findTextDetaileByLiveId(liveId, 1);
		return JsonUtil.getSoultionDishList(details);
	}

}
