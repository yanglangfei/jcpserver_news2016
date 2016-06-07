package com.jucaipen.main.live;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.RebateSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 *
 *   ��ȡ���°���Ϣ   type     0     �հ�         1   �°�
 */
@SuppressWarnings("serial")
public class LatestList extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent=request.getParameter("User-Agent");
		ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);
		int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			String type=request.getParameter("type");
			String liveId=request.getParameter("liveId");
		    if(!StringUtil.isNotNull(type)){
		    	result=JsonUtil.getRetMsg(1, "type ��������Ϊ��");
		    }else{
		    	if(StringUtil.isInteger(type)){
		    		int t=Integer.parseInt(type);
		    		if(StringUtil.isNotNull(liveId)&&StringUtil.isInteger(liveId)){
		    			int lId=Integer.parseInt(liveId);
		    			result=initlist(t,lId);
		    		}else{
		    			result=JsonUtil.getRetMsg(3,"liveId �����쳣");
		    		}
		    	}else{
		    		result=JsonUtil.getRetMsg(2,"type �������ָ�ʽ���쳣");
		    	}
		    }
		}else{
			result=StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	public String initlist(int t, int lId) {
		//��ʼ������Ϣ  
		List<Rebate> rebateArray=new ArrayList<Rebate>();
		VideoLive live=VideoLiveServer.getRoomInfo(lId);
		int tId=live.getTeacherId();
		List<Rebate> rebates = RebateSer.findRebateByTid(tId);
		if(t==0){
			//�հ�
			for(Rebate rebate : rebates){
				String insertDate=rebate.getInsertDate();
				if(TimeUtils.isToday(insertDate)){
					int fromId=rebate.getFromId();
					User user=UserServer.findUserById(fromId);
					rebate.setFromName(user.getNickName());
					rebateArray.add(rebate);
				}
			}
			return JsonUtil.getLateList(rebateArray);
		}else{
			//�°�
			for(Rebate rebate : rebates){
				String insertDate=rebate.getInsertDate();
				if(TimeUtils.isMoth(insertDate)){
					int fromId=rebate.getFromId();
					User user=UserServer.findUserById(fromId);
					rebate.setFromName(user.getNickName());
					rebateArray.add(rebate);
				}
				
			}
			return JsonUtil.getLateList(rebateArray);
		}
		
	}

}
