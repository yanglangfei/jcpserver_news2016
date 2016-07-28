package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.MessageModel;
import com.jucaipen.model.MobileMessage;
import com.jucaipen.model.User;
import com.jucaipen.service.MessageModelSer;
import com.jucaipen.service.MobileMessageSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.timetask.MobileState;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.HttpUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.RandomUtils;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *         �����ֻ���֤��
 * 
 *         msgId   1 
 *         
 *         typeId   0    ע��    1   �޸��ֻ���   2  �޸�����   3  ��������
 */
@SuppressWarnings("serial")
public class SendMobileCode extends HttpServlet {
	private String result;
	//�����ֻ���
	private String encrypePath = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=GetEncryptMobileNum";
	private Map<String, String> param = new HashMap<String, String>();
	//������֤��
	private String check_url = "http://222.73.117.158/msg/HttpBatchSendSM?account="+StringUtil.sendPhoneAccount+"&pswd="+StringUtil.sendPhonePwd+"&mobile=";
	private String msg;
	private String newMsg;
	private String ip;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int isSuccess;


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ip = request.getRemoteAddr();
		String userAgent=request.getParameter("User-Agent");
		ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);
		int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			String mobileNum = request.getParameter("telPhone");
			String msgId = request.getParameter("msgId");
			String remark=request.getParameter("remark");
			String typeId=request.getParameter("typeId");
			if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
				int type=Integer.parseInt(typeId);
				if (msgId != null && StringUtil.isInteger(msgId)) {
					int id = Integer.parseInt(msgId);
					if (StringUtil.isMobileNumber(mobileNum)) {
						param.put("mobilenum", mobileNum);
						String telStr=LoginUtil.sendHttpPost(encrypePath, param);
						JSONObject obg=new JSONObject(telStr);
						boolean rest=obg.getBoolean("Result");
						if(rest){
							String tel=obg.getString("MobileNum");
							boolean isExist=checkIsExist(tel);
							if(type==0&&isExist){
								result=JsonUtil.getRetMsg(4, "�ֻ����Ѿ�ע��");
							}else{
								initMessage(id);
								if (msg != null) {
									String code = RandomUtils.getRandomData(4);
									if (id == 3) {
										msg = StringUtil.replaceStr(msg);
										newMsg = msg.replace("{actioncode}", code);
									} else {
										newMsg = msg.replace("{mobile_code}", code);
									}
									String path = check_url + mobileNum + "&msg="
											+ URLEncoder.encode(newMsg, "UTF-8")
											+ "&needstatus=true";
									String res = HttpUtils.sendHttpGet(path);
								//	String resptime = res.split(",")[0];
									String tempStr = res.split(",")[1];
									String ret_code = tempStr.substring(0, 1);
									//String mId = tempStr.substring(1, tempStr.length());
									if(Integer.parseInt(ret_code)==0){
										result = JsonUtil.getRetMsg(0, "���ŷ��ͳɹ�");
										insertMobileMessage(tel, code, res,remark,type);
									}else{
										result=JsonUtil.getRetMsg(7, "���ŷ����쳣");
									}
								} else {
									result = JsonUtil.getRetMsg(2, "���ŷ���ʧ��");
								}
							}
						}else{
							result=JsonUtil.getRetMsg(6,"�ֻ��ų����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(1, "�ֻ��Ÿ�ʽ����");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "����ID״̬�쳣");
				}
				
			}else{
				result=JsonUtil.getRetMsg(3, "typeId �����쳣");
			}
		}else{
			result=StringUtil.isVaild;
		}
		System.out.println("res:"+result);
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param mobileNum  ����ֻ����Ƿ��Ѿ�����
	 */
	private boolean checkIsExist(String mobileNum) {
		User user = UserServer.findUserByTelPhone(mobileNum);
		if(user!=null){
			return true;
		}else{
			return false;
		}
		
	}

	private void insertMobileMessage(String mobileNum, String code,
			String results,String mark, int type) {
		// ��Ӷ��ż�¼
		String resptime = results.split(",")[0];
		String tempStr = results.split(",")[1];
		String ret_code = tempStr.substring(0, 1);
		String msgId = tempStr.substring(1, tempStr.length());
		MobileMessage message = new MobileMessage();
		message.setActionCode(code);
		message.setTelPhone(mobileNum);
		message.setResptime(resptime);
		message.setMsgid(msgId);
		message.setRespstatus(Integer.parseInt(ret_code));
		message.setSendIp(ip);
		message.setSendDate(sdf.format(new Date()));
		message.setMessageContent(newMsg);
		message.setMsgType(1);
		message.setSendDev(3);
		// 0    ע��    1   �޸��ֻ���   2  �޸�����   3  ��������
		if(type==0){
			message.setRemark("APP�û�ע��");
		}else if(type==1){
			message.setRemark("APP�û��޸��ֻ���");
		}else if(type==2){
			message.setRemark("APP�û��޸�����");
		}else if(type==3){
			message.setRemark("APP�û��һ�����");
		}
		message.setRemark(mark);
		isSuccess = MobileMessageSer.insertMessage(message);
		if (isSuccess == 1) {
			changeMsgState(message);
		}

	}

	private void changeMsgState(MobileMessage message) {
		// �����Ӻ�ı��ֻ�����״̬
		Timer timer = new Timer();
		MobileState state = new MobileState(message);
		timer.schedule(state, 60000 * 3);
	}

	private void initMessage(int id) {
		// ��ʼ����������
		MessageModel messageModel = MessageModelSer.findModelById(id);
		msg = messageModel.getModelContent();

	}

}
