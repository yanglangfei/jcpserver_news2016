package com.jucaipen.main.index.famous;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.jucaipen.model.Answer;
import com.jucaipen.model.Ask;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.TxtLiveDetails;
import com.jucaipen.model.User;
import com.jucaipen.model.Video;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.AnswerSer;
import com.jucaipen.service.AskSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.TxtLiveDetaileSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *     type    (0   观点)   (1   问答)   (2   文字直播)   (3  视频直播)
 */
@SuppressWarnings("serial")
public class QuerryTeacherIdea extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String isIndex=request.getParameter("isIndex");
		String teacherId=request.getParameter("teacherId");
		String typeId=request.getParameter("typeId");
		String page=request.getParameter("page");
		if(StringUtil.isNotNull(teacherId)){
			if(StringUtil.isInteger(teacherId)){
				int tId=Integer.parseInt(teacherId);
				if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
					int type=Integer.parseInt(typeId);
					if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
						int p=Integer.parseInt(page);
						if(StringUtil.isNotNull(isIndex)&&StringUtil.isInteger(isIndex)){
							int index=Integer.parseInt(isIndex);
							result=initTeacherIdeaData(tId,type,p,index);
						}else{
							result=JsonUtil.getRetMsg(5,"isIndex 参数异常");
						}
					}else{
						result=JsonUtil.getRetMsg(4,"page 参数异常");
					}
				}else{
					result=JsonUtil.getRetMsg(3,"typeId 参数异常");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"teacherId 参数数字格式化异常");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"teacherId 参数不能为空");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initTeacherIdeaData(int tId, int type, int p,int isIndex) {
		// 初始化讲师热门观点   问答   文字直播   直播信息
		if(type==0){
			//热门观点
			List<HotIdea> ideas;
			if(isIndex==0){
				//首页
				ideas=HotIdeaServ.findLastIdeaByTeacherId(tId, 3);
			}else{
				ideas = HotIdeaServ.findIdeaByTeacherId(tId, p);
			}
			return JsonUtil.getIdeaList(ideas);
		}else if(type==1){
			//问答
			 List<Ask> asks;
			 if(isIndex==0){
				 //首页
				 asks=AskSer.findLastByTeacherId(tId,3);
			 }else {
				  asks = AskSer.findAskByTeacherId(tId, p);
			}
			 
			 List<User> users=new ArrayList<User>();
			 for(Ask ask : asks){
				 int uId=ask.getUserId();
				 User user=UserServer.findUserById(uId);
				 int isReply=ask.getIsReply();
				 List<Answer> answer=AnswerSer.findAnswerByAskId(ask.getId());
				 if(answer!=null&&isReply==2&&answer.size()>0){
					 ask.setReplyBody(answer.get(0).getAnswerBody());
				 }
				 if(user==null){
					 user=new User();
				 }
				 users.add(user);
			 }
			 return JsonUtil.getAskList(asks, users);
		}else if(type==2){
			//文字直播
			List<TxtLiveDetails> txtDetails;
			List<TextLive> txts = TxtLiveSer.findTxtLiveByTeacherIdAndLast(tId, 1);
			if(txts!=null&&txts.size()>0){
				TextLive txt = txts.get(0);
				if(isIndex==0){
					//首页
					txtDetails=TxtLiveDetaileSer.findLaseDetaileByLiveId(txt.getId(), 3,0);
				}else{
					txtDetails = TxtLiveDetaileSer.findTextDetaileByLiveId(txt.getId(),0);
				}
				return JsonUtil.getTxtLiveByTeacherId(txt,txtDetails);
			}
			return new JsonArray().toString();
		}else{
			//直播
			List<VideoLive> lives = VideoLiveServer.findLiveBytId(tId);
			List<Video> videos = VideoServer.findVideoByTeacherId(tId, p);
			return JsonUtil.getLive(lives,videos);
		}
	}

}
