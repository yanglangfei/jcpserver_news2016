package com.jucaipen.model;

/**
 * @author Administrator  ---------��������
 *
 *  �ش�����
 */
public class AnswerSale {
	/**
	 *  ��ǰҳ��
	 */
	private int page;
	/**
	 *  ��ҳ��
	 */
	private int totlePage;
	
	/**
	 *  ��������
	 */
	private String askBody;
	
	/**
	 *  �ظ�����
	 */
	private String answerBody;
	
	/**
	 *   �ظ���ʦ�ǳ�
	 */
	private String answerTeacherName;
	
	private String teacherFace;
	
	/**
	 *  id   Id
	 */
	private int id;
	/**
	 *  �û�id   FK_UserId
	 */
	private int userId;
	/**
	 *  ��ʦid   FK_TearchId
	 */
	private int teacherId;
	/**
	 *  �������   OrderCode
	 */
	private String orderCode;
	/**
	 *  ����id   FK_AskId
	 */
	private int askId;
	/**
	 *  ���ʱ��  InsertDate
	 */
	private String insetDate;
	
	
	
	
	public String getTeacherFace() {
		return teacherFace;
	}
	public void setTeacherFace(String teacherFace) {
		this.teacherFace = teacherFace;
	}
	public String getAskBody() {
		return askBody;
	}
	public void setAskBody(String askBody) {
		this.askBody = askBody;
	}
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
	public String getAnswerTeacherName() {
		return answerTeacherName;
	}
	public void setAnswerTeacherName(String answerTeacherName) {
		this.answerTeacherName = answerTeacherName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getAskId() {
		return askId;
	}
	public void setAskId(int askId) {
		this.askId = askId;
	}
	public String getInsetDate() {
		return insetDate;
	}
	public void setInsetDate(String insetDate) {
		this.insetDate = insetDate;
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
}
