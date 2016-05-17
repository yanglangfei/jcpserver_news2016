package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *         ��Ȩ
 */
@SuppressWarnings("serial")
public class Equity implements Serializable {
	/**
	 *  ��Ȩ��Ϣ��ǰҳ
	 */
	private int pager;
	/**
	 *   ��Ȩ��Ϣ��ҳ��
	 */
	private int totlePager;
	
	/**
	 * ��Ȩid
	 */
	private int id;
	/**
	 * ����
	 */
	private String ownName;
	/**
	 * ���
	 */
	private String simpleName;

	/**
	 * �Ƽ�����
	 */
	private String recommender;
	/**
	 * �ɷݴ���
	 */
	private String equityCode;
	/**
	 * �ɱ�����
	 */
	private String capitalization;
	/**
	 * ת�ù���-----Ͷ������
	 */
	private String transferNum;
	/**
	 * ��ת�ü۸�
	 */
	private String intendsTransfer;
	/**
	 * Ͷ���ż�
	 */
	private String investmentThreshold;
	/**
	 * ÿ������
	 */
	private String eps;
	/**
	 * ÿ�ɾ��ʲ�
	 */
	private String bvps;
	/**
	 * ������
	 */
	private String netProfit;
	/**
	 * ���Ƶص�
	 */
	private String onSite;
	/**
	 * ������ҵ
	 */
	private String industry;
	/**
	 * ���޹�˾��������
	 */
	private String limitedDate;
	/**
	 * �ɷݹ�˾��������
	 */
	private String corporationDate;
	/**
	 * ע���
	 */
	private String domicile;
	/**
	 * ��˾���
	 */
	private String companyIntroduction;
	/**
	 * �˳���ʽ
	 */
	private String exitWay;
	/**
	 * �Ƿ��Ƽ�
	 */
	private int isRecomment;
	/**
	 * �Ƿ��ö�
	 */
	private int isTop;
	/**
	 * �ʽ�����
	 */
	private String fundFlow;
	/**
	 * ��������
	 */
	private String releaseDate;
	/**
	 * ��Ʒ״̬
	 */
	private String productState;
	/**
	 * �ʽ��������
	 */
	private String cashFlow;
	/**
	 * ��������
	 */
	private String incomeType;
	/**
	 * ��������
	 */
	private String deadlineType;
	/**
	 * Ͷ�ʷ���
	 */
	private String investOrientat;
	/**
	 * Ӫҵ����
	 */
	private String revenue;
	/**
	 * Ӫҵ����������
	 */
	private String incomeRate;
	/**
	 * ����������-----������
	 */
	private String profitRate;
	/**
	 *   ��ȨͼƬURL
	 */
	private String equityImage;
    
	public String getEquityImage() {
		return equityImage;
	}

	public void setEquityImage(String equityImage) {
		this.equityImage = equityImage;
	}

	public String getOwnName() {
		return ownName;
	}

	public void setOwnName(String ownName) {
		this.ownName = ownName;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public String getEquityCode() {
		return equityCode;
	}

	public void setEquityCode(String equityCode) {
		this.equityCode = equityCode;
	}

	public String getTransferNum() {
		return transferNum;
	}

	public void setTransferNum(String transferNum) {
		this.transferNum = transferNum;
	}

	public String getCapitalization() {
		return capitalization;
	}

	public void setCapitalization(String capitalization) {
		this.capitalization = capitalization;
	}

	public String getIntendsTransfer() {
		return intendsTransfer;
	}

	public void setIntendsTransfer(String intendsTransfer) {
		this.intendsTransfer = intendsTransfer;
	}

	public String getInvestmentThreshold() {
		return investmentThreshold;
	}

	public void setInvestmentThreshold(String investmentThreshold) {
		this.investmentThreshold = investmentThreshold;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getBvps() {
		return bvps;
	}

	public void setBvps(String bvps) {
		this.bvps = bvps;
	}

	public String getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(String netProfit) {
		this.netProfit = netProfit;
	}

	public String getOnSite() {
		return onSite;
	}

	public void setOnSite(String onSite) {
		this.onSite = onSite;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getLimitedDate() {
		return limitedDate;
	}

	public void setLimitedDate(String limitedDate) {
		this.limitedDate = limitedDate;
	}

	public String getCorporationDate() {
		return corporationDate;
	}

	public void setCorporationDate(String corporationDate) {
		this.corporationDate = corporationDate;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getCompanyIntroduction() {
		return companyIntroduction;
	}

	public void setCompanyIntroduction(String companyIntroduction) {
		this.companyIntroduction = companyIntroduction;
	}

	public String getExitWay() {
		return exitWay;
	}

	public void setExitWay(String exitWay) {
		this.exitWay = exitWay;
	}

	public int getIsRecomment() {
		return isRecomment;
	}

	public void setIsRecomment(int isRecomment) {
		this.isRecomment = isRecomment;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}

	public String getFundFlow() {
		return fundFlow;
	}

	public void setFundFlow(String fundFlow) {
		this.fundFlow = fundFlow;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public String getCashFlow() {
		return cashFlow;
	}

	public void setCashFlow(String cashFlow) {
		this.cashFlow = cashFlow;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public String getDeadlineType() {
		return deadlineType;
	}

	public void setDeadlineType(String deadlineType) {
		this.deadlineType = deadlineType;
	}

	public String getInvestOrientat() {
		return investOrientat;
	}

	public void setInvestOrientat(String investOrientat) {
		this.investOrientat = investOrientat;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getIncomeRate() {
		return incomeRate;
	}

	public void setIncomeRate(String incomeRate) {
		this.incomeRate = incomeRate;
	}

	public String getProfitRate() {
		return profitRate;
	}

	public void setProfitRate(String profitRate) {
		this.profitRate = profitRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getPager() {
		return pager;
	}

	public void setPager(int pager) {
		this.pager = pager;
	}

	public int getTotlePager() {
		return totlePager;
	}

	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	

}
