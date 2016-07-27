   package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.GiftClass;
import com.jucaipen.model.Gifts;
import com.jucaipen.service.GiftClassSer;
import com.jucaipen.service.GiftsSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *  ��ȡ��Ʒ������Ϣ   
 */
@SuppressWarnings("serial")
public class QuerryGiftType extends HttpServlet {
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
			String userId=request.getParameter("userId");
			if(StringUtil.isNotNull(userId)){
				if(StringUtil.isInteger(userId)){
					int uId=Integer.parseInt(userId);
					if(uId>0){
						result=initClassData();
					}else{
						result=JsonUtil.getRetMsg(3,"���û���û��¼");
					}
				}else{
					result=JsonUtil.getRetMsg(2, "userId �������ָ�ʽ���쳣");
				}
			}else{
				result=JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private  String initClassData() {
		 //��ʼ����Ʒ������Ϣ  left
		 List<GiftClass> leftClass = GiftClassSer.findTopClass(4);
		 // middle
		 GiftClass middleGiftClass = GiftClassSer.findIdByClass(5);
		//right
		 List<Gifts> rightClass=GiftsSer.findIsTuijian(1);
		return JsonUtil.getGiftClass(leftClass,middleGiftClass,rightClass);
	}

}
