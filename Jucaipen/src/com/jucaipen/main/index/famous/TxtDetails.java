package com.jucaipen.main.index.famous;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.LiveDetailSale;
import com.jucaipen.model.SiteConfig;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.TxtLiveDetails;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.LiveDetailSaleSer;
import com.jucaipen.service.SiteConfigSer;
import com.jucaipen.service.TxtLiveDetaileSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         ��ȡ����ֱ����ϸ��Ϣ
 */
@SuppressWarnings("serial")
public class TxtDetails extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String txtId = request.getParameter("txtId");
		String userId=request.getParameter("userId");
		if (StringUtil.isNotNull(txtId)) {
			if (StringUtil.isInteger(txtId)) {
				int tId = Integer.parseInt(txtId);
				if(StringUtil.isNotNull(userId)&&StringUtil.isInteger(userId)){
					int uId=Integer.parseInt(userId);
					result = initTxtDetails(tId,uId);
				}else{
					result = JsonUtil.getRetMsg(3, "userId �������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "txtId �������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "txtId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initTxtDetails(int tId,int uId) {
		// ��ʼ������ֱ����ϸ��Ϣ
		int isPurch=1;
		if(uId<=0){
			isPurch=1;
		}
		
		TextLive live = TxtLiveSer.findTextLiveById(tId);
		if(live==null){
			return JsonUtil.getRetMsg(6,"ֱ����Ϣ������");
		}
		int teacherId=live.getTeacherId();
		FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(teacherId);
		List<TxtLiveDetails> txtDetails = TxtLiveDetaileSer
				.findTextDetaileByLiveId(tId,0);
		if(txtDetails!=null){
			for(TxtLiveDetails detail : txtDetails){
				int isTxtFree=teacher.getTxtLiveFree();
				if(uId>0&&isTxtFree==0){
					LiveDetailSale sale = LiveDetailSaleSer.findSaleByUserIdAndTxtIdAndDetailId(uId, detail.getId());
				    if(sale!=null){
				    	isPurch=0;
				    }else{
				    	isPurch=1;
				    }
				}
				if(isTxtFree==1){
					detail.setIsFree(0);
				}
				detail.setIsPurch(isPurch);
			}
		}
		initTxtHits(tId,live.getHits(),live.getXnHits());
		return JsonUtil.getTxtDetails(txtDetails);
	}

	
	private void initTxtHits(int tId, int hits,int xnHits) {
		SiteConfig config = SiteConfigSer.findSiteConfig();
		TxtLiveSer.addHits(hits+1, tId,xnHits+config.getNewsMom());
		
	}

}
