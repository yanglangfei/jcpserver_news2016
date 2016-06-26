package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.service.ReportSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 *
 *  举报   0    日志       1   问答              2    观点                 3    视频直播
 */
@SuppressWarnings("serial")
public class Report extends HttpServlet {
	private String result;
	private String ip;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String repoterType=request.getParameter("repoterType");
		String userId=request.getParameter("userId");
		String fkId=request.getParameter("fkId");
		String bodys=request.getParameter("bodys");
		ip=request.getRemoteAddr();
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					if(StringUtil.isNotNull(repoterType)&&StringUtil.isInteger(repoterType)){
						int type=Integer.parseInt(repoterType);
						if(StringUtil.isNotNull(fkId)&&StringUtil.isInteger(fkId)){
							int fId=Integer.parseInt(fkId);
							result=addRepoterInfo(uId,type,fId,bodys);
						}
					}
				}else{
					result=JsonUtil.getRetMsg(3,"用户还没登录");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"userId 参数数字格式化异常");
			}
		}else{      
			result=JsonUtil.getRetMsg(1,"userId 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String addRepoterInfo(int uId, int type, int fId, String bodys) {
		//添加投诉信息    0    日志       1   问答              2    观点                 3    视频直播
		com.jucaipen.model.Report report=new com.jucaipen.model.Report();
		report.setBodys(bodys);
		report.setFk_id(fId);
		report.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		report.setIp(ip);
		report.setIshandle(0);
		if(type==0){
			//投诉日志
			report.setType(1);
		}else if(type==1){
			//投诉问答
			report.setType(2);
		}else if(type==2){
			//投诉观点
			report.setType(3);
		}else{
			//投诉视频直播
			report.setType(4);
		}
		report.setUserId(uId);
		int isSuccess = ReportSer.addRepoter(report);
		return isSuccess==1 ?JsonUtil.getRetMsg(0, "投诉提交成功") : JsonUtil.getRetMsg(1,"投诉提交失败");
	}
}
