package com.jucaipen.main.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.OrderDetail;
import com.jucaipen.service.OrderDetailServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *
 * ��ѯ�ҵĶ���
 */
@SuppressWarnings("serial")
public class QuerryMyOrder extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent=request.getParameter("User_Agent");
        ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);
        int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
        if(isDevice==HeaderUtil.PHONE_APP){
        	String userId=request.getParameter("userId");
    		String type=request.getParameter("type");
    		String page=request.getParameter("page");
    		if(StringUtil.isNotNull(userId)){
    			if(StringUtil.isInteger(userId)){
    				int uId=Integer.parseInt(userId);
    				if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
    					int p=Integer.parseInt(page);
    					if(StringUtil.isNotNull(type)&&StringUtil.isInteger(type)){
    						int t=Integer.parseInt(type);
    						result=initMyOrder(uId,p,t);
    					}else{
    						result=JsonUtil.getRetMsg(4,"type �����쳣");
    					}
    				}else{
    					result=JsonUtil.getRetMsg(3,"page �����쳣");
    				}
    			}else{
    				result=JsonUtil.getRetMsg(2,"userId �������ָ�ʽ���쳣");
    			}
    		}else{
    			result=JsonUtil.getRetMsg(1,"userId ��������Ϊ��");
    		}
        }else{
        	result=StringUtil.isVaild;
        }
		out.println(result);
		out.flush();
		out.close();
	}

	private String initMyOrder(int uId, int p, int t) {
		//��ʼ��������Ϣ
		List<OrderDetail> details = OrderDetailServer.findDetailByUIdAndType(uId, t, p);
		return JsonUtil.getOrderDetail(details);
	}

}
