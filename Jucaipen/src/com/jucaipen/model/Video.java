package com.jucaipen.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author ylf
 * 
 *   ѧ����Ƶ
 *
 */
@SuppressWarnings("serial")
public class Video implements Serializable{
	/**
	 *   ��Ƶid
	 */
	private int id;
	/**
	 * ��Ƶ����
	 */
	private String title;
	/**
	 * �ؼ���
	 */
	private String keyWords;
	/**
	 * ����
	 */
	private String descript;
	/**
	 * ����id
	 */
	private int classId;
	/**
	 * ͼƬ
	 */
	private String Images;
	/**
	 * ����ͼ
	 */
	private String ImagesThumb;
	/**
	 * ��ƵURL
	 */
	private String VideoUrl;
	/**
	 * ��Ƶ����
	 */
	private Date VideoDate;
	/**
	 * �����
	 */
	private int HitCount;
	/**
	 * ����ʱ��
	 */
	private String InsertDate;
	/**
	 * ������Ϣ
	 */
	private String body;
	/**
	 * �ڿν�ʦid
	 */
	private int TearcherId;
	/**
	 * ������
	 */
	private int CommCount;
	/**
	 * ���Ƿ���ҳ��ʾ����������ҳ������������ҳ��ʾ��
	 */
	private int IsIndex;
	/**
	 * �Ƿ��Ƽ������������Ƽ����������������Ƽ�����
	 */
	private int IsTuijian;
	/**
	 * �Ƿ��ö������������ö������������ö�����
	 */
	private int IsTop;
	/**
	 * ���Ƿ񹫿��Ρ����������ǡ������������ǡ���
	 */
	private int IsPublic;
	/**
	 * �Ƿ��Ǳ�վ��Ƶ�����������ǡ��������ǡ���
	 */
	private int IsMySiteVideo;
	
	public Video(int id, String title) {
		this.id = id;
		this.title = title;
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
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getImages() {
		return Images;
	}
	public void setImages(String images) {
		Images = images;
	}
	public String getImagesThumb() {
		return ImagesThumb;
	}
	public void setImagesThumb(String imagesThumb) {
		ImagesThumb = imagesThumb;
	}
	public String getVideoUrl() {
		return VideoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		VideoUrl = videoUrl;
	}
	public Date getVideoDate() {
		return VideoDate;
	}
	public void setVideoDate(Date videoDate) {
		VideoDate = videoDate;
	}
	public int getHitCount() {
		return HitCount;
	}
	public void setHitCount(int hitCount) {
		HitCount = hitCount;
	}
	public String getInsertDate() {
		return InsertDate;
	}
	public void setInsertDate(String insertDate) {
		InsertDate = insertDate;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getTearcherId() {
		return TearcherId;
	}
	public void setTearcherId(int tearcherId) {
		TearcherId = tearcherId;
	}
	public int getCommCount() {
		return CommCount;
	}
	public void setCommCount(int commCount) {
		CommCount = commCount;
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
	public int getIsTop() {
		return IsTop;
	}
	public void setIsTop(int isTop) {
		IsTop = isTop;
	}
	public int getIsPublic() {
		return IsPublic;
	}
	public void setIsPublic(int isPublic) {
		IsPublic = isPublic;
	}
	public int getIsMySiteVideo() {
		return IsMySiteVideo;
	}
	public void setIsMySiteVideo(int isMySiteVideo) {
		IsMySiteVideo = isMySiteVideo;
	}
	
	
	
}
