package com.jucaipen.model;

/**
 * @author Administrator  ------------��������
 * ��ֵ����
 */
public class ChargeOrder {
	/**
	 *  ��ǰҳ��
	 */
	private int page;
	/**
	 * ��ҳ��
	 */
	private int totlePage;
	/**
	 *  id
	 */
	private int id;
	/**
	 * ������
	 */
	private String orderCode;
	/**
	 *  �û�id
	 */
	private int userId;
	/**
	 *  ��ֵ���
	 */
	private double chargeMoney;
	/**
	 * ��ֵʱ��
	 */
	private String insertDate;
	/**
	 *  ����ʱ��
	 */
	private String payDate;
	/**
	 * ����ɾ����0������1ɾ��
	 */
	private int isDel;
	/**
	 *  ��ֵIP
	 */
	private String ip;
    /**
     * ֧����ʽ 1���� 2֧���� 3΢��֧��4�����֧��
     */
    private int payType;
    /**
     *  ֧�����˺�
     */
    private String alipayAccount;
    /**
     *  ���б���ͨ��
     */
    private String bankChannel;
    /**
     * ����״̬ 1δ֧��  2��֧�� 3֧��ʧ��
     */
    private int orderState;
    
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
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getChargeMoney() {
		return chargeMoney;
	}
	public void setChargeMoney(double chargeMoney) {
		this.chargeMoney = chargeMoney;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public String getAlipayAccount() {
		return alipayAccount;
	}
	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}
	public String getBankChannel() {
		return bankChannel;
	}
	public void setBankChannel(String bankChannel) {
		this.bankChannel = bankChannel;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
}
