package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Account;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.IdeaSale;
import com.jucaipen.model.JcpNews;
import com.jucaipen.model.SiteConfig;
import com.jucaipen.model.Tactics;
import com.jucaipen.model.TacticsDetails;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.IdeaSaleServer;
import com.jucaipen.service.JcpNewsSer;
import com.jucaipen.service.ResourceFromServer;
import com.jucaipen.service.SiteConfigSer;
import com.jucaipen.service.TacticsDetailSer;
import com.jucaipen.service.TacticsSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ������ϸ��Ϣ       type    
 *                        (0  ������ϸ��Ϣ)    
 *                        ��1   �۵���ϸ��Ϣ��  
 *                        (2  ս����ϸ��Ϣ)
 */
@SuppressWarnings("serial")
public class NewsDetail extends HttpServlet {
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
			String typeId=request.getParameter("typeId");
			String newsId = request.getParameter("newsId");
			String page=request.getParameter("page");
			String userId=request.getParameter("userId");
			if (StringUtil.isNotNull(newsId)) {
				if (StringUtil.isInteger(newsId)) {
					int id = Integer.parseInt(newsId);
					if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
						int type=Integer.parseInt(typeId);
						if(StringUtil.isNotNull(userId)&&StringUtil.isInteger(userId)){
							int uId=Integer.parseInt(userId);
							result=initNewsDetail(id,type,page,uId);
						}else{
							result=JsonUtil.getRetMsg(4,"userId �����쳣");
						}
					}else{
						result=JsonUtil.getRetMsg(3,"typeId �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "newsId �������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "newsId ��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initNewsDetail(int id, int type, String page, int uId) {
		// ��ʼ��������ϸ��Ϣ
		if(type==0){
			//������ϸ��Ϣ
			JcpNews news = JcpNewsSer.findNews(id);
			int fromId=news.getComeFrom();
			String from=ResourceFromServer.getRSources(fromId);
			news.setFrom(from);
			initNewsHits(id,news.getHits(),news.getXnHits());
			return JsonUtil.getNewsDetails(news);
		}else if(type==1){
			//�۵���ϸ��Ϣ
			int isPurch=1;
			int ownJucaiBills=0;
			HotIdea idea = HotIdeaServ.findIdeaById(id);
			int tId=idea.getTeacherId();
			FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(tId);
			if(uId>0){
				Account account=AccountSer.findAccountByUserId(uId);
				IdeaSale sale = IdeaSaleServer.findTxtLiveSaleByUiDAndLiveId(uId, id);
				if(sale!=null){
					isPurch=0;
				}
				if(account!=null){
					ownJucaiBills=account.getJucaiBills();
				}
			}
			if(teacher==null){
				teacher=new FamousTeacher();
			}
			idea.setTeacherFace(teacher.getHeadFace());
			idea.setTeacherName(teacher.getNickName());
			idea.setIsPurch(isPurch);
			idea.setOwnJucaiBills(ownJucaiBills);
			initIdeaHits(tId,id,idea.getHits(),idea.getXnHits(),teacher.getArticleReadCount(),teacher.getXnArticleReadNum());
			return JsonUtil.getIdeaDetails(idea);
		}else{
			//��ȡս���б�
			if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
				int p=Integer.parseInt(page);
				Tactics tactics=TacticsSer.findTacticsById(id);
				int teacherId=tactics.getTeacherId();
				FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(teacherId);
				List<TacticsDetails> detailsArray=TacticsDetailSer.findDetailsByFkId(id,p);
				return JsonUtil.getTacticsDetailInfo(detailsArray,teacher);
			}else{
				return JsonUtil.getRetMsg(7,"page �����쳣");
			}
		}
		
	}

	/**
	 * @param id
	 * @param hits
	 * @param xnHits  �������ŵ����
	 */
	private void initNewsHits(int id, int hits, int xnHits) {
		SiteConfig config=SiteConfigSer.findSiteConfig();
		JcpNewsSer.upDateHits(xnHits+config.getNewsMom(),hits+1,id);
	}

	/**
	 * @param id
	 *   ���¹۵�����
	 * @param hits 
	 */
	private void initIdeaHits(int tId,int id, int hits,int xnHits,int ideaReadNum,int xnIdeaReadNum) {
		SiteConfig config = SiteConfigSer.findSiteConfig();
		HotIdeaServ.addHit(id, hits+1,xnHits+config.getNewsMom());
		FamousTeacherSer.updateIdeaReadNum(tId,ideaReadNum+1, xnIdeaReadNum+config.getNewsMom());
	}

}
