package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF            --------------�����Ѹ���
 * 
 *    ����bean  0֤ȯ֪ʶ��1Ϊ��Ƶ   JCP_User_Comm
 *
 */
@SuppressWarnings("serial")
public class UserComm implements Serializable {
	private int page;
	private int totlePage;
    /**
     *  ����id
     */
    private int id;
    /**
     *  �����û�id
     */
    private int userId;
    
    /**
     *  �û�����
     */
    private String userName;
    /**
     *  �û�ͷ��
     */
    private String userFace;
    
    /**
     *   �û��ȼ�
     */
    private int userLeavel;
    
    /**
     *  ��������
     */
    private String bodys;
    /**
     * ����id
     */
    private int parentId;
    /**
     * �������0Ϊ֤ȯ֪ʶ��1Ϊ��Ƶ��
     */
    private int type;
    /**
     * ��Ƶ��֤ȯ֪ʶID
     */
    private int novId;
    
    private String fkName;
    
    private String fkDesc;
    
    private String fkImage;
    /**
     *  ��������
     */
    private int goods;
    /**
     *  ����ʱ��
     */
    private String insertDate;
    /**
     *  �ظ�����
     */
    private int replyCount;
    /**
     *  �Ƿ���ʾ��0�ǣ�1��
     */
    private int isShow;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserFace() {
		return userFace;
	}
	public void setUserFace(String userFace) {
		this.userFace = userFace;
	}
	public int getUserLeavel() {
		return userLeavel;
	}
	public void setUserLeavel(int userLeavel) {
		this.userLeavel = userLeavel;
	}
	public String getFkDesc() {
		return fkDesc;
	}
	public void setFkDesc(String fkDesc) {
		this.fkDesc = fkDesc;
	}
	public String getFkImage() {
		return fkImage;
	}
	public void setFkImage(String fkImage) {
		this.fkImage = fkImage;
	}
	public String getFkName() {
		return fkName;
	}
	public void setFkName(String fkName) {
		this.fkName = fkName;
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
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNovId() {
		return novId;
	}
	public void setNovId(int novId) {
		this.novId = novId;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
    
}
