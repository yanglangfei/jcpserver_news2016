package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator --------------------------�����Ѹ��� 5.18
 * 
 *         �Ƽ���ʦ
 */
@SuppressWarnings("serial")
public class FamousTeacher implements Serializable {
	/**
	 * ��ʦ��ǰҳ��
	 */
	private int page;
	/**
	 * ��ʦ��ҳ��
	 */
	private int totlePage;
	/**
	 * ��ʦid
	 */
	private int id;

	/**
	 * �����û�id
	 */
	private int fk_UserId;
	/**
	 * ��ʵ����
	 */
	private String trueName;
	/**
	 * �Ƿ��ע
	 */
	private boolean isAttention;
	/**
	 * �ǳ�
	 */
	private String nickName;
	/**
	 * ͷ��
	 */
	private String headFace;
	/**
	 * ͷ��
	 */
	private String level;
	/**
	 * �Ƿ��V
	 */
	private int isV;
	/**
	 * ��˿����
	 */
	private int fans;
	/**
	 * ֱ������
	 */
	private int liveFans;
	/**
	 * �ظ�������
	 */
	private int answerCount;
	/**
	 * ��־��
	 */
	private int articleCount;
	/**
	 * ��Ƶֱ���Ƿ����
	 */
	private int liveIsEnd;

	/**
	 * ��־�Ķ���
	 */
	private int articleReadCount;
	/**
	 * ��־������
	 */
	private int articleGood;
	/**
	 * ����
	 */
	private String notice;
	/**
	 * ��ʦ���
	 */
	private String introduce;
	/**
	 * �ó�����
	 */
	private String hoby;
	/**
	 * �ֻ���
	 */
	private String telPhone;
	/**
	 * ǩԼ����
	 */
	private int signCount;
	/**
	 * �˺�״̬��0������1��������2��ɾ����3δ���ã�������ͨ����δ������Ϣ�Ľ�ʦ����
	 */
	private int state;
	/**
	 * ����ʱ��
	 */
	private String joinDate;
	/**
	 * ֱ�������Ƿ���Ҫ���
	 */
	private int liveGbookIsPass;
	/**
	 * ��������
	 */
	private int askNum;
	/**
	 * �ش������Ƿ���Ҫ���� 0 �� 1 ��
	 */
	private int isPay;
	/**
	 * �ش��շѼ۸�
	 */
	private int answerPrice;
	/**
	 * ��Ϊ�ػ�����۸�
	 */
	private int yaerPrice;
	/**
	 * ��Ϊ�ػ����¼۸�
	 */
	private int mothPrice;
	/**
	 * ��Ϊ�ػ��߼��ȼ۸�
	 */
	private int qulaterPrice;
	/**
	 * ��Ϊ�ػ�����۸�
	 */
	private int dayPrice;

	/**
	 * ��Ϊ�ػ��ܷ���
	 */
	private int weekPrice;
	/**
	 * �Ƿ��Ƽ� 0 �� 1 ��
	 */
	private int isTuijian;
	/**
	 * ������
	 */
	private int weekRenQi;
	/**
	 * ������
	 */
	private int mothRenQi;
	/**
	 * ֱ����ƵURL
	 */
	private String videoLiveUrl;
	/**
	 *  
	 */
	private int isUserLiveUrl;
	/**
	 * ����id
	 */
	private int bankId;

	private String bankName;
	/**
	 * �����˺�
	 */
	private String bankAccount;
	/**
	 * ������
	 */
	private double returnRate;
	/**
	 * ����ֱ���շѼ۸�
	 */
	private int txtLivePrice;

	/**
	 * ֱ���շѼ۸�
	 */
	private int livePrice;

	/**
	 * ����ֱ���Ƿ��շ�
	 */
	private int txtLiveFree;

	/**
	 * ֱ���Ƿ��շ�
	 */
	private int liveFree;

	/**
	 * ����ֱ������
	 */
	private int xnLiveRenQi;

	/**
	 * ���������Ķ���
	 */
	private int xnArticleReadNum;

	private String mobileLiveUrl;
	

	public int getWeekPrice() {
		return weekPrice;
	}

	public void setWeekPrice(int weekPrice) {
		this.weekPrice = weekPrice;
	}

	public String getMobileLiveUrl() {
		return mobileLiveUrl;
	}

	public void setMobileLiveUrl(String mobileLiveUrl) {
		this.mobileLiveUrl = mobileLiveUrl;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getTxtLivePrice() {
		return txtLivePrice;
	}

	public void setTxtLivePrice(int txtLivePrice) {
		this.txtLivePrice = txtLivePrice;
	}

	public int getLivePrice() {
		return livePrice;
	}

	public void setLivePrice(int livePrice) {
		this.livePrice = livePrice;
	}

	public int getTxtLiveFree() {
		return txtLiveFree;
	}

	public void setTxtLiveFree(int txtLiveFree) {
		this.txtLiveFree = txtLiveFree;
	}

	public int getLiveFree() {
		return liveFree;
	}

	public void setLiveFree(int liveFree) {
		this.liveFree = liveFree;
	}

	public int getXnLiveRenQi() {
		return xnLiveRenQi;
	}

	public void setXnLiveRenQi(int xnLiveRenQi) {
		this.xnLiveRenQi = xnLiveRenQi;
	}

	public int getXnArticleReadNum() {
		return xnArticleReadNum;
	}

	public void setXnArticleReadNum(int xnArticleReadNum) {
		this.xnArticleReadNum = xnArticleReadNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotlePage() {
		return totlePage;
	}

	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_UserId() {
		return fk_UserId;
	}

	public void setFk_UserId(int fk_UserId) {
		this.fk_UserId = fk_UserId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public boolean isAttention() {
		return isAttention;
	}

	public void setAttention(boolean isAttention) {
		this.isAttention = isAttention;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadFace() {
		return headFace;
	}

	public void setHeadFace(String headFace) {
		this.headFace = headFace;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getIsV() {
		return isV;
	}

	public void setIsV(int isV) {
		this.isV = isV;
	}

	public int getFans() {
		return fans;
	}

	public void setFans(int fans) {
		this.fans = fans;
	}

	public int getLiveFans() {
		return liveFans;
	}

	public void setLiveFans(int liveFans) {
		this.liveFans = liveFans;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public int getLiveIsEnd() {
		return liveIsEnd;
	}

	public void setLiveIsEnd(int liveIsEnd) {
		this.liveIsEnd = liveIsEnd;
	}

	public int getArticleReadCount() {
		return articleReadCount;
	}

	public void setArticleReadCount(int articleReadCount) {
		this.articleReadCount = articleReadCount;
	}

	public int getArticleGood() {
		return articleGood;
	}

	public void setArticleGood(int articleGood) {
		this.articleGood = articleGood;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getHoby() {
		return hoby;
	}

	public void setHoby(String hoby) {
		this.hoby = hoby;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public int getSignCount() {
		return signCount;
	}

	public void setSignCount(int signCount) {
		this.signCount = signCount;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public int getLiveGbookIsPass() {
		return liveGbookIsPass;
	}

	public void setLiveGbookIsPass(int liveGbookIsPass) {
		this.liveGbookIsPass = liveGbookIsPass;
	}

	public int getAskNum() {
		return askNum;
	}

	public void setAskNum(int askNum) {
		this.askNum = askNum;
	}

	public int getIsPay() {
		return isPay;
	}

	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}

	public int getAnswerPrice() {
		return answerPrice;
	}

	public void setAnswerPrice(int answerPrice) {
		this.answerPrice = answerPrice;
	}

	public int getYaerPrice() {
		return yaerPrice;
	}

	public void setYaerPrice(int yaerPrice) {
		this.yaerPrice = yaerPrice;
	}

	public int getMothPrice() {
		return mothPrice;
	}

	public void setMothPrice(int mothPrice) {
		this.mothPrice = mothPrice;
	}

	public int getQulaterPrice() {
		return qulaterPrice;
	}

	public void setQulaterPrice(int qulaterPrice) {
		this.qulaterPrice = qulaterPrice;
	}

	public int getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(int dayPrice) {
		this.dayPrice = dayPrice;
	}

	public int getIsTuijian() {
		return isTuijian;
	}

	public void setIsTuijian(int isTuijian) {
		this.isTuijian = isTuijian;
	}

	public int getWeekRenQi() {
		return weekRenQi;
	}

	public void setWeekRenQi(int weekRenQi) {
		this.weekRenQi = weekRenQi;
	}

	public int getMothRenQi() {
		return mothRenQi;
	}

	public void setMothRenQi(int mothRenQi) {
		this.mothRenQi = mothRenQi;
	}

	public String getVideoLiveUrl() {
		return videoLiveUrl;
	}

	public void setVideoLiveUrl(String videoLiveUrl) {
		this.videoLiveUrl = videoLiveUrl;
	}

	public int getIsUserLiveUrl() {
		return isUserLiveUrl;
	}

	public void setIsUserLiveUrl(int isUserLiveUrl) {
		this.isUserLiveUrl = isUserLiveUrl;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public double getReturnRate() {
		return returnRate;
	}

	public void setReturnRate(double returnRate) {
		this.returnRate = returnRate;
	}

}
