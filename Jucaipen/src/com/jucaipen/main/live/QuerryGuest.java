package com.jucaipen.main.live;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.StudioGuest;
import com.jucaipen.service.StudioGuestSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ�α�
 */
@SuppressWarnings("serial")
public class QuerryGuest extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String studioId=request.getParameter("studioId");
			if(StringUtil.isNotNull(studioId)){
				if(StringUtil.isInteger(studioId)){
					int sId=Integer.parseInt(studioId);
					result=initStudioGuest(sId);
				}else{
					result=JsonUtil.getRetMsg(2,"studioId �������ָ�ʽ���쳣");
				}
			}else{
				result=JsonUtil.getRetMsg(1,"studioId ��������Ϊ��");
			}
			
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initStudioGuest(int sId) {
		//��ʼ���ݲ��Ҽα���Ϣ
		List<StudioGuest> guests = StudioGuestSer.findTopGuest(6, sId);
		return JsonUtil.getGuests(guests);
	}

}
