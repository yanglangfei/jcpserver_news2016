package com.jucaipen.main.play;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.service.SharkDetailServer;
import com.jucaipen.service.SharkInfoServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;
/**
 * @author ���ʷ�
 *2017��1��23��  ����1:09:43
 *    ��ȡҡһҡ��Ϣ
 */
public class SharkInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_COUNT=1;
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		if(StringUtil.isNotNull(userId)&&StringUtil.isInteger(userId)){
			int uId=Integer.parseInt(userId);
			if(uId>0){
				String date = TimeUtils.format(new Date(), "yyyy-MM-dd");
				com.jucaipen.model.SharkInfo info=SharkInfoServer.getSharkByIsEnd(date);
				if(info!=null){
					if(TimeUtils.isLive(info.getStartDate(), info.getEndDate())){
						if(checkCount(uId)){
							//���ڽ���
							result=JsonUtil.getSharkResult(0,"���ڽ���",1);
						}else{
							//����ȡ
							result=JsonUtil.getSharkResult(0,"�����Ѿ���ȡ",2);
						}
					}else{
						if(TimeUtils.isDateBefore(info.getStartDate())){
							//δ��ʼ
							result=JsonUtil.getSharkResult(0,"���δ��ʼ",3);
						}else{
							//�ѽ���
							result=JsonUtil.getSharkResult(0,"��Ѿ�����",4);
						}
					}
				}else{
					result=JsonUtil.getSharkResult(0,"���δ��ʼ",3);
				}
			}else{
				result=JsonUtil.getSharkResult(2,"���ȵ�¼",-1);
			}
		}else{
			result=JsonUtil.getSharkResult(1,"userId �����쳣",-1);
		}
		out.print(result);
		out.flush();
		out.close();
	}
	
	/**
	 * @param uId
	 * @return  ҡһҡ�����Ƿ�����
	 */
	private boolean checkCount(int uId) {
		// ��ȡ��ǰ�û�ҡһҡ����
		int count = SharkDetailServer.getSharkCount(uId);
		return count<MAX_COUNT;
	}

}
