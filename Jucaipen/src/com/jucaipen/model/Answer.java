package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator         ----------------�����Ѹ���
 *
 *   ��ʦ�ظ�
 */
@SuppressWarnings("serial")
public class Answer implements Serializable{
	/**
	 * ��ǰҳ��
	 */
	private int page;
	/**
	 * ��ҳ��
	 */
	private int totlePage;
	/**
	 * id
	 */
	private int id;
	/**
	 * �ش���������
	 */
	private String answerBody;
	/**
	 * ��ʦid
	 */
	private int teacherId;
	
	private String teacherName;
	
	private String teacherFace;
	
	private String teacherLeavel;
	/**
	 * �ش������id
	 */
	private int askId;
	/**
	 * �ش�����ʱ��
	 */
	private String answerDate;
	/**
	 * ����   ����Ϊ5��
	 */
	private int grade;
	/**
	 *  �Ƿ����   0  ��   1  ��
	 */
	private int isCatch;
	/**
	 *  ˽�ܲ���
	 */
	private String privateBody;
	
	
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherFace() {
		return teacherFace;
	}
	public void setTeacherFace(String teacherFace) {
		this.teacherFace = teacherFace;
	}
	public String getTeacherLeavel() {
		return teacherLeavel;
	}
	public void setTeacherLeavel(String teacherLeavel) {
		this.teacherLeavel = teacherLeavel;
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
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getAskId() {
		return askId;
	}
	public void setAskId(int askId) {
		this.askId = askId;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getIsCatch() {
		return isCatch;
	}
	public void setIsCatch(int isCatch) {
		this.isCatch = isCatch;
	}
	public String getPrivateBody() {
		return privateBody;
	}
	public void setPrivateBody(String privateBody) {
		this.privateBody = privateBody;
	}
}
