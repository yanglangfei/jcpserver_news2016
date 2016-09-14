package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Fans;
import com.jucaipen.model.TextLive;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.FansSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ��ʦ��Ϣ 
 *             isIndex 0 ��ҳ�Ƽ���ʦ 
 *                     1 ȫ����ʦ�б� 
 */
@SuppressWarnings("serial")
public class QuerryTeacher extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String isIndex = request.getParameter("isIndex");
			String userId=request.getParameter("userId");
			if (StringUtil.isNotNull(isIndex)) {
				if (StringUtil.isInteger(isIndex)) {
					int index = Integer.parseInt(isIndex);
					if(StringUtil.isNotNull(userId)){
						if(StringUtil.isInteger(userId)){
							int uId=Integer.parseInt(userId);
							if (index == 0) {
								// ��ҳ�Ƽ���ʦ
								result=initIndexData(uId);
							} else {
								// ȫ����ʦ�б�
								String page = request.getParameter("page");
								if (StringUtil.isNotNull(page)
										&& StringUtil.isInteger(page)) {
									int p = Integer.parseInt(page);
									result=initAllData(p,uId);
								} else {
									result = JsonUtil.getRetMsg(3, "page��������");
								}
							}
						}else{
							result=JsonUtil.getRetMsg(4,"userId �������ָ�ʽ���쳣");
						}
					}else{
						result=JsonUtil.getRetMsg(4,"userId ��������Ϊ��");
					}
					
				} else {
					result = JsonUtil.getRetMsg(2, "isIndex�������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "isIndex��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initAllData(int page,int uId) {
		// ��ʼ��ȫ����ʦ��Ϣ
		List<FamousTeacher> teachers = FamousTeacherSer.findAllFamousTeacher(page);
		if(teachers!=null){
			for(FamousTeacher teacher : teachers){
				int tId=teacher.getId();
				List<TextLive> txt = TxtLiveSer.findTxtLiveByTeacherIdAndLast(tId, 1);
				if(txt!=null&&txt.size()>0){
					teacher.setLiveIsEnd(txt.get(0).getIsEnd());
				}
			}
		}
		return JsonUtil.getAllFamousTeacherList(teachers);
	}

	private String initIndexData(int uId) {
		// ��ʼ����ҳ��ʦ�Ƽ��б���Ϣ
		List<FamousTeacher> teachers = FamousTeacherSer.findFamousTeacherByIndex(3);
		List<Integer>  isAttentions=new ArrayList<Integer>();
		if(teachers!=null){
			for(FamousTeacher teacher : teachers){
				int tId=teacher.getId();
				Fans fan=FansSer.findIsFans(uId, tId);
				if(fan!=null){
					isAttentions.add(0);
				}else{
					isAttentions.add(1);
				}
			}
		}
		return JsonUtil.getFamousTeacherList(teachers,isAttentions);
	}

}
