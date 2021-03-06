package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Account;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Gifts;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.GiftsSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         获取商店礼品信息   0  全部        10  推荐   20   视频
 */
@SuppressWarnings("serial")
public class GiftShop extends HttpServlet {
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
			String userId = request.getParameter("userId");
			String type = request.getParameter("type");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
							if (StringUtil.isNotNull(type)&&StringUtil.isInteger(type)) {
									// 根据分类获取礼品信息
									int t = Integer.parseInt(type);
									result = initGiftByClassId(t,uId);
							} else {
								// 获取所有礼品信息
								result = JsonUtil
										.getRetMsg(4, "type 参数异常");
							}
					} else {
						result = JsonUtil.getRetMsg(3, "该用户没登录");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "userId 参数数字格式化异常");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "userId 参数不能为空");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initGiftByClassId(int t, int uId) {
		//根据分类获取礼品信息
		int ownJucaiBills;
		Account account=AccountSer.findAccountByUserId(uId);
		if(account!=null){
			ownJucaiBills=account.getJucaiBills();
		}else{
			ownJucaiBills=0;
		}
		List<Gifts> gifts;
		if(t==10){
			//按推荐查询
			 gifts=GiftsSer.findIsTuijian(1);
		}else if(t==0){
			//所有礼品
			 gifts = GiftsSer.findAllGifts();
		}else if(t==20){
			  //视频直播
			gifts=GiftsSer.findGiftByClassId(5);
		}else{
			//按分类获取
			 gifts=GiftsSer.findGiftByClassId(t);
		}
		return JsonUtil.getGiftList(gifts,ownJucaiBills);
	}



}
