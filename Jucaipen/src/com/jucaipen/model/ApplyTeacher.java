package com.jucaipen.model;

/**
 * @author Administrator  --------------��������
 *
 *   ���뽲ʦ
 */
public class ApplyTeacher {
	/**
	 *   Id
	 */
	private int id;
	/**
	 *  ��ʵ����   TrueName
	 */
	private String trueName;
	/**
	 *  ���֤��  IDCard
	 */
	private String idCard;
	/**
	 *  �Ա�   Sex     �Ա�0���ܣ�1�У�2Ů��
	 */
	private int sex;
	/**
	 *  ���֤��Ƭ1  CardImg_1
	 */
	private String cardImage1;
	/**
	 *  ���֤��Ƭ2 CardImg_2
	 */
	private String cardImage2;
	/**
	 *  ���֤��Ƭ3 CardImg_3
	 */
	private String cardImage3;
	/**
	 *  �ʸ�֤����id FK_CertificationId
	 */
	private int fk_certificationId;
	/**
	 *  ��λid  FK_PositionId
	 */
	private int fk_PositionId;
	/**
	 *  �ʸ�֤����  CertificationNum
	 */
	private String certificationNum;
	/**
	 *  ���ڹ�˾ʡ��  FK_ProvinceId
	 */
	private int fk_ProvinceId;
	/**
	 *  ���ڹ�˾����  FK_CityId
	 */
	private int fk_CityId;
	/**
	 *  ��˾���� CompanyName
	 */
	private String companyName;
	
	/**
	 *  �ó����򣬶���Զ��Ÿ���   ShanChang
	 */
	private String shanChang;
	/**
	 *  ���˼��  UserInformation
	 */
	private String userInformation;
	/**
	 *  �Ƽ��û�id  FK_ParentUserId
	 */
	private int fk_ParentUserId;
	/**
	 *  ��ϵ�ֻ���  MobileNum
	 */
	private String mobileNum;
    /**
     *  ��ϵEmail  Email
     */
    private String email;
    /**
     *  �����û�id   FK_UserId
     */
    private int fk_UserId;
    /**
     *   ����״̬��0����ˣ�1����У�2��˳ɹ���3���ʧ�ܣ�                 State
     */
    private int state;
    /**
     *  InsertDate 
     */
    private String insertDate;
    /**
     *  �Ƿ����뿪ͨ����ֱ����0��  1�ǣ�  IsTxtLive
     */
    private  int isTxtLive;
    /**
     *  �Ƿ�ͨ��Ƶֱ����0��  1�ǣ� IsVideoLive
     */
    private int isVideoLive;
    /**
     *  ����id  FK_BankId
     */
    private int fk_BankId;
    /**
     *  �����˺�   BankAccount
     */
    private String bankAccount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCardImage1() {
		return cardImage1;
	}
	public void setCardImage1(String cardImage1) {
		this.cardImage1 = cardImage1;
	}
	public String getCardImage2() {
		return cardImage2;
	}
	public void setCardImage2(String cardImage2) {
		this.cardImage2 = cardImage2;
	}
	public String getCardImage3() {
		return cardImage3;
	}
	public void setCardImage3(String cardImage3) {
		this.cardImage3 = cardImage3;
	}
	public int getFk_certificationId() {
		return fk_certificationId;
	}
	public void setFk_certificationId(int fk_certificationId) {
		this.fk_certificationId = fk_certificationId;
	}
	public int getFk_PositionId() {
		return fk_PositionId;
	}
	public void setFk_PositionId(int fk_PositionId) {
		this.fk_PositionId = fk_PositionId;
	}
	public String getCertificationNum() {
		return certificationNum;
	}
	public void setCertificationNum(String certificationNum) {
		this.certificationNum = certificationNum;
	}
	public int getFk_ProvinceId() {
		return fk_ProvinceId;
	}
	public void setFk_ProvinceId(int fk_ProvinceId) {
		this.fk_ProvinceId = fk_ProvinceId;
	}
	public int getFk_CityId() {
		return fk_CityId;
	}
	public void setFk_CityId(int fk_CityId) {
		this.fk_CityId = fk_CityId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getShanChang() {
		return shanChang;
	}
	public void setShanChang(String shanChang) {
		this.shanChang = shanChang;
	}
	public String getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(String userInformation) {
		this.userInformation = userInformation;
	}
	public int getFk_ParentUserId() {
		return fk_ParentUserId;
	}
	public void setFk_ParentUserId(int fk_ParentUserId) {
		this.fk_ParentUserId = fk_ParentUserId;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFk_UserId() {
		return fk_UserId;
	}
	public void setFk_UserId(int fk_UserId) {
		this.fk_UserId = fk_UserId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getIsTxtLive() {
		return isTxtLive;
	}
	public void setIsTxtLive(int isTxtLive) {
		this.isTxtLive = isTxtLive;
	}
	public int getIsVideoLive() {
		return isVideoLive;
	}
	public void setIsVideoLive(int isVideoLive) {
		this.isVideoLive = isVideoLive;
	}
	public int getFk_BankId() {
		return fk_BankId;
	}
	public void setFk_BankId(int fk_BankId) {
		this.fk_BankId = fk_BankId;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
}
