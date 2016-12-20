package com.jucaipen.base;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.MobileMessage;
import com.jucaipen.service.MobileMessageSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *
 *  ��֤�ֻ�������
 */
@SuppressWarnings("serial")
public class CheckMobileCode extends HttpServlet {
	private String result;
	private boolean isPassed;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String checkDate;
	private String msgId;
//	private String ip;
	//private int tId;
	private int isSuccess;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent=request.getParameter("User-Agent");
		ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);
		int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			checkDate = sdf.format(new Date());
			//�û�id  
			String userId=request.getParameter("userId");
			//�û��ֻ���
			String mobileNum=request.getParameter("telPhone");
			//��֤��
			String actionCode=request.getParameter("actionCode");
			//ȯ������
			String qsName=request.getParameter("qsName");
			String teacherId=request.getParameter("teacherId");
			if(StringUtil.isInteger(userId)){
				//�û�id���ָ�ʽ������
				if(StringUtil.isInteger(teacherId)){                
					if(StringUtil.isMobileNumber(mobileNum)){   
						if(StringUtil.isNotNull(qsName)){
						//�ֻ��ŷ���Ҫ��
						checkMobileCode(mobileNum,actionCode);
						if(isPassed){
							if(isSuccess==1){
								result=JsonUtil.getRetMsg(0, "��֤����Ϣ��ȷ");
							}else {
								result=JsonUtil.getRetMsg(5,"��֤ʧ��");
							}
						}else {
							result=JsonUtil.getRetMsg(3,"��Ч����֤��");
						}
						insertCheckInfo(mobileNum,checkDate,qsName);
						}else {
							result=JsonUtil.getRetMsg(4, "��ѡ��ȯ��");
						}
					}else {
						result=JsonUtil.getRetMsg(2,"�ֻ��Ų�����Ҫ��");
					}
				}
			}else {
				result=JsonUtil.getRetMsg(1,"�����û�id���ָ�ʽ���쳣");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}
	private void insertCheckInfo(String mobileNum, String checkDate,String qsName) {
		//�޸Ķ��ż���״̬
		MobileMessage mobileMessage=new MobileMessage();
		if(isPassed){
			mobileMessage.setMsgType(2);
			mobileMessage.setCheckDate(checkDate);
			mobileMessage.setRemark(qsName);
		}else {
			mobileMessage.setMsgType(3);
		}
		MobileMessageSer.upDateMessageType(msgId, mobileMessage);
	}
	private void checkMobileCode(String mobile, String actionCode) {
		try {
			// ��֤�ֻ���֤���Ƿ�Ϸ�
			List<MobileMessage> mobileList = MobileMessageSer.findMobileMessageByMobileNumLast(1, mobile);
			if(mobileList.size()>0){
				String checkCode=mobileList.get(0).getActionCode();
				String sendDate=mobileList.get(0).getSendDate();
				msgId = mobileList.get(0).getMsgid();
				long sendTime=sdf.parse(sendDate).getTime();
				long currrentTime=System.currentTimeMillis();
				if((actionCode.equals(checkCode))&&((currrentTime-sendTime)<=(3*60*1000))){
					isPassed=true;
				}else {
					isPassed=false;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
