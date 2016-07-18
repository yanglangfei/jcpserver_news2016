package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.RebateIntegeralDetail;
import com.jucaipen.model.Sign;
import com.jucaipen.model.SignDetail;
import com.jucaipen.model.SiteConfig;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountDetailSer;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.RebateIntegeralDetailSer;
import com.jucaipen.service.SignDetailSer;
import com.jucaipen.service.SignSer;
import com.jucaipen.service.SiteConfigSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 *
 *  ǩ��
 */
@SuppressWarnings("serial")
public class SignIn extends HttpServlet {
	private String result;
	private String ip;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		ip=request.getRemoteAddr();
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					result=initSignInData(uId);
				}else{
					result=JsonUtil.getRetMsg(3,"�û���û��¼");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"userId �������ָ�ʽ���쳣");
			}
		}else{
			result=JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
		}
		
		out.println(result);
		out.flush();
		out.close();
	}

	private String initSignInData(int uId) {
		//��ʼ��ǩ����Ϣ
		List<SignDetail> dets=SignDetailSer.findMothSignDetailByUserId(uId);
		for(SignDetail detail :dets){
			String insertDate=detail.getInsertDate();
			if(TimeUtils.isToday(insertDate)){
				return JsonUtil.getRetMsg(1,"�������Ѿ�ǩ���ɹ�");
			}
		}
		User user=UserServer.findUserById(uId);
		String insertDate=TimeUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
		//����ǩ����ϸ��
		SignDetail detail=new SignDetail();
		detail.setInsertDate(insertDate);
		detail.setIp(ip);
		detail.setUserId(uId);
		detail.setRemark("ǩ���ɹ�");
		int isSuccess = SignDetailSer.addSignDetail(detail);
		if(isSuccess==1){
			//����ǩ���ܱ�
			int signNum=SignSer.findSignCount(uId);
			Sign sign=new Sign();
			sign.setLastDate(insertDate);
			sign.setIp(ip);
			sign.setSignNum(signNum+1);
			sign.setUserId(uId);
			SignSer.updateSign(sign);
			
			//��ȡǩ����������Ϣ
			SiteConfig config = SiteConfigSer.findSiteConfig();
			int signIntegeral=config.getSignIntegeral();
			//���·�����
			RebateIntegeralDetail inDetail=new RebateIntegeralDetail();
			inDetail.setFromId(uId);
			inDetail.setInsertDate(TimeUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
			inDetail.setIntegralNum(signIntegeral);
			inDetail.setType(4);
			inDetail.setUserId(uId);
			inDetail.setRemark("�û�ǩ����"+user.getUserName()+"��");
			RebateIntegeralDetailSer.addRebateIntegeral(inDetail);
			//�����˻���ϸ������Ϣ��
			AccountDetail accountDetail=new AccountDetail();
			accountDetail.setDetailMoney(signIntegeral);
			accountDetail.setDetailType(0);
			accountDetail.setInsertDate(insertDate);
			accountDetail.setIsDel(0);
			accountDetail.setOrderCode(TimeUtils.format(new Date(),"yyyyMMddHHmmssSSSS"));
			accountDetail.setUserId(uId);
			accountDetail.setState(1);
			accountDetail.setRemark("ǩ����"+signIntegeral+"����");
			AccountDetailSer.addDetails(accountDetail);
			//�������˻�������Ϣ
			Account a=AccountSer.findAccountByUserId(uId);
			int newIntegeral=signIntegeral+a.getIntegeral();
			AccountSer.updateIntegeral(uId, newIntegeral);
			//�����û��������Ϣ
			UserServer.updateIntegeral(uId,newIntegeral);
			return JsonUtil.getRetMsg(0, "ǩ���ɹ�");
		}else{
			return JsonUtil.getRetMsg(1,"ǩ��ʧ��");
		}
	}

}
