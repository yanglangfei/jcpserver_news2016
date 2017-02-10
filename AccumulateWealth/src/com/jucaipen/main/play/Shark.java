package com.jucaipen.main.play;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.SharkDetail;
import com.jucaipen.model.SharkInfo;
import com.jucaipen.service.AccountDetailSer;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.SharkDetailServer;
import com.jucaipen.service.SharkInfoServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author ���ʷ� 2017��1��23�� ����1:19:08 ҡһҡ���
 * 
 *         ��1�ֻ���ҳ�ˣ�2�ֻ���׿�ˣ�3�ֻ�IOS�ˣ� pathWay
 */
public class Shark extends HttpServlet {
	private static final long serialVersionUID = -6439675981383682638L;
	// 400-500
	private static final int Max_Price = 3;
	// 300-400
	private static final int Middle_Price = 6;
	// 200-300
	private static final int Low_Price = 9;
	private boolean isExit = true;
	private boolean isRest = true;
	private boolean isAllRest = true;
	private int ran;
	private String result;
	private static final int MAX_COUNT = 1;
	private int syPrice;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String pathWay = request.getParameter("pathWay");
		// 1���ж�ҡһҡʱ��
		if (checkTime()) {
			// 2���ж��û��Ƿ��¼
			if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					// 3���жϵ�ǰ�û�ҡһҡ����
					if (checkCount(uId)) {
						if (StringUtil.isNotNull(pathWay)
								&& StringUtil.isInteger(pathWay)) {
							int path = Integer.parseInt(pathWay);
							if (createRandomBills(uId, path)) {
								if (isRest) {
									result = JsonUtil.getRetMsgJu(0, "��ϲ���ȡ"
											+ ran + "���۲Ʊ�", ran);
								} else {
									result = JsonUtil.getRetMsgJu(0, "��ϲ���ȡ"
											+ syPrice + "���۲Ʊ�", syPrice);
								}
							} else {
								if (isExit) {
									result = JsonUtil.getRetMsgJu(1,
											"ҡһҡʧ�ܣ�������ҡһҡ", 0);
								} else {
									if (isAllRest) {
										// 8 ���ж���Ѿ�����
										result = JsonUtil.getRetMsgJu(8,
												"���λ�ѽ���", 0);
									} else {
										// 7 ���ն�������꣬��������
										result = JsonUtil.getRetMsgJu(7,
												"�����ѱ�����", 0);
									}
								}
							}
						} else {
							result = JsonUtil.getRetMsgJu(2, "pathWay �����쳣", 0);
						}
					} else {
						result = JsonUtil.getRetMsgJu(3, "ҡһҡ�����Ѿ�����", 0);
					}
				} else {
					result = JsonUtil.getRetMsgJu(4, "���ȵ�¼�˺�", 0);
				}
			} else {
				result = JsonUtil.getRetMsgJu(5, "userId �����쳣", 0);
			}
		} else {
			result = JsonUtil.getRetMsgJu(6, "ҡһҡ���û��ʼ", 0);
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param uId
	 * @return  ҡһҡ�����Ƿ�����
	 */
	private boolean checkCount(int uId) {
		// ��ȡ��ǰ�û�ҡһҡ����
		int count = SharkDetailServer.getSharkCount(uId);
		return count < MAX_COUNT;
	}

	/**
	 * @return  ҡһҡʱ���Ƿ���Ч
	 */
	private boolean checkTime() {
		// ��ȡҡһҡʱ��
		SharkInfo info = SharkInfoServer.getSharkInfo();
		if (info != null) {
			String startDate = info.getStartDate();
			String endDate = info.getEndDate();
			return TimeUtils.isLive(startDate, endDate);
		} else {
			return false;
		}
	}

	public boolean createRandomBills(int uId, int path) {
		// 50-500 ����������۲Ʊ�
		createBill();
		return createRecoder(uId, path, ran)
				&& createAccountDeatil(uId, path, ran)
				&& createAccount(uId, path, ran);
	}

	/**
	 * @return �� 50-500 ֮���������Ķ��
	 */
	private void createBill() {
		ran = ran(50, 500);
		getCount1(ran);
	}

	/**
	 * @param ran   �Ե�һ��ҡһҡ�Ľ�������жϴ���
	 */
	public void getCount1(int ran) {
		//  400-500
		if (ran > 400 && ran <= 500) {
			int num = SharkDetailServer.getMaxCount(400, 500);
			if (num >= Max_Price) {
				ran = ran(300, 400);
				getCount2(ran);
			}
			//  300-400
		} else if (ran > 300 && ran <= 400) {
			int num = SharkDetailServer.getMaxCount(300, 400);
			if (num >= Middle_Price) {
				ran = ran(200, 300);
				getCount3(ran);
			}
			//  200-300
		} else if (ran > 200 && ran <= 300) {
			int num = SharkDetailServer.getMaxCount(200, 300);
			if (num >= Low_Price) {
				getCount4();
			}
		}
	}

	/**
	 * @param min
	 * @param max
	 * @return �� min-max ֮����������
	 */
	public static int ran(int min, int max) {
		// Random random=new Random();
		// return random.nextInt(max)%(max-min+1) + min;
		return (int) ((max - min) * Math.random() + min);
	}

	/**
	 * @param ran
	 * @return //�����Ķ���� 300-400֮��
	 */
	public void getCount2(int ran) {
		int num = SharkDetailServer.getMaxCount(300, 400);
		if (num >= Middle_Price) {
			ran = ran(200, 300);
			getCount3(ran);
		}

	}

	/**
	 * @param ran
	 * @return // �����Ķ���� 200-300 ֮��
	 */
	public void getCount3(int ran) {
		int num = SharkDetailServer.getMaxCount(200, 300);
		if (num >= Low_Price) {
			getCount4();
		}
	}

	/**
	 * @param ran
	 * @return // �����Ķ���� 50-200 ֮��
	 */
	public void getCount4() {
		ran = ran(50, 200);
	}

	/**
	 * @param uId
	 * @param path
	 * @param ran
	 * @return  �޸����˻��۲Ʊ�����
	 */
	private boolean createAccount(int uId, int path, int ran) {
		Account account = AccountSer.findAccountByUserId(uId);
		if (!isRest) {
			ran = syPrice;
		}
		if (account == null) {
			account = new Account();
			account.setIntegeral(0);
			account.setUserId(uId);
			account.setJucaiBills(ran);
			return AccountSer.addAccount(account) > 0;
		} else {
			return AccountSer.updateBills(uId, ran + account.getJucaiBills()) > 0;
		}
	}

	/**
	 * @param uId
	 * @param path
	 * @param ran
	 * @return ����˵��۲Ʊ����Ӽ�¼
	 */
	private boolean createAccountDeatil(int uId, int path, int ran) {
		AccountDetail detail = new AccountDetail();
		if (!isRest) {
			ran = syPrice;
		}
		detail.setDetailMoney(ran);
		detail.setDetailType(0);
		detail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detail.setOrderCode("");
		detail.setRemark("���۲���ѧ���ͺ�����´�����۲ƱҺ������+" + ran);
		detail.setUserId(uId);
		detail.setState(0);
		return AccountDetailSer.addDetails(detail) > 0;
	}

	/**
	 * @param uId
	 * @param path
	 * @param ran
	 * @return ���ҡһҡ��¼
	 */
	private boolean createRecoder(int uId, int path, int ran) {
		SharkInfo info = SharkInfoServer.getSharkInfo();
		syPrice = info.getSyPrice();
		if (syPrice > 0) {
			isExit = true;
			if (syPrice < ran) {
				isRest = false;
				SharkDetail detail = new SharkDetail();
				detail.setInsertDate(TimeUtils.format(new Date(),
						"yyyy-MM-dd HH:mm:ss"));
				detail.setPathWay(path);
				detail.setPrice(syPrice);
				detail.setRemark("ҡһҡ��ȡ���" + syPrice + "���۲Ʊ�,��ǰ��0");
				detail.setUserId(uId);
				return SharkInfoServer.updatePrice(0) > 0
						&& SharkDetailServer.addDetail(detail) > 0;
			} else {
				isRest = true;
				SharkDetail detail = new SharkDetail();
				detail.setInsertDate(TimeUtils.format(new Date(),
						"yyyy-MM-dd HH:mm:ss"));
				detail.setPathWay(path);
				detail.setPrice(ran);
				detail.setRemark("ҡһҡ��ȡ���" + ran + "���۲Ʊ�,��ǰ��"
						+ (syPrice - ran));
				detail.setUserId(uId);
				return SharkInfoServer.updatePrice(syPrice - ran) > 0
						&& SharkDetailServer.addDetail(detail) > 0;
			}
		} else {
			ran = 0;
			isExit = false;
			String date = TimeUtils.format(TimeUtils.addDay(1), "yyyy-MM-dd");
			SharkInfo inf = SharkInfoServer.getSharkByIsEnd(date);
			if (inf != null) {
				// ���ն������
				isAllRest = false;
			} else {
				// ���ж������
				isAllRest = true;
			}
			return false;
		}
	}
}
