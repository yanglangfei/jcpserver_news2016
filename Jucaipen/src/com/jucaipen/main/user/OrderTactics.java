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
 *       订阅战法信息
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
								if(StringUtil.isNotNull(startDate)){
									if(StringUtil.isNotNull(endDate)){
										result = orderTactics(uId, tId,telPhone,startDate,endDate);
									}else{
										result=JsonUtil.getRetMsg(7, "endDate 参数异常");
									}
								}else{
									result=JsonUtil.getRetMsg(6, "startDate 参数异常");
								}
							}
						}else{
							result=JsonUtil.getRetMsg(5,"tacticeId 参数数字格式化异常和");
						}
					} else {
						result = JsonUtil.getRetMsg(4, "tacticeId 参数不能为空");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "用户还没登录");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "userId 参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String orderTactics(int uId, int tId, String telPhone,String startDate,String endDate) {
		TacticsSale sale=new TacticsSale();
		sale.setUserId(uId);
		sale.setTacticsId(tId);
		sale.setIp(ip);
		sale.setStartDate(startDate);
		sale.setEndDate(endDate);
		sale.setTelPhone(telPhone);
		sale.setIsStop(0);
		sale.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		// 订阅战法信息
		int isSuccess=TacticsSaleSer.addSale(sale);
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "订阅成功") : JsonUtil.getRetMsg(1, "订阅失败");
	}

}
