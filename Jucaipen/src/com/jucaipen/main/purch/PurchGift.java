package com.jucaipen.main.purch;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					if(StringUtil.isNotNull(presentId)&&StringUtil.isInteger(presentId)){
						int pId=Integer.parseInt(presentId);
						if(StringUtil.isNotNull(giftNum)&&StringUtil.isInteger(giftNum)){
							int num=Integer.parseInt(giftNum);
							result=purchGifts(pId,num,uId);
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
	private String purchGifts(int pId, int num, int uId) {
		//购买礼品
		
		//1、查看聚财币是否足够
		//2、增加个人礼品信息
		//3、减少个人聚财币信息
		//4、积分处理
		
		
		
		return null;
	}

}
