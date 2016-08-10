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
 *  �ٱ�     repoterType   0    ��־       1   �ʴ�              2    �۵�                 3    ��Ƶֱ��
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
						}else{
							result=JsonUtil.getRetMsg(4,"fkId �����쳣");
						}
					}else{
						result=JsonUtil.getRetMsg(5,"repoterType �����쳣");
					}
				}else{
					result=JsonUtil.getRetMsg(3,"�û���û��¼");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"userId �������ָ�ʽ���쳣");
			}
		}else{      
			result=JsonUtil.getRetMsg(1,"userId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String addRepoterInfo(int uId, int type, int fId, String bodys) {
		//���Ͷ����Ϣ    0    ��־       1   �ʴ�              2    �۵�                 3    ��Ƶֱ��
		com.jucaipen.model.Report report=new com.jucaipen.model.Report();
		report.setBodys(bodys);
		report.setFk_id(fId);
		report.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		report.setIp(ip);
		report.setIshandle(0);
		if(type==0){
			//Ͷ����־
			report.setType(1);
		}else if(type==1){
			//Ͷ���ʴ�
			report.setType(2);
		}else if(type==2){
			//Ͷ�߹۵�
			report.setType(3);
		}else{
			//Ͷ����Ƶֱ��
			report.setType(4);
		}
		report.setUserId(uId);
		int isSuccess = ReportSer.addRepoter(report);
		return isSuccess==1 ?JsonUtil.getRetMsg(0, "Ͷ���ύ�ɹ�") : JsonUtil.getRetMsg(1,"Ͷ���ύʧ��");
	}
}
