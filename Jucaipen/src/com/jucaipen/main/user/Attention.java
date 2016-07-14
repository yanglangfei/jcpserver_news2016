package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Fans;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.FansSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ��ע��ʦ opType 0 ��ӹ�ע 1 ȡ����ע
 * 
 */
@SuppressWarnings("serial")
public class Attention extends HttpServlet {
	private String result;
	private String ip;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String opType = request.getParameter("opType");
			String userId = request.getParameter("userId");
			String teacherId = request.getParameter("teacherId");
			ip=request.getRemoteAddr();
			if (StringUtil.isInteger(opType)) {
				int type = Integer.parseInt(opType);
				if (StringUtil.isInteger(userId)) {
					// �û�id���ָ�ʽ������
					int uId = Integer.parseInt(userId);
					if(uId>0){
						if (StringUtil.isInteger(teacherId)) {
							int tId = Integer.parseInt(teacherId);
							if (type == 0||type==1) {
								boolean isFans=checkIsAttention(uId, tId);
								result=initData(isFans,type,uId,tId);
							} else {
								result = JsonUtil.getRetMsg(5, "����id������Ҫ��");
							}
						} else {
							result = JsonUtil.getRetMsg(1, "��ʦid���ָ�ʽ���쳣");
						}
					}else{
						result=JsonUtil.getRetMsg(7,"�û���û��¼");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "�û�id���ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(4, "����id���ָ�ʽ���쳣");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initData(boolean isFans, int type, int uId, int tId) {
		if(type==0){
			//��ӹ�ע
			if(isFans){
				return JsonUtil.getRetMsg(1,"�ý�ʦ�Ѿ���ע��");
			}
			Fans fan=new Fans();
			fan.setUserId(uId);
			fan.setTeacherId(tId);
			fan.setIp(ip);
			fan.setInsertDate(TimeUtils.format(new Date()));;
			int isSuccess=FansSer.addFans(fan);
			if(isSuccess==1){
				//��ӽ�ʦ��˿��
				FamousTeacher teacher=FamousTeacherSer.findTeacherBaseInfo(tId);
				FamousTeacherSer.updateFansNum(teacher.getFans()+1, tId);
			}
			return isSuccess==1?JsonUtil.getRetMsg(0, "��ע�ɹ�"):JsonUtil.getRetMsg(2,"��עʧ��");
		}else if(type==1){
			//ȡ����ע
			if(!isFans){
				return JsonUtil.getRetMsg(1,"�ý�ʦ��û��ע");
			}
			int isSuccess=FansSer.cancelFans(tId,uId);
			return isSuccess==1?JsonUtil.getRetMsg(0, "ȡ����ע�ɹ�") :JsonUtil.getRetMsg(2,"ȡ����עʧ��");
		}
		return null;
	}


	private boolean checkIsAttention(int uId, int tId) {
		// ���֮ǰ�Ƿ��ע��
		Fans f=FansSer.findIsFans(uId, tId);
		if(f!=null){
			return true;
		}else{
			return false;
		}
	}
}
