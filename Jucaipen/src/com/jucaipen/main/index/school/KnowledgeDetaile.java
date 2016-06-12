package com.jucaipen.main.index.school;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Knowledge;
import com.jucaipen.service.KnowledgetSer;
import com.jucaipen.service.ResourceFromServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *
 *   获取知识详细信息
 */
@SuppressWarnings("serial")
public class KnowledgeDetaile extends HttpServlet {
	private String result;      
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String knowId=request.getParameter("knowId");
		String classId=request.getParameter("classId");
		if(StringUtil.isNotNull(knowId)){
			if(StringUtil.isInteger(knowId)){
				int kId=Integer.parseInt(knowId);
				if(StringUtil.isNotNull(classId)&&StringUtil.isInteger(classId)){
					int cId=Integer.parseInt(classId);
					result=initKnowDetails(kId,cId);
				}else{
					result=JsonUtil.getRetMsg(3,"classId 参数异常");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"knowId 参数数字格式化异常");
			}
		}else{
			result=JsonUtil.getRetMsg(1, "knowId 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initKnowDetails(int kId, int cId) {
		//初始化知识详细信息
		Knowledge knowledge=KnowledgetSer.findKnowledgeById(kId);
		if(knowledge!=null){
			//获取来源
			int fromId=knowledge.getFromId();
			String from = ResourceFromServer.getRSources(fromId);
			knowledge.setFrom(from);
			//获取上下篇
			Knowledge lastKnow=KnowledgetSer.findTitleById(kId-1, cId);
			Knowledge nextKnow=KnowledgetSer.findTitleById(kId+1, cId);
			if(lastKnow==null){
				knowledge.setLastId(-1);
				knowledge.setLastTitle("没有上一篇");
			}else{
				knowledge.setLastId(kId-1);
				knowledge.setLastTitle(lastKnow.getTitle());
			}
			if(nextKnow==null){
				knowledge.setNextId(-1);
				knowledge.setNextTitle("没有下一篇");
			}else{
				knowledge.setNextId(kId+1);
				knowledge.setNextTitle(nextKnow.getTitle());
			}
		}
		return JsonUtil.getKnowDetails(knowledge);
	}
}
