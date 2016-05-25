package com.jucaipen.base;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Position;
import com.jucaipen.service.PositionSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *  ��ȡ��λ��Ϣ
 */
@SuppressWarnings("serial")
public class QuerryPosition extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					result=initPosition();
				}else{
					result=JsonUtil.getRetMsg(3,"���û���û��¼");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"userId ���ָ�ʽ���쳣");
			}
			
		}else{
			result=JsonUtil.getRetMsg(1,"userId ��������Ϊ��");
		}
		
		out.println(result);
		out.flush();
		out.close();
	}
	
	private String initPosition() {
		//��ʼ����λ��Ϣ
		List<Position> positions = PositionSer.findAll();
		return JsonUtil.getPositionlist(positions);
	}

}
