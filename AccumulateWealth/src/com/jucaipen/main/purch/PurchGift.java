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
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Gifts;
import com.jucaipen.model.MyPresent;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.GiftsSer;
import com.jucaipen.service.MyPresentSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         购买礼品
 */
public class PurchGift extends HttpServlet {
	private static final long serialVersionUID = -8389392305908385567L;
	private String result;
	private String ip;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ip = request.getRemoteAddr();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String userId = request.getParameter("userId");
			String presentId = request.getParameter("presentId");
			String giftNum = request.getParameter("giftNum");
			String bills = request.getParameter("bills");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						if (StringUtil.isNotNull(presentId)
								&& StringUtil.isInteger(presentId)) {
							int pId = Integer.parseInt(presentId);
							if (StringUtil.isNotNull(giftNum)
									&& StringUtil.isInteger(giftNum)) {
								int num = Integer.parseInt(giftNum);
								if (StringUtil.isNotNull(bills)
										&& StringUtil.isInteger(bills)) {
									int b = Integer.parseInt(bills);
									result = purchGifts(pId, num, uId, b);
								} else {
									result = JsonUtil
											.getRetMsg(6, "bills 参数异常");
								}
							} else {
								result = JsonUtil.getRetMsg(5, "giftNum 参数异常");
							}
						} else {
							result = JsonUtil.getRetMsg(4, "presentId 参数异常");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "用户还没登录");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "userId 参数数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "userId 参数不能为空");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String purchGifts(int pId, int num, int uId, int b) {
		// 购买礼品
		// 1、查看聚财币是否足够
		User user = UserServer.findBaseInfoById(uId);
		Account a = AccountSer.findAccountByUserId(uId);
		if(b<=0){
			return JsonUtil.getRetMsg(6,"暂不支持购买");
		}
		
		
		if (a == null || a.getJucaiBills() < b) {
			return JsonUtil.getRetMsg(8, "聚财币余额不足");
		}

		Gifts gift = GiftsSer.findGiftById(pId);
		MyPresent presentExit = MyPresentSer.findParentByUid(uId, pId);

		MyPresent present = new MyPresent();
		present.setPresentId(pId);
		present.setPresentNum(num);
		present.setUserId(uId);
		AccountDetail detail = new AccountDetail();
		detail.setDetailMoney(b);
		detail.setDetailType(1);
		detail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detail.setOrderCode("");
		detail.setRemark("购买【" + gift.getTitle() + "】礼品【" + num + "】个");
		detail.setState(2);
		detail.setUserId(uId);

		AccountDetail detailInteger = new AccountDetail();
		detailInteger.setDetailMoney(b);
		detailInteger.setDetailType(0);
		detailInteger.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailInteger.setIsDel(0);
		detailInteger.setOrderCode("");
		detailInteger.setRemark("购买【" + gift.getTitle() + "】礼品【" + num
				+ "】个，账户积分+" + b);
		detailInteger.setState(1);
		detailInteger.setUserId(uId);

		SysAccount sysAccount = SysAccountSer.findAccountInfo();

		SysDetailAccount sysDetailAccount = new SysDetailAccount();
		sysDetailAccount.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysDetailAccount.setIsDel(0);
		sysDetailAccount.setIp(ip);
		sysDetailAccount.setOrderId(0);
		sysDetailAccount.setPrice(b);
		sysDetailAccount.setRecoderType(2);
		sysDetailAccount.setRemark("购买【" + gift.getTitle() + "】礼品【" + num
				+ "】个");
		sysDetailAccount.setUserId(uId);
		sysDetailAccount.setType(4);

		int isSuccess = RollBackUtil.getInstance().purchGifts(presentExit, present, a, b,
				uId, detail, detailInteger, user, sysAccount, sysDetailAccount);

		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "礼品购买成功") : JsonUtil
				.getRetMsg(1, "礼品购买失败");
	}

}
