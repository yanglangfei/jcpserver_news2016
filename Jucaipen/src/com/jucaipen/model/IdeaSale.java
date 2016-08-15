package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator     ------------�����Ѹ���
 *
 *    ����۵���Ϣ
 *
 */
@SuppressWarnings("serial")
public class IdeaSale implements Serializable{
	private int page;
	private int totlePage;
	private int id;
	/**
	 *   �����û�id 
	 */
	private int userId;
	/**
	 *  ֱ����ʦid
	 */
	private int teacherId;
	/**
	 *  ��ʦͷ��
	 */
	private String teacherFace;
	/**
	 *  ��ʦ�ǳ�
	 */
	private String teacherNickName;
	/**
	 *  �Ƿ��V
	 */
	private int teacherIsV;
	/**
	 *  ְ��
	 */
	private String teacherLeavel;
	
	/**
	 * ������
	 */
	private String orderCode;
	/**
	 *   ֱ��id
	 */
	private int logId;
	/**
	 *  �۵����
	 */
	private String logTitle;
	/**
	 *  �۵�����
	 */
	private String logBody;
	/**
	 *    ��������ʱ��
	 */
	private String insertDate;
	
	public IdeaSale() {
		super();
	}

	public IdeaSale(int id, int userId, int teacherId, String orderCode,
			int logId, String insertDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.teacherId = teacherId;
		this.orderCode = orderCode;
		this.logId = logId;
		this.insertDate = insertDate;
	}
	
	
	public String getTeacherFace() {
		return teacherFace;
	}

	public void setTeacherFace(String teacherFace) {
		this.teacherFace = teacherFace;
	}

	public String getTeacherNickName() {
		return teacherNickName;
	}

	public void setTeacherNickName(String teacherNickName) {
		this.teacherNickName = teacherNickName;
	}

	

	public int getTeacherIsV() {
		return teacherIsV;
	}

	public void setTeacherIsV(int teacherIsV) {
		this.teacherIsV = teacherIsV;
	}

	public String getTeacherLeavel() {
		return teacherLeavel;
	}

	public void setTeacherLeavel(String teacherLeavel) {
		this.teacherLeavel = teacherLeavel;
	}

	public String getLogTitle() {
		return logTitle;
	}

	public void setLogTitle(String logTitle) {
		this.logTitle = logTitle;
	}

	public String getLogBody() {
		return logBody;
	}

	public void setLogBody(String logBody) {
		this.logBody = logBody;
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

	public void setLogId(int logId) {
		this.logId = logId;
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
	public int getLogId() {
		return logId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	
	

}
