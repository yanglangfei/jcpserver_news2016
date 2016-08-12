package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.FeedBack;
import com.jucaipen.service.FeedBackSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         �������
 *         deviceType    0     android      1    ios
 */
@SuppressWarnings("serial")
public class AddFeedBack extends HttpServlet {
	private String result;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String ip = request.getRemoteAddr();
		String trueName = request.getParameter("trueName");
		String contact = request.getParameter("contact");
		String userId = request.getParameter("userId");
		String bodys = request.getParameter("bodys");
		String deviceType=request.getParameter("deviceType");
		if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isNotNull(trueName)) {
					if (StringUtil.isNotNull(contact)) {
						if (StringUtil.isNotNull(bodys)) {
							if(StringUtil.isNotNull(deviceType)&&StringUtil.isInteger(deviceType)){
								int devType=Integer.parseInt(deviceType);
								result = inserAdvice(trueName, contact, uId, bodys,ip,devType);
							}else{
								result=JsonUtil.getRetMsg(6,"deviceType �����쳣");
							}
						}else{
							result=JsonUtil.getRetMsg(5,"�������ݲ���Ϊ��");
						}
					}else{
						result=JsonUtil.getRetMsg(4,"��ϵ��ʽ����Ϊ��");
					}
				}else{
					result=JsonUtil.getRetMsg(3, "��ʵ��������Ϊ��");
				}
			}else{
				result=JsonUtil.getRetMsg(2, "�û���û��¼");
			}
		}else{
			result=JsonUtil.getRetMsg(1, "userId �����쳣");
		}

		out.println(result);
		out.flush();
		out.close();
	}

	private String inserAdvice(String trueName, String contact, int uId,
			String bodys, String ip, int devType) {
		FeedBack feedBack=new FeedBack();
		feedBack.setBody(bodys);
		feedBack.setInsertDate(TimeUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
		feedBack.setIp(ip);
		feedBack.setMobileNum(contact);
		feedBack.setTrueName(trueName);
		feedBack.setUserId(uId);
		feedBack.setType(0);
		int isSuccess = FeedBackSer.insertFeedBack(feedBack);
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "��������ɹ�") : JsonUtil.getRetMsg(1,"�������ʧ��");
	}

}