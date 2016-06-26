package com.jucaipen.main.live;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Guardian;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 *
 *  获取活跃榜    ---讲师守护者
 */
@SuppressWarnings("serial")
public class ActiveList extends HttpServlet {
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
				result=initActiveList(lId);
			}else{
				result=JsonUtil.getRetMsg(2,"liveId 参数数字格式化异常");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"liveId 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}
	private String initActiveList(int lId) {
		//初始化活跃信息
		VideoLive live=VideoLiveServer.getRoomInfo(lId);
		int teacherId=live.getTeacherId();
		List<Guardian> guardianArray=new ArrayList<Guardian>();
		List<Guardian> guardians = GuardianSer.findGuradianByTeacherId(teacherId);
		for(Guardian guardian : guardians){
			String endDate=guardian.getEndDate();
			if(TimeUtils.isDateBefore(endDate)){
				int uId=guardian.getUserId();
				User user=UserServer.findUserById(uId);
				if(user==null){
					user=new User();
				}
				guardian.setUserName(user.getNickName());
				guardianArray.add(guardian);
			}
		}
		return JsonUtil.getGuardianList(guardianArray);
	}

}
