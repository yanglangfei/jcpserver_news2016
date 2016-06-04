package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.Ask;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.AskSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ��ѯ��ʦ
 */
@SuppressWarnings("serial")
public class AskQuestion extends HttpServlet {
	private int isSuccess;
	private String result;
	private String ip;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 

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
			String askType = request.getParameter("questionType");
			String userId = request.getParameter("userId");
			String askBodys = request.getParameter("askBodys");
			String teacherId = request.getParameter("teacherId");
			ip = request.getRemoteAddr();
			if (StringUtil.isInteger(userId)) {
				// �û�id��ʽ��ȷ
				int uId = Integer.parseInt(userId);

				if (StringUtil.isInteger(teacherId)) {
					// ��ʦid���ָ�ʽ����ȷ
					int tId = Integer.parseInt(teacherId);
					// �ж����������Ƿ񳬳����Ƶ�������
					if (initMaxAskNum(uId, tId)) {
						if (tId > 0) {
							if (StringUtil.isInteger(askType)) {
								// �����������ָ�ʽ����ȷ
								if (StringUtil.isNotNull(askBodys)) {
									int type = Integer.parseInt(askType);
									if (type > 0) {
										result=createAskModel(uId, tId, type, askBodys);
									} else {
										result = JsonUtil.getRetMsg(6, "����id�Ҳ���");
									}
								} else {
									result = JsonUtil.getRetMsg(5, "��ѯ���ݲ���Ϊ��");
								}

							} else {
								// �����������ָ�ʽ���쳣
								result = JsonUtil.getRetMsg(2, "��ѯ����������ָ�ʽ���쳣");
							}

						} else {
							result = JsonUtil.getRetMsg(7, "��ʦid�쳣");
						}

					} else {
						result = JsonUtil.getRetMsg(8, "�����������Ѿ���������");
					}
				} else {
					// ��ʦid���ָ�ʽ���쳣
					result = JsonUtil.getRetMsg(3, "��ʦid���ָ�ʽ���쳣");
				}
			} else {
				// �û�id���ָ�ʽ���쳣
				result = JsonUtil.getRetMsg(4, "�û�id���ָ�ʽ���쳣");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private boolean initMaxAskNum(int uId, int tId) {
		// ��ȡ����������͵�ǰ�Ѿ����ʵ�����
		int askNum = 0;
		int maxNum=FamousTeacherSer.findMaxAsk(tId);
		List<Ask> asks=AskSer.findAskByUserId(uId);
		for(Ask ask : asks){
			String askDate=ask.getAskDate();
			boolean isToday=TimeUtils.compareDate(askDate);
			if(isToday){
				++askNum;
			}
		}
		return askNum<=maxNum;
	}

	private String createAskModel(int uId, int tId, int type, String askBodys) {
		Ask ask = new Ask();
		ask.setUserId(uId);
		ask.setTeacherId(tId);
		ask.setClassId(type);
		ask.setAskBody(askBodys);
		ask.setAskDate(sdf.format(new Date()));
		ask.setHits(0);
		ask.setIp(ip);
		ask.setIsPay(0);
		ask.setIsReply(1);
		ask.setParentId(0);
		ask.setAskState(1);
		ask.setAskFrom(2);
		ask.setJucaiBills(0);
		ask.setIsReturnJcb(0);
		isSuccess = AskSer.insertAsk(ask);
		return isSuccess==1 ?JsonUtil.getRetMsg(0, "������Ϣ�ύ�ɹ�") : JsonUtil.getRetMsg(1,"������Ϣ�ύʧ��");

	}

}
