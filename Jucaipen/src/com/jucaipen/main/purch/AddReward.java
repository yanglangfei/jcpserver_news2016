package com.jucaipen.main.purch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.daoimp.TransactionImp;
import com.jucaipen.main.datautils.RollBackUtil;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.Marker;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.service.AccountDetailSer;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.ContributeSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ���� typeId (0 ���ͽ�ʦ) ��1 ���͹۵㣩
 */
@SuppressWarnings("serial")
public class AddReward extends HttpServlet {
	private String result;
	private String ip;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String usertAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(usertAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, usertAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String typeId = request.getParameter("typeId");
			String userId = request.getParameter("userId");
			String fkId = request.getParameter("fkId");
			ip = request.getRemoteAddr();
			String allIntegeral = request.getParameter("allIntegeral");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						if (StringUtil.isNotNull(typeId)
								&& StringUtil.isInteger(typeId)) {
							int tId = Integer.parseInt(typeId);
							if (StringUtil.isNotNull(fkId)
									&& StringUtil.isInteger(fkId)) {
								int fId = Integer.parseInt(fkId);
								if (StringUtil.isNotNull(allIntegeral)
										&& StringUtil.isInteger(allIntegeral)) {
									int markerMoney = Integer
											.parseInt(allIntegeral);
									result = initMarkerInfo(uId, tId, fId,
											markerMoney);
								} else {
									result = JsonUtil.getRetMsg(6,
											"allIntegeral �����쳣");
								}
							} else {
								result = JsonUtil.getRetMsg(5, "fkId �����쳣");
							}
						} else {
							result = JsonUtil.getRetMsg(4, "typeId �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "�û���û��¼");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "userId �������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
			}

		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initMarkerInfo(int uId, int typeId, int fId, int markerMoney) {
		// ��ʼ����������
		FamousTeacher teacher = null;
		HotIdea idea = null;
		String nickName=null;
		AccountDetail detail=new AccountDetail();
		Account account=AccountSer.findAccountByUserId(uId);
	    if(account==null){
	    	return JsonUtil.getRetMsg(3,"�˻��۲ƱҲ��㣬���ֵ");
	    }
	    int integeral=account.getIntegeral();
	    int jucaiBills=account.getJucaiBills();
	    if(jucaiBills<markerMoney){
	    	return JsonUtil.getRetMsg(3,"�˻��۲ƱҲ��㣬���ֵ");
	    }
	    
	    
		Marker marker = new Marker();
		if (typeId == 0) {
			// ���ͽ�ʦ
			teacher = FamousTeacherSer.findFamousTeacherById(fId);
			nickName=teacher.getNickName();
			detail.setRemark("���͸���ʦ����"+nickName+"��");
			marker.setType(1);
		} else {
			// ���͹۵�
			idea=HotIdeaServ.findIdeaById(fId);
			int teacherId=idea.getTeacherId();
			FamousTeacherSer.findFamousTeacherById(teacherId);
			String title = idea.getTitle();
			detail.setRemark("���͹۵㣺��"+title+"��");
			marker.setType(2);
		}
		marker.setIp(ip);
		marker.setMarkerCount(markerMoney);
		marker.setUserId(uId);
		marker.setIdeaId(fId);
		marker.setInsertDate(TimeUtils.format(new Date()));
		
		detail.setOrderCode("");
		detail.setDetailMoney(markerMoney);
		detail.setDetailType(1);
		detail.setState(0);
		detail.setInsertDate(TimeUtils.format(new Date()));
		detail.setIsDel(0);
		detail.setUserId(uId);
		
		Contribute contribute=new Contribute();
		if(typeId == 0){
			//���ͽ�ʦ
			contribute.setComType(5);
			contribute.setFk_id(0);
		}else{
			contribute.setComType(9);
			contribute.setFk_id(fId);
		}
		contribute.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		contribute.setUserId(uId);
		contribute.setTeacherId(fId);
		contribute.setAllJucaiBills(markerMoney);
		
		SysAccount sysAccount=SysAccountSer.findAccountInfo();
		
		
		SysDetailAccount sysDetail=new SysDetailAccount();
		sysDetail.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		sysDetail.setIsDel(0);
		sysDetail.setIp(ip);
		sysDetail.setOrderId(0);
		sysDetail.setPrice(markerMoney);
		sysDetail.setRecoderType(2);
		if(typeId>0){
			sysDetail.setRemark("���͸���ʦ����"+teacher.getNickName()+"��");
		}else{
			sysDetail.setRemark("���͹۵㣺��"+idea.getTitle()+"��");
		}
		
		sysDetail.setType(13);
		sysDetail.setUserId(uId);
		
		Rebate rebate=new Rebate();
		rebate.setRebateMoney(markerMoney);
		//rebate.setType(type);
		
		
		
		int isSuccess = RollBackUtil.addReward(marker,detail,integeral,markerMoney,jucaiBills,uId,contribute,sysAccount,sysDetail);
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "���ͳɹ�") : JsonUtil
				.getRetMsg(1, "����ʧ��");
	}

}
