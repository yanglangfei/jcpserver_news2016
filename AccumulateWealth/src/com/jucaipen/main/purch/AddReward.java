package com.jucaipen.main.purch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections.map.HashedMap;
import com.jucaipen.main.datautils.RollBackUtil;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Guardian;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.Marker;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *     ���� typeId (0 ���ͽ�ʦ) ��1 ���͹۵㣩
 */
public class AddReward extends HttpServlet {
	private static final long serialVersionUID = 7660136154061926366L;
	private String result;
	private String ip;
	private Map<String, String> params=new HashedMap();
	private static final String SEND_LIVE_MSG="http://www.jucaipen.com/TeacherLive/ashx/VideoLive.ashx?action=APPSendMsg";

	
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
			String liveId=request.getParameter("liveId");
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
											markerMoney,liveId);
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

	private String initMarkerInfo(int uId, int typeId, int fId, int markerMoney,String liveId) {
		// ��ʼ����������
		FamousTeacher teacher = null;
		int teacherId;
		HotIdea idea = null;
		String nickName = null;
		AccountDetail detail = new AccountDetail();
		AccountDetail detailIntegeral = new AccountDetail();
		Account account = AccountSer.findAccountByUserId(uId);
		int integeral = account.getIntegeral();
       
		if(markerMoney<=0){
			return JsonUtil.getRetMsg(6,"���ͽ���쳣");
		}
		
		if (account == null||account.getJucaiBills()<markerMoney) {
			return JsonUtil.getRetMsg(3, "�˻��۲ƱҲ��㣬���ֵ");
		}
		 int jucaiBills=account.getJucaiBills();
		User user = UserServer.findBaseInfoById(uId);
		Marker marker = new Marker();
		if (typeId == 0) {
			// ���ͽ�ʦ
			teacherId = fId;
			teacher = FamousTeacherSer.findTeacherBaseInfo(fId);
			nickName = teacher.getNickName();
			detail.setRemark("���͸���ʦ����" + nickName + "��");
			detailIntegeral.setRemark("���͸���ʦ����" + nickName + "��,�˻�����+"
					+ markerMoney);
			marker.setType(1);
		} else {
			// ���͹۵�
			idea = HotIdeaServ.findIdeaById(fId);
			teacherId = idea.getTeacherId();
			teacher = FamousTeacherSer.findTeacherBaseInfo(teacherId);
			String title = idea.getTitle();
			detail.setRemark("���͹۵㣺��" + title + "��");
			detailIntegeral.setRemark("���͹۵㣺��" + title + "��,�˻�����+"
					+ markerMoney);
			marker.setType(2);
		}
		marker.setIp(ip);
		marker.setMarkerCount(markerMoney);
		marker.setUserId(uId);
		marker.setIdeaId(fId);
		marker.setInsertDate(TimeUtils.format(new Date()));

		detail.setOrderCode("");
		detailIntegeral.setOrderCode("");
		detail.setDetailMoney(markerMoney);
		detailIntegeral.setDetailMoney(markerMoney);
		// �������� 0���룬1����
		detail.setDetailType(1);
		detailIntegeral.setDetailType(0);
		// 0�۲Ʊң�1����
		detail.setState(0);
		detailIntegeral.setState(1);
		detail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detailIntegeral.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detailIntegeral.setIsDel(0);
		detail.setUserId(uId);
		detailIntegeral.setUserId(uId);
		Contribute contribute = new Contribute();
		if (typeId == 0) {
			// ���ͽ�ʦ
			contribute.setComType(5);
			contribute.setFk_id(0);
		} else {
			contribute.setComType(9);
			contribute.setFk_id(fId);
		}
		contribute.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		contribute.setUserId(uId);
		contribute.setTeacherId(fId);
		contribute.setAllJucaiBills(markerMoney);

		SysAccount sysAccount = SysAccountSer.findAccountInfo();

		SysDetailAccount sysDetail = new SysDetailAccount();
		sysDetail.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysDetail.setIsDel(0);
		sysDetail.setIp(ip);
		sysDetail.setOrderId(0);
		sysDetail.setPrice(markerMoney);
		sysDetail.setRecoderType(2);
		if (typeId == 0) {
			sysDetail.setRemark("���͸���ʦ����" + teacher.getNickName() + "��");
		} else {
			sysDetail.setRemark("���͹۵㣺��" + idea.getTitle() + "��");
		}

		sysDetail.setType(13);
		sysDetail.setUserId(uId);

		// ��ʦ����
		Rebate rebate = new Rebate();
		rebate.setRebateMoney((markerMoney * teacher.getReturnRate()));
		rebate.setType(0);
		rebate.setTeacherId(teacherId);
		rebate.setFromId(uId);
		rebate.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		rebate.setRemark("�û����ͷ���");
		// ϵͳ����
		Rebate sysRebate = new Rebate();
		sysRebate.setRebateMoney((markerMoney * (1 - teacher.getReturnRate())));
		sysRebate.setType(1);
		sysRebate.setTeacherId(teacherId);
		sysRebate.setFromId(uId);
		sysRebate.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysRebate.setRemark("�û����ͷ���");

		int isSuccess = RollBackUtil.getInstance().addReward(marker, detail, integeral,
				markerMoney, jucaiBills, uId, contribute, sysAccount,
				sysDetail, user, rebate, sysRebate, detailIntegeral);
		if( isSuccess == 1&&typeId==0){
			//���ͽ�ʦ
			String msg="<font style='color:#f00'>"+"\""+user.getUserName()+"\""+"������ʦ"+"\""+teacher.getNickName()+"\""+markerMoney+"���۲Ʊ�</font>";
			sendMsg(uId, liveId,msg, 0);
			/*String pushMsg=JsonUtil.createRewardMsg(false,uId,user.getUserName()+"������"+markerMoney+"���۲Ʊ�");
			JPushClient client = JPushUtils.getJPush();
			PushPayload msgs = JPushUtils.createMsg("msg", "liveMsg", pushMsg, null);
		    PushResult res = JPushUtils.pushMsg(client, msgs);*/
		}
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "���ͳɹ�") : JsonUtil
				.getRetMsg(1, "����ʧ��");
	}
	
	
	/**
	 * @param uId
	 * @param lId
	 * @param msg
	 * @param toId
	 * @return   ������Ϣ
	 */
	public  void sendMsg(int uId, String liveId, String msg, int toId){
		int gurdianId;
		User fromUser;
		int teacherId=0;
		User toUser;
		int lId=0;
		if(StringUtil.isNotNull(liveId)&&StringUtil.isInteger(liveId)){
			lId=Integer.parseInt(liveId);
		}
		VideoLive live = VideoLiveServer.getRoomInfo(lId);
		if(live!=null){
			teacherId=live.getTeacherId();
		}
		
		Guardian fromGuardian = null;
		if(uId>0){
			fromUser=UserServer.findUserChatInfo(uId);
			fromGuardian = GuardianSer.findIsGuardian(teacherId, uId);
			toUser=UserServer.findUserChatInfo(toId);
			if(toUser==null){
				toUser=new User();
			}
		}else{
			fromUser=new User();
			toUser=new User();
		}
		if(fromGuardian!=null){
			gurdianId=fromGuardian.getId();
		}else{
			gurdianId=0;
		}
		params.clear();
		params.put("msgtype", 1+"");
		params.put("lid", lId+"");
		params.put("msg", msg);
		params.put("userlevel", fromUser.getUserLeval()+"");
		params.put("isroomadmin", 1+"");
		params.put("issysadmin", 1+"");
		params.put("ischatadmin", 1+"");
		params.put("isserverid",1+"");
		params.put("isshouhuzhe",gurdianId+"");
		params.put("isteacher",fromUser.getIsTeacher()+"");
		params.put("buyproductid",fromUser.getBuyProductId()+"");
		params.put("nickName", "ϵͳ��Ϣ");
		params.put("userid", 0+"");
		String result=LoginUtil.sendHttpPost(SEND_LIVE_MSG, params);
	}
	
	

}
