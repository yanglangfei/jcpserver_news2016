package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *  ����Դ�
 *
 */
@SuppressWarnings("serial")
public class Question implements Serializable{
	/**
	 *  ��ǰҳ��
	 */
	private int page;
	/**
	 *   ��ҳ��
	 */
	private int totlePage;
	/**
	 *  �����ʽ�ʦid
	 */
	private int teacherId;
	/**
	 * ����id
	 */
	private int askId;
	/**
	 *  ����ʱ��
	 */
	private String askDate;
	/**
	 * ��ʦ��Ƭ
	 */
	private String headFace;
	/**
	 * ��ʦ�ǳ�
	 */
	private String nickName;
	/**
	 * ��ʦͷ��
	 */
	private String level;
	/**
	 *  �Ƿ��V  0 ��   
	 */
	private int isV;
	/**
	 * �������ǳ�
	 */
	private String askName;
	/**
	 * ��������
	 */
	private String askBody;
	/**
	 * ����״̬
	 */
	private int isReply;
	/**
	 * �ظ�����
	 */
	private String answerBody;
	
	public Question(int teacherId, String headFace, String nickName, String level,
			int isV, String askName, String askBody, int isReply,
			String answerBody) {
		this.teacherId = teacherId;
		this.headFace = headFace;
		this.nickName = nickName;
		this.level = level;
		this.isV = isV;
		this.askName = askName;
		this.askBody = askBody;
		this.isReply = isReply;
		this.answerBody = answerBody;
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



	public String getAskDate() {
		return askDate;
	}


	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}


	public int getAskId() {
		return askId;
	}

	public void setAskId(int askId) {
		this.askId = askId;
	}

	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getHeadFace() {
		return headFace;
	}


	public void setHeadFace(String headFace) {
		this.headFace = headFace;
	}


	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public String getAskName() {
		return askName;
	}
	public void setAskName(String askName) {
		this.askName = askName;
	}
	public String getAskBody() {
		return askBody;
	}
	public void setAskBody(String askBody) {
		this.askBody = askBody;
	}
	
	public int getIsReply() {
		return isReply;
	}
	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
	

}
