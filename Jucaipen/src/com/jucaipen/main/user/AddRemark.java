package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         �������----�ظ����� 
 *         typeId -----����id 0 �������ۣ��ظ� 1 ��Ƶ���ۣ��ظ�    2  �۵����� �ظ�
 *         
 *         ParentId    0  ����      ��0   �ظ�
 */ 
@SuppressWarnings("serial")
public class AddRemark extends HttpServlet {
	//private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	private Comment newsComment;
	private int isSuccess;
	private String result;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");     
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent=request.getParameter("User-Agent");
		ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);
		int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			String typeId = request.getParameter("typeId");
			String userId = request.getParameter("userId");
			String classId = request.getParameter("classId"); 
			String newsId = request.getParameter("newsId");
			String bodys = request.getParameter("bodys");
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if(uId>0){
					if (StringUtil.isInteger(classId)) {
						int cId = Integer.parseInt(classId);
						if (StringUtil.isInteger(newsId)) {
							int nId = Integer.parseInt(newsId);
							if (StringUtil.isNotNull(bodys)) {
								if (StringUtil.isInteger(typeId)) {
									int type = Integer.parseInt(typeId);
									if (type == 0 || type == 1||type==2) {
										insertRemark(uId, cId, nId, bodys,type);
										if (isSuccess == 1) {
											result = JsonUtil.getRetMsg(0, "���۷���ɹ�");
										} else {
											result = JsonUtil.getRetMsg(1, "���۷���ʧ��");
										}
									} else {
										result = JsonUtil.getRetMsg(4,
												"����typeId����Ϊ0����1");
									}
								} else {
									result = JsonUtil.getRetMsg(5, "typeId�������ָ�ʽ���쳣");
								}
							}
						} else {
							result = JsonUtil.getRetMsg(3, "����id�������ָ�ʽ���쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(2, "���ŷ���id�������ָ�ʽ���쳣");
					}
					
				}else {
					result=JsonUtil.getRetMsg(7,"��ǰ�û���û��¼");
				}
			} else {
				result = JsonUtil.getRetMsg(6, "�û�id�������ָ�ʽ���쳣");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param uId
	 * @param cId
	 * @param nId
	 * @param bodys
	 * 
	 *            �������
	 */
	private void insertRemark(int uId, int cId, int nId, String bodys,int commType) {
		
	}

}
