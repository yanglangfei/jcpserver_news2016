package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF            --------------数据已更新
 * 
 *    评论bean  0证券知识，1为视频
 *
 */
@SuppressWarnings("serial")
public class UserComm implements Serializable {
    /**
     *  评论id
     */
    private int id;
    /**
     *  评论用户id
     */
    private int userId;
    /**
     *  评论内容
     */
    private String bodys;
    /**
     * 父级id
     */
    private int parentId;
    /**
     * 评论类别（0为证券知识，1为视频）
     */
    private int type;
    /**
     * 视频或证券知识ID
     */
    private int novId;
    /**
     *  点赞数量
     */
    private int goods;
    /**
     *  评论时间
     */
    private String insertDate;
    /**
     *  回复数量
     */
    private int replyCount;
    /**
     *  是否显示（0是，1否）
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
