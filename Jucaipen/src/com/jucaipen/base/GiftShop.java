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
 *         ��ȡ�̵���Ʒ��Ϣ
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
									// ���ݷ����ȡ��Ʒ��Ϣ
									int t = Integer.parseInt(type);
									result = initGiftByClassId(t, p);
								} else {
									result = JsonUtil
											.getRetMsg(4, "type �������ָ�ʽ���쳣");
								}
							} else {
								// ��ȡ������Ʒ��Ϣ
								result = initAllGifts(p);
							}
						} else {
							result = JsonUtil.getRetMsg(5, "page �����쳣");
						}

					} else {
						result = JsonUtil.getRetMsg(3, "���û�û��¼");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "userId �������ָ�ʽ���쳣");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initGiftByClassId(int t, int p) {
		//���ݷ����ȡ��Ʒ��Ϣ
		List<Gifts> gifts=GiftsSer.findGiftByClassId(p, t);
		return JsonUtil.getGiftList(gifts);
	}

	private String initAllGifts(int page) {
		// ��ʼ��������Ʒ��Ϣ
		List<Gifts> gifts = GiftsSer.findAllGift(page);
		return JsonUtil.getGiftList(gifts);
	}

}
