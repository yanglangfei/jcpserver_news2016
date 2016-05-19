package com.jucaipen.main.vide;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.TextLive;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *    直播      liveType    0  文字直播  返回参数： id image title joinNums isAttention
 *                        
 *                      1  视频直播  返回参数：id image title joinNums isLive
 *                      
 */
@SuppressWarnings("serial")
public class LiveList extends HttpServlet {

	private String result;
	private List<TextLive> txtLives;
	private List<FamousTeacher> teachers=new ArrayList<FamousTeacher>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String liveType=request.getParameter("liveType");
		String page=request.getParameter("page");
		if(StringUtil.isNotNull(liveType)){
			if(StringUtil.isInteger(liveType)){
				int type=Integer.parseInt(liveType);
				if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
					int p=Integer.parseInt(page);
					if(type==0){
						//文字直播
						initTxtLive(p);
						result=JsonUtil.getTxtLiveList(txtLives,teachers);
					}else{
						//视频直播
						initLive(p);
					}
				}else{
					result=JsonUtil.getRetMsg(3,"page 参数异常");
				}
				
			}else{
				result=JsonUtil.getRetMsg(2,"liveType 参数数字格式异常");
			}
			
		}else{
			result=JsonUtil.getRetMsg(1,"liveType 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private void initLive(int page) {
		//初始化视频直播
		
		
	}

	private void initTxtLive(int page) {
		//初始化文字直播
		teachers.clear();
		txtLives=TxtLiveSer.findAllTextLive(page);
		for(TextLive txt : txtLives){
			int tId=txt.getTeacherId();
			FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(tId);
			if(teacher==null){
				teacher=new FamousTeacher();
			}
			teachers.add(teacher);
		}
	}

}
