package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;

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
 *  ��ȡ�ղ�״̬    0   ��Ƶ�ղ�״̬      
 *             1    ֪ʶ�ղ�״̬
 */
@SuppressWarnings("serial")
public class QuerryIsCollect extends HttpServlet {
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId=request.getParameter("typeId");
		String userId=request.getParameter("userId");
		String fkId=request.getParameter("fkId");
		if(StringUtil.isNotNull(userId)&&StringUtil.isInteger(userId)){
			int uId=Integer.parseInt(userId);
			if(uId>0){
				if(StringUtil.isNotNull(fkId)&&StringUtil.isInteger(fkId)){
					int fId=Integer.parseInt(fkId);
					if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
						int type=Integer.parseInt(typeId);
						result=initCollectState(uId,fId,type);
					}
				}
			}
		}else{
			result=JsonUtil.getRetMsg(3,"userId �����쳣");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initCollectState(int uId, int fId, int type) {
		//1Ϊ�ղ���Ƶ 2Ϊ�ղ�֪ʶ
		if(type==0){
			//��Ƶ�ղ�״̬
			Favorites favourate = FavoritesSer.findNewsIsCollect(uId, fId, 1);
			return favourate!=null ?JsonUtil.getRetMsg(0, "��Ƶ�Ѿ��ղ�") : JsonUtil.getRetMsg(1,"��Ƶ��û�ղ�");
		}else{
			//֪ʶ�ղ�״̬
			Favorites favourate = FavoritesSer.findNewsIsCollect(uId, fId, 2);
			return favourate!=null ?JsonUtil.getRetMsg(0, "֪ʶ�Ѿ��ղ�") : JsonUtil.getRetMsg(1,"֪ʶ��û�ղ�");
		}
	}

}
