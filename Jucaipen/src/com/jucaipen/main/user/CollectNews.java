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
 *         收藏、取消收藏新闻 type 0 视频 1 知识
 * 
 *         opType ----0 收藏 -----1 取消收藏
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
								result = JsonUtil.getRetMsg(7, "opType 参数异常");
							}
						} else {
							result = JsonUtil.getRetMsg(5, "用户id参数格式化异常");
						}
					} else {
						result = JsonUtil.getRetMsg(6, "当前用户还没登录");
					}

				} else {
					result = JsonUtil.getRetMsg(4, "用户id参数数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(3, "类型参数数字格式化异常");
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
			//视频
			if(opId==0){
				//收藏
				if(isCollect){
					return JsonUtil.getRetMsg(1,"视频已经收藏");
				}else{
					cancellNewsCollect(uId, nId);
				}
			}else{
				//取消
				if(!isCollect){
					return JsonUtil.getRetMsg(1,"视频还没收藏");
				}
			}
		}else{
			//知识
			if(opId==0){
				//收藏
				if(isCollect){
					return JsonUtil.getRetMsg(1,"知识已经收藏");
				}else{
					
				}
			}else{
				//取消
				if(!isCollect){
					return JsonUtil.getRetMsg(1,"知识还没收藏");
				}else{
					
				}
			}
		}
		return null;
	}

	private void cancellNewsCollect(int uId, int nId) {
		// 取消新闻收藏
		int isSuccess = FavoritesSer.cancelNews(uId, nId);
		
	}

	private boolean newsIsCollect(int uId, int nId) {
		// 判断新闻是否收藏
		Favorites favour = FavoritesSer.findNewsIsCollect(uId, nId);
		return favour!=null ? true : false;

	}

	private void insertNewsCollect(int uId, int nId) {
		// 新闻收藏
		newsFavorites = new Favorites();
		newsFavorites.setFk_Id(nId);
		newsFavorites.setuId(uId);
		newsFavorites.setDate(sdf.format(new Date()));
		int isSuccess = FavoritesSer.insertNews(uId, newsFavorites);

	}

}
