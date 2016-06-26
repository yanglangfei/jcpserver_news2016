package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Gifts;
import com.jucaipen.model.MyGifts;
import com.jucaipen.model.MyPresent;
import com.jucaipen.service.GiftsSer;
import com.jucaipen.service.MyGiftsSer;
import com.jucaipen.service.MyPresentSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 *
 *  赠送礼品
 */
@SuppressWarnings("serial")
public class SendPresent extends HttpServlet {
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		String teacherId=request.getParameter("teacherId");
		String parentId=request.getParameter("parentId");
		String sendNum=request.getParameter("sendNum");
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					if(StringUtil.isNotNull(teacherId)&&StringUtil.isInteger(teacherId)){
						int tId=Integer.parseInt(teacherId);
						if(StringUtil.isNotNull(parentId)&&StringUtil.isInteger(parentId)){
							int pId=Integer.parseInt(parentId);
							if(StringUtil.isNotNull(sendNum)&&StringUtil.isInteger(sendNum)){
								int num=Integer.parseInt(sendNum);
								result=sendTeacherParents(tId,uId,pId,num);
							}else{
								result=JsonUtil.getRetMsg(6,"sendNum 参数异常");
							}
						}else{
							result=JsonUtil.getRetMsg(5,"parentId 参数异常");
						}
					}else{
						result=JsonUtil.getRetMsg(4,"teacherId 参数异常");
					}
				}else{
					result=JsonUtil.getRetMsg(3,"用户还没登录");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"userId 参数数字格式化异常");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"userId 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}
	private String sendTeacherParents(int tId, int uId, int pId, int num) {
		//送礼品信息
		//1、检测礼品数量是否足够
		MyPresent present=MyPresentSer.findParentByUid(uId, pId);
		int count=present.getPresentNum();
		int id=present.getId();
		if(count<num){
			return JsonUtil.getRetMsg(1,"您的礼品数量不足");
		}
		
		//赠送礼品
		//1、更新礼品记录表 
		Gifts g=GiftsSer.findGiftById(pId);
		
		MyPresentSer.sendPresent(id, count-num);
		
		MyGifts gifts=new MyGifts();
		gifts.setGiftNum(num);
		gifts.setGiftId(pId);
		gifts.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		gifts.setReceiverId(tId);
		gifts.setSenderId(uId);
		gifts.setRemark("赠送【"+g.getTitle()+"】礼品【"+num+"】个，背包用去【"+num+"】");
		MyGiftsSer.addGifts(gifts);
		
		//2、返利数据更新
		//账户总表积分数据更新
		
		
		//用户表积分数据更新
		
		
		
		
		return null;
	}

}
