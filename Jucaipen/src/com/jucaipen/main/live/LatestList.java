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
 *   获取最新榜单信息   type     0     日榜单         1   月榜单
 */
@SuppressWarnings("serial")
public class LatestList extends HttpServlet {
	private String result;
	private int currentId;
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
		    	result=JsonUtil.getRetMsg(1, "type 参数不能为空");
		    }else{
		    	if(StringUtil.isInteger(type)){
		    		int t=Integer.parseInt(type);
		    		if(StringUtil.isNotNull(liveId)&&StringUtil.isInteger(liveId)){
		    			int lId=Integer.parseInt(liveId);
		    			result=initlist(t,lId);
		    		}else{
		    			result=JsonUtil.getRetMsg(3,"liveId 参数异常");
		    		}
		    	}else{
		    		result=JsonUtil.getRetMsg(2,"type 参数数字格式化异常");
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
		//初始化榜单信息  
		List<Rebate> rebateArray=new ArrayList<Rebate>();
		VideoLive live=VideoLiveServer.getRoomInfo(lId);
		System.out.println(lId);
		int tId=live.getTeacherId();
		List<Rebate> rebates = RebateSer.findRebateByTid(tId);
		if(t==0){
			//日榜单
			for(Rebate rebate : rebates){
				int userId=rebate.getFromId();
				String insertDate=rebate.getInsertDate();
				if(TimeUtils.isToday(insertDate)){
					if(userId==currentId){
						continue ;
					}
					int bills=RebateSer.contributeBills(userId, tId);
					User user=UserServer.findUserById(userId);
					rebate.setFromName(user.getNickName());
     				rebate.setFromFace(user.getFaceImage());
     				rebate.setAllBills(bills);
     				rebateArray.add(rebate);
				}
				
			}
			
			//rebateArray=filterRebates(rebateArray);
			return JsonUtil.getLateList(rebateArray);
		}else{
			//月榜单
			for(Rebate rebate : rebates){
				int userId=rebate.getFromId();
				String insertDate=rebate.getInsertDate();
				if(TimeUtils.isMoth(insertDate)){
					if(userId==currentId){
						continue ;
					}
					int bills=RebateSer.contributeBills(userId, tId);
					currentId=userId;
					User user=UserServer.findUserById(userId);
					rebate.setFromName(user.getNickName());
     				rebate.setFromFace(user.getFaceImage());
     				rebate.setAllBills(bills);
     				rebateArray.add(rebate);
				}
			}
			//rebateArray=filterRebates(rebateArray);
			return JsonUtil.getLateList(rebateArray);
		}
		
	}
	
	
	public List<Rebate> filterRebates(List<Rebate> array){
		//V:zhang V:zr V:脸子 V:zr V:zhang
		for(int i=0;i<array.size();i++){
			int id=array.get(i).getFromId();
			for(int j=0;j<array.size();j++){
				int fId=array.get(j).getFromId();
				if(id==fId){
					array.remove(i);
				}
			}
		}
		return array;
	}

}
