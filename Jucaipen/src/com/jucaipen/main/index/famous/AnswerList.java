package com.jucaipen.main.index.famous;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonArray;
import com.jucaipen.model.Answer;
import com.jucaipen.model.Ask;
import com.jucaipen.service.AnswerSer;
import com.jucaipen.service.AskSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
public class AnswerList extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String askId = request.getParameter("askId");
		String askUserId = request.getParameter("askUserId");
		if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (StringUtil.isNotNull(askUserId)
					&& StringUtil.isInteger(askUserId)) {
				int askUid = Integer.parseInt(askUserId);
				if (StringUtil.isNotNull(askId) && StringUtil.isInteger(askId)) {
					int aId = Integer.parseInt(askId);
					result = initQuestion(uId, aId, askUid);
				} else {
					result = JsonUtil.getRetMsg(3, "askId 参数异常");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "askUserId 参数异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId 参数异常");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initQuestion(int uId, int aId, int askUid) {
		if (askUid == uId) {
			List<Answer> reAns;
			List<Ask> reAsks;    
			// 当前用户是提问者 ，全部显示信息
			//1 获取所有的主回复
			List<Answer> mainAnswers=AnswerSer.findAnswerByAskId(aId);
			for (Answer answer : mainAnswers) {
				//追问主回复
                 reAsks=AskSer.findAskByParentId(answer.getId());
                for(Ask ask : reAsks){
                	int isReply=ask.getIsReply();
                	if(isReply==2){
                		//回复追问
        				reAns = AnswerSer.findAnswerByAskId(ask.getId());
                	}
                }
			}
			return null;

		} else {
			List<Answer> answers = AnswerSer.findAnswerByAskId(aId);
			return JsonUtil.getAnswerList(answers);

		}

	}
	
	
    //  主回复
	public void recleAnswer(List<Answer> answers){
		for(Answer answer : answers){
		   // 追问主回复
			List<Ask> asks=AskSer.findAskByParentId(answer.getId());
			JsonArray reAsk=new JsonArray();
			if(asks!=null){
				for(Ask ask : asks){
					if(ask.getIsReply()==2){
						// 回复追问
						JsonArray reAns=new JsonArray();
						List<Answer> ans=AnswerSer.findAnswerByAskId(ask.getId());
						if(ans!=null){
							for(Answer a : ans){
								JsonArray sAsk=new JsonArray();
								List<Ask> as=AskSer.findAskByParentId(a.getId());
                                if(as!=null){
                                	for(Ask  ak : as){
                                		JsonArray sA=new JsonArray();
                                    	List<Answer> aws=AnswerSer.findAnswerByAskId(ak.getId());
                                	}
                                }
							}
						}
						recleAnswer(ans);
					}
				}
				
			}
			
		}
		
		/*public  List<List<VideoClass>> getVideoClass(List<VideoClass> vcs){
			List<List<VideoClass>> vArray=new ArrayList<List<VideoClass>>();
			for(VideoClass vc : vcs){
				List<VideoClass> vs = VideoClassSer.findClassByPid(vc.getId());
				if(vs!=null){
					getVideoClass(vs);
				}
				vArray.add(vs);
			}
			return vArray;
		}

		*/
		
		
		
		
		
		
		
		
	}

}
