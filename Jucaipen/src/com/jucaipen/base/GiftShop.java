package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Gifts;
import com.jucaipen.service.GiftsSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取商店礼品信息   0  全部     10  推荐
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
			String page = request.getParameter("page");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							if (StringUtil.isNotNull(type)) {
								if (StringUtil.isInteger(type)) {
									// 根据分类获取礼品信息
									int t = Integer.parseInt(type);
									result = initGiftByClassId(t, p);
								} else {
									result = JsonUtil
											.getRetMsg(4, "type 参数数字格式化异常");
								}
							} else {
								// 获取所有礼品信息
								result = initAllGifts(p);
							}
						} else {
							result = JsonUtil.getRetMsg(5, "page 参数异常");
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

	private String initGiftByClassId(int t, int p) {
		//根据分类获取礼品信息
		List<Gifts> gifts;
		if(t==10){
			//按推荐查询
			 gifts=GiftsSer.findIsTuijian(1);
		}else{
			 gifts=GiftsSer.findGiftByClassId(p, t);
		}
		return JsonUtil.getGiftList(gifts);
	}

	private String initAllGifts(int page) {
		// 初始化所有礼品信息
		List<Gifts> gifts = GiftsSer.findAllGift(page);
		return JsonUtil.getGiftList(gifts);
	}

}
