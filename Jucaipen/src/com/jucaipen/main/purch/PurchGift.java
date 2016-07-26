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
import com.jucaipen.model.Gifts;
import com.jucaipen.model.MyPresent;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.GiftsSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;
/**
 * @author Administrator
 *
 *  ������Ʒ
 */
@SuppressWarnings("serial")
public class PurchGift extends HttpServlet {
	private String result;
	private String ip;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ip=request.getRemoteAddr();
		String userId=request.getParameter("userId");
		String presentId=request.getParameter("presentId");
		String giftNum=request.getParameter("giftNum");
		String bills=request.getParameter("bills");
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					if(StringUtil.isNotNull(presentId)&&StringUtil.isInteger(presentId)){
						int pId=Integer.parseInt(presentId);
						if(StringUtil.isNotNull(giftNum)&&StringUtil.isInteger(giftNum)){
							int num=Integer.parseInt(giftNum);
							if(StringUtil.isNotNull(bills)&&StringUtil.isInteger(bills)){
								int b=Integer.parseInt(bills);
								result=purchGifts(pId,num,uId,b);
							}
						}else{
							result=JsonUtil.getRetMsg(5,"giftNum �����쳣");
						}
					}else{
						result=JsonUtil.getRetMsg(4,"presentId �����쳣");
					}
				}else{
					result=JsonUtil.getRetMsg(3, "�û���û��¼");
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
	private String purchGifts(int pId, int num, int uId, int b) {
		//������Ʒ
		
		//1���鿴�۲Ʊ��Ƿ��㹻
		User user=UserServer.findBaseInfoById(uId);
		Account a=AccountSer.findAccountByUserId(uId);
		if(a==null||a.getJucaiBills()<b){
			return JsonUtil.getRetMsg(1, "�۲Ʊ�����");
		}
		
		Gifts gift=GiftsSer.findGiftById(pId);
		
		MyPresent present=new MyPresent();
		present.setPresentId(pId);
		present.setPresentNum(num);
		present.setUserId(uId);
		
		AccountDetail detail=new AccountDetail();
		detail.setDetailMoney(b);
		detail.setDetailType(1);
		detail.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detail.setOrderCode("");
		detail.setRemark("����"+gift.getTitle()+"����Ʒ��"+num+"����");
		detail.setState(2);
		detail.setUserId(uId);
		
		
		
		AccountDetail detailInteger=new AccountDetail();
		detailInteger.setDetailMoney(b);
		detailInteger.setDetailType(0);
		detailInteger.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detailInteger.setIsDel(0);
		detailInteger.setOrderCode("");
		detailInteger.setRemark("����"+gift.getTitle()+"����Ʒ��"+num+"�������˻�����+"+b);
		detailInteger.setState(1);
		detailInteger.setUserId(uId);
		
		
		
		SysAccount sysAccount=SysAccountSer.findAccountInfo();
		
		SysDetailAccount sysDetailAccount=new SysDetailAccount();
		sysDetailAccount.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		sysDetailAccount.setIsDel(0);
		sysDetailAccount.setIp(ip);
		sysDetailAccount.setOrderId(0);
		sysDetailAccount.setPrice(b);
		sysDetailAccount.setRecoderType(2);
		sysDetailAccount.setRemark("����"+gift.getTitle()+"����Ʒ��"+num+"����");
		sysDetailAccount.setUserId(uId);
		sysDetailAccount.setType(4);
		
		
		int isSuccess = RollBackUtil.purchGifts(present,a,b,uId,detail,detailInteger,user,sysAccount,sysDetailAccount);
		
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "��Ʒ����ɹ�") : JsonUtil.getRetMsg(1,"��Ʒ����ʧ��");
	}

}
