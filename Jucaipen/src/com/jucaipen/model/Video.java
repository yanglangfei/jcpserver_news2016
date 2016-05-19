package com.jucaipen.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author ylf           ---------数据已更新    5.18
 * 
 *   视频
 *
 */
@SuppressWarnings("serial")
public class Video implements Serializable{
	/**
	 *   视频id
	 */
	private int id;
	/**
	 * 视频标题
	 */
	private String title;
	/**
	 * 描述
	 */
	private String descript;
	/**
	 * 点击量
	 */
	private int HitCount;
	/**
	 *  虚拟播放数
	 */
	private int XnHitCount;
	/**
	 * 插入时间
	 */
	private String InsertDate;
	/**
	 * 视频发布日期
	 */
	private Date VideoDate;
	/**
	 * 分类id
	 */
	private int classId;
	/**
	 *   视频分类   0 免费    1  付费
	 */
	private int videoType;
	/**
	 *   应付金额
	 */
	private String allMoney;
	/**
	 *   实付金额
	 */
	private String payMoney;
	/**
	 *  所属讲师
	 */
	private int teacherId;
	/**
	 * 是否置顶　（　１　置顶　　０　非置顶　）
	 */
	private int IsTop;
	/**
	 *   是否精选   0  否   1  是
	 */
	private int isBest;
	/**
	 *  点赞数
	 */
	private int goods;
	/**
	 * 视频URL
	 */
	private String VideoUrl;
	/**
	 * 评论数
	 */
	private int CommCount;
	/**
	 * 关键字
	 */
	private String keyWords;
	/**
	 * 图片
	 */
	private String Images;
	/**
	 *  所属视频类型
	 */
	private int typeId;
	/**
	 *  所属内容分类，关联新闻大类
	 */
	private int contentId;
	/**
	 * 是否是本站视频　（　１　是　０　不是　）
	 */
	private int IsMySiteVideo;
	/**
	 *  所属专辑
	 */
	private int pecialId;
	/**
	 *  排序id
	 */
	private int sortId;
	/**
	 *   静态页面URL
	 */
	private String htmlUrl;	
	/**
	 * 　是否首页显示　（１　首页　　１　非首页显示）
	 */
	private int IsIndex;
	/**
	 * 是否推荐　（　１　推荐　　　　０　非推荐　）
	 */
	private int IsTuijian;
	
	
	public Video(int id, String title) {
		this.id = id;
		this.title = title;
	}
	public Video(int id, String title, String descript, int hitCount,
			int xnHitCount, String insertDate, Date videoDate, int classId,
			int videoType, String allMoney, String payMoney, int teacherId,
			int isTop, int isBest, int goods, String videoUrl, int commCount,
			String keyWords, String images, int typeId, int contentId,
			int isMySiteVideo, int pecialId, int sortId, String htmlUrl,
			int isIndex, int isTuijian) {
		super();
		this.id = id;
		this.title = title;
		this.descript = descript;
		HitCount = hitCount;
		XnHitCount = xnHitCount;
		InsertDate = insertDate;
		VideoDate = videoDate;
		this.classId = classId;
		this.videoType = videoType;
		this.allMoney = allMoney;
		this.payMoney = payMoney;
		this.teacherId = teacherId;
		IsTop = isTop;
		this.isBest = isBest;
		this.goods = goods;
		VideoUrl = videoUrl;
		CommCount = commCount;
		this.keyWords = keyWords;
		Images = images;
		this.typeId = typeId;
		this.contentId = contentId;
		IsMySiteVideo = isMySiteVideo;
		this.pecialId = pecialId;
		this.sortId = sortId;
		this.htmlUrl = htmlUrl;
		IsIndex = isIndex;
		IsTuijian = isTuijian;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getHitCount() {
		return HitCount;
	}
	public void setHitCount(int hitCount) {
		HitCount = hitCount;
	}
	public int getXnHitCount() {
		return XnHitCount;
	}
	public void setXnHitCount(int xnHitCount) {
		XnHitCount = xnHitCount;
	}
	public String getInsertDate() {
		return InsertDate;
	}
	public void setInsertDate(String insertDate) {
		InsertDate = insertDate;
	}
	public Date getVideoDate() {
		return VideoDate;
	}
	public void setVideoDate(Date videoDate) {
		VideoDate = videoDate;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getVideoType() {
		return videoType;
	}
	public void setVideoType(int videoType) {
		this.videoType = videoType;
	}
	public String getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}
	public String getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getIsTop() {
		return IsTop;
	}
	public void setIsTop(int isTop) {
		IsTop = isTop;
	}
	public int getIsBest() {
		return isBest;
	}
	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public String getVideoUrl() {
		return VideoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		VideoUrl = videoUrl;
	}
	public int getCommCount() {
		return CommCount;
	}
	public void setCommCount(int commCount) {
		CommCount = commCount;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getImages() {
		return Images;
	}
	public void setImages(String images) {
		Images = images;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getIsMySiteVideo() {
		return IsMySiteVideo;
	}
	public void setIsMySiteVideo(int isMySiteVideo) {
		IsMySiteVideo = isMySiteVideo;
	}
	public int getPecialId() {
		return pecialId;
	}
	public void setPecialId(int pecialId) {
		this.pecialId = pecialId;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
	public int getIsIndex() {
		return IsIndex;
	}
	public void setIsIndex(int isIndex) {
		IsIndex = isIndex;
	}
	public int getIsTuijian() {
		return IsTuijian;
	}
	public void setIsTuijian(int isTuijian) {
		IsTuijian = isTuijian;
	}
	
   	
	
	
}
