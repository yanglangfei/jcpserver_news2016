package com.jucaipen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator              --------------------�����Ѹ���     5.18
 *
 *  ����
 */
@SuppressWarnings("serial")
public class Ask implements Serializable{
	/**
	 * ���ʵ�ǰҳ��
	 */
	private int page;
	/**
	 * ������ҳ��
	 */
	private int totlePage;
	/**
	 *  ����id
	 */
	private int id;
	/**
	 * �����û�id
	 */
	private int userId;
	
	private String userFace;
	
	private String userName;
	
	private int userLeavel;
	
	/**
	 *  ׷����id ׷����Ч
	 */
	private int parentId;
	/**
	 * ��������
	 */
	private String askBody;
	/**
	 * ����ʱ��
	 */
	private String askDate;
	/**
	 * ����״̬
	 */
	private int askState;
	/**
	 * �����
	 */
	private int hits;
	/**
	 * �Ƿ�ָ�
	 */
	private int isReply;
	/**
	 *  �ظ�����
	 */
	private String replyBody;
	/**
	 * ��������id
	 */
	private int classId;
	/**
	 * ��������ʦid
	 */
	private int teacherId;
	/**
	 *  ������ip
	 */
	private String ip;
	/**
	 *   0 ���   1  �շ�
	 */
	private int isPay;
	/**
	 *  ֧���۲Ʊ�
	 */
	private int jucaiBills;
	/**
	 *  ������Դ ��1��PC�ˣ�2���ֻ�APP��3���ֻ���վ��
	 */
	private int askFrom;
	/**
	 *  ��ʦ����δ�ش��Ƿ��Ѿ��˻��۲Ʊң�0δ�˻���1���˻������ֶ������ڸ��������ҽ�ʦ����δ�ش�ʱ
	 */
	private int isReturnJcb;
	/**
	 *   �ظ���
	 */
	private int replyCount;
	private List<Answer> answers=new ArrayList<Answer>();
	
	public String getUserFace() {
		return userFace;
	}
	public void setUserFace(String userFace) {
		this.userFace = userFace;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserLeavel() {
		return userLeavel;
	}
	public void setUserLeavel(int userLeavel) {
		this.userLeavel = userLeavel;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public String getReplyBody() {
		return replyBody;
	}
	public void setReplyBody(String replyBody) {
		this.replyBody = replyBody;
	}
	public int getIsReturnJcb() {
		return isReturnJcb;
	}
	public void setIsReturnJcb(int isReturnJcb) {
		this.isReturnJcb = isReturnJcb;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getAskBody() {
		return askBody;
	}
	public void setAskBody(String askBody) {
		this.askBody = askBody;
	}
	public String getAskDate() {
		return askDate;
	}
	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}
	public int getAskState() {
		return askState;
	}
	public void setAskState(int askState) {
		this.askState = askState;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getIsReply() {
		return isReply;
	}
	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getIsPay() {
		return isPay;
	}
	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}
	public int getJucaiBills() {
		return jucaiBills;
	}
	public void setJucaiBills(int jucaiBills) {
		this.jucaiBills = jucaiBills;
	}
	public int getAskFrom() {
		return askFrom;
	}
	public void setAskFrom(int askFrom) {
		this.askFrom = askFrom;
	}

}
