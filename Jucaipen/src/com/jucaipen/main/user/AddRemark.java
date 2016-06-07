package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Account;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Comment;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.News;
import com.jucaipen.model.RebateIntegeralDetail;
import com.jucaipen.model.SiteConfig;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.UserComm;
import com.jucaipen.model.Video;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.CommentSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.NewServer;
import com.jucaipen.service.RebateIntegeralDetailSer;
import com.jucaipen.service.SiteConfigSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.UserCommSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         �������----�ظ����� typeId -----����id ��0 ֤ȯ���ۣ��ظ� �� �� 1 ��Ƶ���ۣ��ظ� �� �� 2 �۵����� �ظ���
 *         �� 3 ����ֱ����
 * 
 *         ParentId 0 ���� ��0 �ظ�
 */
@SuppressWarnings("serial")
public class AddRemark extends HttpServlet {
	private String result;

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
			String typeId = request.getParameter("typeId");
			String userId = request.getParameter("userId");
			String parentId = request.getParameter("parentId");
			String newsId = request.getParameter("newsId");
			String bodys = request.getParameter("bodys");
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isInteger(parentId)) {
						int pId = Integer.parseInt(parentId);
						if (StringUtil.isInteger(newsId)) {
							int nId = Integer.parseInt(newsId);
							if (StringUtil.isNotNull(bodys)) {
								if (StringUtil.isInteger(typeId)) {
									int type = Integer.parseInt(typeId);
									result = insertRemark(uId, pId, nId, bodys,
											type);
								} else {
									result = JsonUtil.getRetMsg(5,
											"typeId�������ָ�ʽ���쳣");
								}
							} else {
								result = JsonUtil.getRetMsg(6, "bodys ��������Ϊ��");
							}
						} else {
							result = JsonUtil.getRetMsg(3, "����id�������ָ�ʽ���쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(2, "parentId �������ָ�ʽ���쳣");
					}

				} else {
					result = JsonUtil.getRetMsg(7, "��ǰ�û���û��¼");
				}
			} else {
				result = JsonUtil.getRetMsg(6, "�û�id�������ָ�ʽ���쳣");
			}
		} else {
			result = StringUtil.isVaild;
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
	 * @return
	 */
	private String insertRemark(int uId, int pId, int nId, String bodys,
			int commType) {
		if (commType == 0) {
			// ֤ȯ
			UserComm uc = new UserComm();
			uc.setBodys(bodys);
			uc.setType(0);
			uc.setGoods(0);
			uc.setInsertDate(TimeUtils
					.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			uc.setIsShow(0);
			uc.setNovId(nId);
			uc.setParentId(pId);
			uc.setReplyCount(0);
			uc.setUserId(uId);
			int isSuccess = UserCommSer.insertComm(uc);
			if (isSuccess == 1) {
				if (pId <= 0) {
					// ��������֮�󲻻��������
					News news = NewServer.findNewsById(nId);
					List<RebateIntegeralDetail> details = RebateIntegeralDetailSer
							.findRebateIntegeralByUserId(uId);
					if (details.size() <= 3) {
						SiteConfig config = SiteConfigSer.findSiteConfig();
						int commIntegeral = config.getCommIntegeral();
						Account a = AccountSer.findAccountByUserId(uId);
						if(a==null){
							Account account=new Account();
							account.setUserId(uId);
							account.setIntegeral(commIntegeral);
							account.setJucaiBills(0);
							AccountSer.addAccount(account);
							// �����û�������Ϣ
							UserServer.updateIntegeral(uId,
									commIntegeral);
						}else{
							// �������˻�������Ϣ
							AccountSer.updateIntegeral(uId,
									commIntegeral + a.getIntegeral());
							// �����û�������Ϣ
							UserServer.updateIntegeral(uId,
									commIntegeral + a.getIntegeral());
						}
						// ���·��ֱ�
						RebateIntegeralDetail inDetail = new RebateIntegeralDetail();
						inDetail.setUserId(uId);
						inDetail.setIntegralNum(commIntegeral);
						inDetail.setInsertDate(TimeUtils.format(new Date(),
								"yyyy-MM-dd HH:mm:ss"));
						inDetail.setRemark("����֤ȯ֪ʶ��" + news.getTitle() + "��");
						inDetail.setType(3);
						inDetail.setFromId(nId);
						RebateIntegeralDetailSer.addRebateIntegeral(inDetail);
					}
				}
				return JsonUtil.getRetMsg(0, "�����ύ�ɹ�");
			} else {
				return JsonUtil.getRetMsg(1, "�����ύʧ��");
			}
		} else if (commType == 1) {
			// ��Ƶ
			UserComm uc = new UserComm();
			uc.setBodys(bodys);
			uc.setType(1);
			uc.setGoods(0);
			uc.setInsertDate(TimeUtils
					.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			uc.setIsShow(0);
			uc.setNovId(nId);
			uc.setParentId(pId);
			uc.setReplyCount(0);
			uc.setUserId(uId);
			int isSuccess = UserCommSer.insertComm(uc);
			if (isSuccess == 1) {
				// ��������֮�󲻻��������
				if (pId <= 0) {
					Video video = VideoServer.findVideoById(nId);
					List<RebateIntegeralDetail> details = RebateIntegeralDetailSer
							.findRebateIntegeralByUserId(uId);
					if (details.size() <= 3) {
						SiteConfig config = SiteConfigSer.findSiteConfig();
						int commIntegeral = config.getCommIntegeral();
						Account a = AccountSer.findAccountByUserId(uId);
						// �������˻�������Ϣ
						AccountSer.updateIntegeral(uId,
								commIntegeral + a.getIntegeral());
						// �����û�������Ϣ
						UserServer.updateIntegeral(uId,
								commIntegeral + a.getIntegeral());
						// ���·��ֱ�
						RebateIntegeralDetail inDetail = new RebateIntegeralDetail();
						inDetail.setUserId(uId);
						inDetail.setIntegralNum(commIntegeral);
						inDetail.setInsertDate(TimeUtils.format(new Date(),
								"yyyy-MM-dd HH:mm:ss"));
						inDetail.setRemark("������Ƶ��" + video.getTitle() + "��");
						inDetail.setType(3);
						inDetail.setFromId(nId);
						RebateIntegeralDetailSer.addRebateIntegeral(inDetail);
					}

				}
				return JsonUtil.getRetMsg(0, "�����ύ�ɹ�");
			} else {
				return JsonUtil.getRetMsg(1, "�����ύʧ��");
			}
		} else if (commType == 2) {
			// �۵�
			Comment comm = new Comment();
			comm.setUserId(uId);
			comm.setBodys(bodys);
			comm.setGoods(0);
			comm.setCommType(1);
			comm.setInsertDate(TimeUtils.format(new Date(),
					"yyyy-MM-dd HH:mm:ss"));
			comm.setIsShow(0);
			comm.setLogOrLiveId(nId);
			comm.setParentId(pId);
			comm.setRepCount(2);
			int isSuccess = CommentSer.insertComm(comm);
			if (isSuccess == 1) {
				if (pId <= 0) {
					// ��������֮�󲻻��������
					HotIdea idea = HotIdeaServ.findIdeaById(nId);
					List<RebateIntegeralDetail> details = RebateIntegeralDetailSer
							.findRebateIntegeralByUserId(uId);
					if (details.size() <= 3) {
						SiteConfig config = SiteConfigSer.findSiteConfig();
						int commIntegeral = config.getCommIntegeral();
						Account a = AccountSer.findAccountByUserId(uId);
						// �������˻�������Ϣ
						AccountSer.updateIntegeral(uId,
								commIntegeral + a.getIntegeral());
						// �����û�������Ϣ
						UserServer.updateIntegeral(uId,
								commIntegeral + a.getIntegeral());
						// ���·��ֱ�
						RebateIntegeralDetail inDetail = new RebateIntegeralDetail();
						inDetail.setUserId(uId);
						inDetail.setIntegralNum(commIntegeral);
						inDetail.setInsertDate(TimeUtils.format(new Date(),
								"yyyy-MM-dd HH:mm:ss"));
						inDetail.setRemark("���۹۵㡾" + idea.getTitle() + "��");
						inDetail.setType(3);
						inDetail.setFromId(nId);
						RebateIntegeralDetailSer.addRebateIntegeral(inDetail);
					}
				}
				return JsonUtil.getRetMsg(0, "�����ύ�ɹ�");
			} else {
				return JsonUtil.getRetMsg(1, "�����ύʧ��");
			}
		} else {
			// ����ֱ��
			Comment comm = new Comment();
			comm.setUserId(uId);
			comm.setBodys(bodys);
			comm.setGoods(0);
			comm.setCommType(2);
			comm.setInsertDate(TimeUtils.format(new Date(),
					"yyyy-MM-dd HH:mm:ss"));
			comm.setIsShow(0);
			comm.setLogOrLiveId(nId);
			comm.setParentId(pId);
			comm.setRepCount(2);
			int isSuccess = CommentSer.insertComm(comm);
			if (isSuccess == 1) {
				if (pId <= 0) {
					// ��������֮�󲻻��������
					TextLive txt = TxtLiveSer.findTextLiveById(nId);
					List<RebateIntegeralDetail> details = RebateIntegeralDetailSer
							.findRebateIntegeralByUserId(uId);
					if (details.size() <= 3) {
						SiteConfig config = SiteConfigSer.findSiteConfig();
						int commIntegeral = config.getCommIntegeral();
						Account a = AccountSer.findAccountByUserId(uId);
						// �������˻�������Ϣ
						AccountSer.updateIntegeral(uId,
								commIntegeral + a.getIntegeral());
						// �����û�������Ϣ
						UserServer.updateIntegeral(uId,
								commIntegeral + a.getIntegeral());
						// ���·��ֱ�
						RebateIntegeralDetail inDetail = new RebateIntegeralDetail();
						inDetail.setUserId(uId);
						inDetail.setIntegralNum(commIntegeral);
						inDetail.setInsertDate(TimeUtils.format(new Date(),
								"yyyy-MM-dd HH:mm:ss"));
						inDetail.setRemark("��������ֱ����" + txt.getTitle() + "��");
						inDetail.setType(3);
						inDetail.setFromId(nId);
						RebateIntegeralDetailSer.addRebateIntegeral(inDetail);
					}
				}
				return JsonUtil.getRetMsg(0, "�����ύ�ɹ�");
			} else {
				return JsonUtil.getRetMsg(1, "�����ύʧ��");
			}
		}

	}

}
