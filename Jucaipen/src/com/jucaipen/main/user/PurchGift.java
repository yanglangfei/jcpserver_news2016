package com.jucaipen.main.user;
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
 *  ������Ʒ
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
	private String purchGifts(int pId, int num, int uId) {
		//������Ʒ
		
		//1���鿴�۲Ʊ��Ƿ��㹻
		//2�����Ӹ�����Ʒ��Ϣ
		//3�����ٸ��˾۲Ʊ���Ϣ
		//4�����ִ���
		
		
		
		return null;
	}

}
