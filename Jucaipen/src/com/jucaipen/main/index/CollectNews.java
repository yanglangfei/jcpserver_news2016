package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.Favorites;
import com.jucaipen.service.FavoritesSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         �ղء�ȡ���ղ�����
 *         type      0  �۵�       1   ����
 * 
 *         opType ----0 �ղ� -----1 ȡ���ղ�
 * 
 */
@SuppressWarnings("serial")
public class CollectNews extends HttpServlet {
	private Favorites newsFavorites;
	private Favorites nf;
	private String result;
	private int isSuccess;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("type");
		String userId = request.getParameter("userId");
		String newsId = request.getParameter("newsId");
		String opType=request.getParameter("opType");
		if (StringUtil.isInteger(typeId)) {
			int type = Integer.parseInt(typeId);
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId>0) {
					if (StringUtil.isInteger(newsId)) {
						int nId = Integer.parseInt(newsId);
						if(StringUtil.isNotNull(opType)&&StringUtil.isInteger(opType)){
							int opId=Integer.parseInt(opType);
							if(type==0){
								//�۵��ղ�ȡ��
								result=initIdea(opId,uId,nId);
							}else{
								//�����ղ�ȡ��
								result=initNews(opId,uId,nId);
							}
						}else{
							result=JsonUtil.getRetMsg(7, "opType �����쳣");
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
		out.print(result);
		out.flush();
		out.close();
	}

	private String initNews(int opType,int uId,int nId) {
		//�����ղ�  ȡ���ղ�
		if (opType == 0) {
			// �ղ�
			nf = newsIsCollect(uId, nId);
			if (nf != null) {
				 return JsonUtil.getRetMsg(1, "�������ѱ��ղ�");
			} else {
				insertNewsCollect(uId, nId);
				if (isSuccess == 1) {
					return JsonUtil.getRetMsg(0, "�����ղسɹ�");
				} else {
					return JsonUtil.getRetMsg(2, "�����ղ�ʧ��");
				}
			}
		} else {
			// ȡ�� �ղ�
			nf = newsIsCollect(uId, nId);
			if (nf != null) {
				cancellNewsCollect(uId, nId);
				if (isSuccess == 1) {
					return JsonUtil.getRetMsg(0, "�����ղ�ȡ���ɹ�");
				} else {
					return JsonUtil.getRetMsg(2, "�����ղ�ȡ��ʧ��");
				}
			} else {
				return JsonUtil.getRetMsg(1, "�����Ż�δ�ղ�");
			}
		}
	}

	private String initIdea(int opId,int uId,int nId) {
		//�۵��ղ�  ȡ���ղ�
		return null;
	}

	private void cancellNewsCollect(int uId, int nId) {
		// ȡ�������ղ�
		isSuccess = FavoritesSer.cancelNews(uId, nId);
	}

	private Favorites newsIsCollect(int uId, int nId) {
		// �ж������Ƿ��ղ�
		return FavoritesSer.findNewsIsCollect(uId, nId);

	}

	private void insertNewsCollect(int uId, int nId) {
		// �����ղ�
		newsFavorites = new Favorites();
		newsFavorites.setFk_Id(nId);
		newsFavorites.setuId(uId);
		newsFavorites.setDate(sdf.format(new Date()));
		isSuccess = FavoritesSer.insertNews(uId, newsFavorites);

	}

}
