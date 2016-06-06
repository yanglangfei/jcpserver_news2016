package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Favorites;
import com.jucaipen.service.FavoritesSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         �ղء�ȡ���ղ����� type 0 ��Ƶ 1 ֪ʶ
 * 
 *         opType ----0 �ղ� -----1 ȡ���ղ�
 * 
 */
@SuppressWarnings("serial")
public class CollectNews extends HttpServlet {
	private Favorites newsFavorites;
	private Favorites nf;
	private String result;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String typeId = request.getParameter("type");
			String userId = request.getParameter("userId");
			String newsId = request.getParameter("newsId");
			String opType = request.getParameter("opType");
			if (StringUtil.isInteger(typeId)) {
				int type = Integer.parseInt(typeId);
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						if (StringUtil.isInteger(newsId)) {
							int nId = Integer.parseInt(newsId);
							if (StringUtil.isNotNull(opType)
									&& StringUtil.isInteger(opType)) {
								int opId = Integer.parseInt(opType);
								result = initIdea(opId, uId, nId,type);
							} else {
								result = JsonUtil.getRetMsg(7, "opType �����쳣");
							}
						} else {
							result = JsonUtil.getRetMsg(5, "�û�id������ʽ���쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(6, "��ǰ�û���û��¼");
					}

				} else {
					result = JsonUtil.getRetMsg(4, "�û�id�������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(3, "���Ͳ������ָ�ʽ���쳣");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}


	private String initIdea(int opId, int uId, int nId, int type) {
		boolean isCollect=newsIsCollect(uId,nId);
		if(type==0){
			//��Ƶ
			if(opId==0){
				//�ղ�
				if(isCollect){
					return JsonUtil.getRetMsg(1,"��Ƶ�Ѿ��ղ�");
				}else{
					cancellNewsCollect(uId, nId);
				}
			}else{
				//ȡ��
				if(!isCollect){
					return JsonUtil.getRetMsg(1,"��Ƶ��û�ղ�");
				}
			}
		}else{
			//֪ʶ
			if(opId==0){
				//�ղ�
				if(isCollect){
					return JsonUtil.getRetMsg(1,"֪ʶ�Ѿ��ղ�");
				}else{
					
				}
			}else{
				//ȡ��
				if(!isCollect){
					return JsonUtil.getRetMsg(1,"֪ʶ��û�ղ�");
				}else{
					
				}
			}
		}
		return null;
	}

	private void cancellNewsCollect(int uId, int nId) {
		// ȡ�������ղ�
		int isSuccess = FavoritesSer.cancelNews(uId, nId);
		
	}

	private boolean newsIsCollect(int uId, int nId) {
		// �ж������Ƿ��ղ�
		Favorites favour = FavoritesSer.findNewsIsCollect(uId, nId);
		return favour!=null ? true : false;

	}

	private void insertNewsCollect(int uId, int nId) {
		// �����ղ�
		newsFavorites = new Favorites();
		newsFavorites.setFk_Id(nId);
		newsFavorites.setuId(uId);
		newsFavorites.setDate(sdf.format(new Date()));
		int isSuccess = FavoritesSer.insertNews(uId, newsFavorites);

	}

}
