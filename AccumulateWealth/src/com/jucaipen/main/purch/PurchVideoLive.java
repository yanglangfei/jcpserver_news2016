package com.jucaipen.main.purch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.main.datautils.RollBackUtil;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLive;
import com.jucaipen.model.VideoLiveSale;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveSaleSer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 *
 *   ������Ƶֱ��
 */
public class PurchVideoLive extends HttpServlet {
	private static final long serialVersionUID = -5454633355323857858L;
	private String result;
	private String ip;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String videoId = request.getParameter("liveId");
		String bills = request.getParameter("bills");
		String days = request.getParameter("days");
		ip=request.getRemoteAddr();
		if(StringUtil.isNotNull(userId)&&StringUtil.isInteger(userId)){
			int uId=Integer.parseInt(userId);
			if(StringUtil.isNotNull(videoId)&&StringUtil.isInteger(videoId)){
				int vId=Integer.parseInt(videoId);
				if(StringUtil.isNotNull(bills)&&StringUtil.isInteger(bills)){
					int b=Integer.parseInt(bills);
					if(StringUtil.isNotNull(days)&&StringUtil.isInteger(days)){
						int d=Integer.parseInt(days);
						result=purchVideoLive(uId,d,vId,b);
					}else{
						result=JsonUtil.getRetMsg(4,"days �����쳣");
					}
				}else{
					result=JsonUtil.getRetMsg(3,"bills �����쳣");
				}
				
			}else{
				result=JsonUtil.getRetMsg(2, "videoId �����쳣");
			}
		}else{
			result=JsonUtil.getRetMsg(1, "userId �����쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String purchVideoLive(int uId, int d, int vId, int b) {
		Account account=AccountSer.findAccountByUserId(uId);
		if(b<=0){
			return JsonUtil.getRetMsg(1,"��ֱ���ݲ�֧�ֹ���");
		}
		
		if(account==null||account.getJucaiBills()<b){
			return JsonUtil.getRetMsg(2,"�۲ƱҲ��㣬����г�ֵ");
		}
		
		VideoLiveSale liveSale = VideoLiveSaleSer.findSaleByUidAndLiveId(uId, vId);
		if(liveSale!=null){
			if(TimeUtils.isLive(liveSale.getStartDate(), liveSale.getEndDate())){
				return JsonUtil.getRetMsg(3, "��ֱ���Ѿ�����");
			}
		}
		
		User user=UserServer.findBaseInfoById(uId);
		
		VideoLive live = VideoLiveServer.getRoomInfo(vId);
		int teacherId = live.getTeacherId();
		FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(teacherId);
		
		
		String startDate = TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		String endDate = TimeUtils.format(TimeUtils.addBaseDay(new Date(), d),
				"yyyy-MM-dd HH:mm:ss");
		
		
		AccountDetail detail = new AccountDetail();
		detail.setDetailMoney(b);
		detail.setDetailType(1);
		detail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detail.setOrderCode("");
		detail.setRemark("����"+teacher.getNickName()+"����ֱ����"+live.getTitle()+"��");
		detail.setState(0);
		detail.setUserId(uId);
		
		
		AccountDetail integeralDetail = new AccountDetail();
		integeralDetail.setDetailMoney(b);
		integeralDetail.setDetailType(0);
		integeralDetail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		integeralDetail.setIsDel(0);
		integeralDetail.setOrderCode("");
		integeralDetail.setRemark("����"+teacher.getNickName()+"����ֱ����"+live.getTitle()+"��,�˻�����+"+b);
		integeralDetail.setState(1);
		integeralDetail.setUserId(uId);
		
		
		VideoLiveSale sale=new VideoLiveSale();
		sale.setEndDate(endDate);
		sale.setFk_liveId(vId);
		sale.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		sale.setIsStop(0);
		sale.setOrderCode("");
		sale.setStartDate(startDate);
		sale.setTeacherId(teacherId);
		sale.setUserId(uId);
		sale.setPayPrice(b);
		sale.setRemark("�û�����(App֧��)");
		
		Contribute contribute = new Contribute();
		contribute.setAllJucaiBills(b);
		contribute.setComType(11);
		contribute.setFk_id(vId);
		contribute.setTeacherId(teacherId);
		contribute.setUserId(uId);
		contribute.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		
		
		SysAccount sysAccount=SysAccountSer.findAccountInfo();
		
		
		SysDetailAccount detailAccount=new SysDetailAccount();
		detailAccount.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailAccount.setIp(ip);
		detailAccount.setIsDel(0);
		detailAccount.setOrderId(0);
		detailAccount.setPrice(b);
		detailAccount.setRecoderType(2);
		detailAccount.setRemark("����"+teacher.getNickName()+"����ֱ����"+live.getTitle()+"��");
		detailAccount.setType(5);
		detailAccount.setUserId(uId);
		
		Rebate rebate=new Rebate();
		rebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		rebate.setType(0);
		rebate.setRebateMoney(b * teacher.getReturnRate());
		rebate.setFromId(uId);
		rebate.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		rebate.setRemark("�û�����ֱ������");
		
		Rebate sysRebate=new Rebate();
		sysRebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		sysRebate.setType(1);
		sysRebate.setRebateMoney(b * (1-teacher.getReturnRate()));
		sysRebate.setFromId(uId);
		sysRebate.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		sysRebate.setRemark("�û�����ֱ������");
		
		int isSuccess=RollBackUtil.getInstance().purchLiveVideo(sale,detail,integeralDetail,b,account,uId,user,contribute,sysAccount,detailAccount,rebate,sysRebate);
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "����ɹ�") : JsonUtil.getRetMsg(1, "����ʧ��");
	}

}
