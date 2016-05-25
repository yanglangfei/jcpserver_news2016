package com.jucaipen.main.index;

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
 *         ��ע��ʦ   opType    0 ��ӹ�ע
 *                          1 ȡ����ע
 * 
 */
@SuppressWarnings("serial")
public class Attention extends HttpServlet {
	private String result;


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8")  ;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String opType=request.getParameter("opType");
		String userId = request.getParameter("userId");
		String teacherId = request.getParameter("teacherId");
		if(StringUtil.isInteger(opType)){
			int type=Integer.parseInt(opType);
			if (StringUtil.isInteger(userId)) {
				// �û�id���ָ�ʽ������
				int uId = Integer.parseInt(userId);
				if (StringUtil.isInteger(teacherId)) {
					int tId = Integer.parseInt(teacherId);
					if(type==0){
						//��ӹ�ע
						checkIsAttention(uId,tId);
					}else if(type==1){
						checkIsAttention(uId,tId);
						
					}else {
						result=JsonUtil.getRetMsg(5, "����id������Ҫ��");
					}
				
				} else {
					result = JsonUtil.getRetMsg(1, "��ʦid���ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "�û�id���ָ�ʽ���쳣");
			}
			
		}else {
			result=JsonUtil.getRetMsg(4,"����id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void  cancelAttention(int uId, int tId) {
		// ȡ����ע
		
	}

	private void checkIsAttention(int uId, int tId) {
		//���֮ǰ�Ƿ��ע��
		
	}

	private void insertAttention(int uId, int tId) {

	}

}
