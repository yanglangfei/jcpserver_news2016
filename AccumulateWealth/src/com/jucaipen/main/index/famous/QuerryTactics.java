package com.jucaipen.main.index.famous;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Tactics;
import com.jucaipen.model.TacticsSale;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.TacticsSaleSer;
import com.jucaipen.service.TacticsSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;
/**
 * @author Administrator
 *  ��ȡս���б���Ϣ
 */
@SuppressWarnings("serial")
public class QuerryTactics extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String teacherId=request.getParameter("teacherId");
		String userId=request.getParameter("userId");
		String page=request.getParameter("page");
		if(StringUtil.isNotNull(teacherId)){
			if(StringUtil.isInteger(teacherId)){
				int tId=Integer.parseInt(teacherId);
				if(StringUtil.isNotNull(userId)&&StringUtil.isInteger(userId)){
					int uId=Integer.parseInt(userId);
					if(StringUtil.isNotNull(page)&&StringUtil.isNotNull(page)){
						int p=Integer.parseInt(page);
						result=initTacticsList(tId,uId,p);
					}else{
						result=JsonUtil.getRetMsg(2, "page �����쳣");
					}
				}else{
					result=JsonUtil.getRetMsg(2, "userId ��������Ϊ��");
				}
			}else{
				result=JsonUtil.getRetMsg(2, "teacherId �������ָ�ʽ���쳣");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"teacherId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}
	private String initTacticsList(int tId, int uId, int p) {
		//��ʼ��ս����Ϣ
		List<Tactics> tactics=TacticsSer.findTacticsByTeacherId(tId, p);
		FamousTeacher teacher=FamousTeacherSer.findTeacherBaseInfo(tId);
		for(Tactics tac : tactics){
			TacticsSale sale=TacticsSaleSer.findTacticsIsSale(uId, tac.getId());
		    // 0     ������        1  δ����        2  ����
			if(sale!=null){
		    	if(TimeUtils.isLive(sale.getStartDate(), sale.getEndDate())){
		    		tac.setIsOrder(0);
		    	}else{
		    		tac.setIsOrder(2);
		    	}
		    }else{
		    	tac.setIsOrder(1);
		    }
		}
		return JsonUtil.getTecticsList(tactics,teacher);
	}
}
