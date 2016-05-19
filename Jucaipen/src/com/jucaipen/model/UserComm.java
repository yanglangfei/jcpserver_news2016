package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF            --------------�����Ѹ���
 * 
 *    ����bean  0֤ȯ֪ʶ��1Ϊ��Ƶ
 *
 */
@SuppressWarnings("serial")
public class UserComm implements Serializable {
    /**
     *  ����id
     */
    private int id;
    /**
     *  �����û�id
     */
    private int userId;
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
    
	public UserComm(int id, int userId, String bodys, int parentId, int type,
			int novId, int goods, String insertDate, int replyCount, int isShow) {
		this.id = id;
		this.userId = userId;
		this.bodys = bodys;
		this.parentId = parentId;
		this.type = type;
		this.novId = novId;
		this.goods = goods;
		this.insertDate = insertDate;
		this.replyCount = replyCount;
		this.isShow = isShow;
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
