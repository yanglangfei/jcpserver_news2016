package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.TacticsSale;
import com.jucaipen.service.TacticsSaleSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;
/**
 * @author Administrator
 * 
 *         ����ս����Ϣ
 */
@SuppressWarnings("serial")
public class OrderTactics extends HttpServlet {
	private String result;
	private String ip;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ip=request.getRemoteAddr();
		String telPhone=request.getParameter("telPhone");
		String userId = request.getParameter("userId");
		String tacticeId = request.getParameter("tacticsId");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		if (StringUtil.isNotNull(userId)) {
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(tacticeId)) {
						if (StringUtil.isInteger(tacticeId)) {
							int tId = Integer.parseInt(tacticeId);
							if(StringUtil.isNotNull(telPhone)&&StringUtil.isMobileNumber(telPhone)){
								result = orderTactics(uId, tId,telPhone);
							}
						}else{
							result=JsonUtil.getRetMsg(5,"tacticeId �������ָ�ʽ���쳣��");
						}
					} else {
						result = JsonUtil.getRetMsg(4, "tacticeId ��������Ϊ��");
					}
				} else {
					result = JsonUtil.getRetMsg(3, " �û���û��¼");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "userId �������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String orderTactics(int uId, int tId, String telPhone) {
		TacticsSale sale=new TacticsSale();
		sale.setUserId(uId);
		sale.setTacticsId(tId);
		sale.setIp(ip);
		sale.setTelPhone(telPhone);
		sale.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		// ����ս����Ϣ
		int isSuccess=TacticsSaleSer.addSale(sale);
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "���ĳɹ�") : JsonUtil.getRetMsg(1, "����ʧ��");
	}

}
