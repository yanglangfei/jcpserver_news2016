package com.jucaipen.model;

/**
 * @author Administrator   --------------------��������
 *
 *  ֪ʶ
 */
public class Knowledge {
	/**
	 *  ��ǰҳ
	 */
	private int page;
	/**
	 *  ��ҳ��
	 */
	private int totlePage;
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  Title
	 */
	private String title;
	/**
	 *  KeyWord
	 */
	private String keyWord;
	/**
	 *  Bodys
	 */
	private String bodys;
	/**
	 *  ������� FK_ClassId
	 */
	private int fk_ClassId;
	/**
	 *  �Ķ���  HitCount
	 */
	private int hits;
	/**
	 *  �����Ķ���  HitXNCount
	 */
	private int xnHits;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  ������Դ FK_FromId
	 */
	private int fromId;
	/**
	 *  ������ FaBuRen
	 */
	private String faBuRen;
	/**
	 *  ����ͼ  ImageUrl
	 */
	private String imageUrl;
	/**
	 *  ����  ZuoZhe
	 */
	private String zuozhe;
	/**
	 *  ��̬ҳ��URL PageUrl
	 */
	private String pageUrl;
	/**
	 * ��   Zan
	 */
	private int goods;
	/**
	 *  ������  CommonCount
	 */
	private int comms;
	/**
	 *  IsTop
	 */
	private int isTop;
	/**
	 *  �Ƿ�ѡ  IsJingXuan
	 */
	private int isBest;
	/**
	 * ժҪ  ZhaiYao
	 */
	private String zhaiYao;
	/**
	 *  IsIndex
	 */
	private int isIndex;
	/**
	 *  �Ƿ��Ƽ�  IsTuiJian
	 */
	private int isRecomm;
	/**
	 *  ����id  SortId
	 */
	private int sortId;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public int getFk_ClassId() {
		return fk_ClassId;
	}
	public void setFk_ClassId(int fk_ClassId) {
		this.fk_ClassId = fk_ClassId;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getXnHits() {
		return xnHits;
	}
	public void setXnHits(int xnHits) {
		this.xnHits = xnHits;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public String getFaBuRen() {
		return faBuRen;
	}
	public void setFaBuRen(String faBuRen) {
		this.faBuRen = faBuRen;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getZuozhe() {
		return zuozhe;
	}
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getComms() {
		return comms;
	}
	public void setComms(int comms) {
		this.comms = comms;
	}
	public int getIsTop() {
		return isTop;
	}
	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}
	public int getIsBest() {
		return isBest;
	}
	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}
	public String getZhaiYao() {
		return zhaiYao;
	}
	public void setZhaiYao(String zhaiYao) {
		this.zhaiYao = zhaiYao;
	}
	public int getIsIndex() {
		return isIndex;
	}
	public void setIsIndex(int isIndex) {
		this.isIndex = isIndex;
	}
	public int getIsRecomm() {
		return isRecomm;
	}
	public void setIsRecomm(int isRecomm) {
		this.isRecomm = isRecomm;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
}
