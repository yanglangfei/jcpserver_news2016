package com.jucaipen.main.play;

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
 *         ��ȡ�α�   typeId   (0 ��ȡ��ҳ�α�)   ��1 ��ȡȫ���α���
 */
public class QuerryGuest extends HttpServlet {
	private static final long serialVersionUID = 8943981291520195117L;
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
			String typeId=request.getParameter("typeId");
			String studioId=request.getParameter("studioId");
			if(StringUtil.isNotNull(studioId)){
				if(StringUtil.isInteger(studioId)){
					int sId=Integer.parseInt(studioId);
					if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
						int type=Integer.parseInt(typeId);
						if(type==0){
							//��ȡ��ҳ�α�
							result=initStudioGuest(sId,type,0);
						}else{
							//��ȡȫ���α�
							String page=request.getParameter("page");
							if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
								int p=Integer.parseInt(page);
								result=initStudioGuest(sId,type,p);
							}else{
								result=JsonUtil.getRetMsg(4,"page �������ָ�ʽ���쳣");
							}
						}
					}else{
						result=JsonUtil.getRetMsg(3,"typeId �����쳣");
					}
					
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

	private String initStudioGuest(int sId, int type,int page) {
		//��ʼ���ݲ��Ҽα���Ϣ
		List<StudioGuest> guests;
		if(type==0){
			//��ȡ��ҳ�α�
			guests = StudioGuestSer.findTopGuest(2, sId);
		}else{
			//��ȡȫ���α�
			guests=StudioGuestSer.findAll(page, sId);
		}
		return JsonUtil.getGuests(guests);
	}
}
