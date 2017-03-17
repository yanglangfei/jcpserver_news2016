package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.main.datautils.RollBackUtil;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Gifts;
import com.jucaipen.model.Guardian;
import com.jucaipen.model.MyGifts;
import com.jucaipen.model.MyPresent;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.GiftsSer;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.MyPresentSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ������Ʒ
 */
public class SendPresent extends HttpServlet {
	private static final long serialVersionUID = -5375079383224086542L;
	private String result;
	private Map<String,String> params=new HashMap();
	private static final String SEND_LIVE_MSG="http://www.jucaipen.com/TeacherLive/ashx/VideoLive.ashx?action=APPSendMsg";

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String teacherId = request.getParameter("receiverId");
		String parentId = request.getParameter("presentId");
		String sendNum = request.getParameter("sendNum");
		String liveId=request.getParameter("liveId");
		if (StringUtil.isNotNull(userId)) {
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(teacherId)
							&& StringUtil.isInteger(teacherId)) {
						int tId = Integer.parseInt(teacherId);
						if (StringUtil.isNotNull(parentId)
								&& StringUtil.isInteger(parentId)) {
							int pId = Integer.parseInt(parentId);
							if (StringUtil.isNotNull(sendNum)
									&& StringUtil.isInteger(sendNum)) {
								int num = Integer.parseInt(sendNum);
								result = sendTeacherParents(tId, uId, pId, num,liveId);
							} else {
								result = JsonUtil.getRetMsg(6, "sendNum �����쳣");
							}
						} else {
							result = JsonUtil.getRetMsg(5, "parentId �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(4, "teacherId �����쳣");
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
		out.println(result);
		out.flush();
		out.close();
	}

	private String sendTeacherParents(int tId, int uId, int pId, int num,String liveId) {
		// ����Ʒ��Ϣ
		// 1�������Ʒ�����Ƿ��㹻
		MyPresent present = MyPresentSer.findParentByUid(uId, pId);
		User user=UserServer.findBaseInfoById(uId);
		if (present==null || present.getPresentNum() < num) {
			return JsonUtil.getRetMsg(7, "������Ʒ��������");
		}

		Gifts g = GiftsSer.findGiftById(pId);
		int bill = g.getPrice() * num;

		FamousTeacher teacher = FamousTeacherSer.findTeacherBaseInfo(tId);

		SysAccount sysAccount = SysAccountSer.findAccountInfo();

		Rebate rebate = new Rebate();
		// ��ʦ����
		rebate.setTeacherId(tId);
		rebate.setType(0);
		rebate.setRebateMoney(bill * teacher.getReturnRate());
		rebate.setFromId(uId);
		rebate.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		rebate.setRemark("�û�������Ʒ");

		Rebate sysRebate = new Rebate();
		// ��ʦ����
		sysRebate.setTeacherId(tId);
		sysRebate.setType(1);
		sysRebate.setRebateMoney(bill * (1 - teacher.getReturnRate()));
		sysRebate.setFromId(uId);
		sysRebate.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysRebate.setRemark("�û�������Ʒ");

		Contribute contribute = new Contribute();
		contribute.setFk_id(present.getId());
		contribute.setAllJucaiBills(bill);
		contribute.setComType(1);
		contribute.setUserId(uId);
		contribute.setTeacherId(tId);
		contribute.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));

		MyGifts gifts = new MyGifts();
		gifts.setGiftId(pId);
		gifts.setGiftNum(num);
		gifts.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		gifts.setReceiverId(teacher.getFk_UserId());
		gifts.setSenderId(uId);
		gifts.setRemark("���͡�" + g.getTitle() + "����Ʒ��" + num + "������������ȥ��" + num
				+ "��");

		int isSuccess = RollBackUtil.getInstance().sendGifts(present, num, bill, uId,
				sysAccount, sysRebate, rebate, contribute, gifts);
		if(isSuccess==1){
			//������Ʒ
			String msg="<font style='color:#f00'>"+"\""+user.getUserName()+"\""+"���͸���ʦ"+"\""+teacher.getNickName()+"\""+num+"��"+g.getTitle()+"</font>";
			sendMsg(uId, liveId,msg, 0);
			/*String pushMsg=JsonUtil.createRewardMsg(false,uId,user.getUserName()+"������"+num+"��"+g.getTitle());
			JPushClient client = JPushUtils.getJPush();
			PushPayload msgs = JPushUtils.createMsg("msg", "liveMsg", pushMsg, null);
		    PushResult res = JPushUtils.pushMsg(client, msgs);*/
		}

		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "��Ʒ���ͳɹ�") : JsonUtil
				.getRetMsg(1, "��Ʒ����ʧ��");
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
		params.clear();;
		params.put("lid", lId+"");
		params.put("msgtype", 1+"");
		params.put("msg", msg);
		params.put("userlevel", fromUser.getUserLeval()+"");
		params.put("isroomadmin", 1+"");
		params.put("issysadmin",1+"");
		params.put("ischatadmin", 1+"");
		params.put("isserverid",1+"");
		params.put("nickName", "ϵͳ��Ϣ");
		params.put("isshouhuzhe",gurdianId+"");
		params.put("isteacher",fromUser.getIsTeacher()+"");
		params.put("buyproductid",fromUser.getBuyProductId()+"");
		params.put("userid", 0+"");
		String result=LoginUtil.sendHttpPost(SEND_LIVE_MSG, params);
	}
	
	
	

}
