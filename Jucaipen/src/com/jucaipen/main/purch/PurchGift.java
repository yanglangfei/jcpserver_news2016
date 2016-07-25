package com.jucaipen.main.purch;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.main.datautils.RollBackUtil;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.MyPresent;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *
 *  购买礼品
 */
@SuppressWarnings("serial")
public class PurchGift extends HttpServlet {
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
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
							result=JsonUtil.getRetMsg(5,"giftNum 参数异常");
						}
					}else{
						result=JsonUtil.getRetMsg(4,"presentId 参数异常");
					}
				}else{
					result=JsonUtil.getRetMsg(3, "用户还没登录");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"userId 参数数字格式化异常");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"userId 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}
	private String purchGifts(int pId, int num, int uId, int b) {
		//购买礼品
		
		//1、查看聚财币是否足够
		User user=UserServer.findBaseInfoById(uId);
		Account a=AccountSer.findAccountByUserId(uId);
		if(a==null||a.getJucaiBills()<b){
			return JsonUtil.getRetMsg(1, "聚财币余额不足");
		}
		
		MyPresent present=new MyPresent();
		
		AccountDetail detail=new AccountDetail();
		
		AccountDetail detailInteger=new AccountDetail();
		
		Contribute contribute=new Contribute();
		
		SysAccount sysAccount=SysAccountSer.findAccountInfo();
		
		SysDetailAccount sysDetailAccount=new SysDetailAccount();
		
		
		
		int isSuccess = RollBackUtil.purchGifts(present,a,b,uId,detail,detailInteger,contribute,user,sysAccount,sysDetailAccount);
		
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "礼品购买成功") : JsonUtil.getRetMsg(1,"礼品购买失败");
	}

}
