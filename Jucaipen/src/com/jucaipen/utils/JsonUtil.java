package com.jucaipen.utils;import java.util.List;import com.google.gson.Gson;import com.google.gson.JsonArray;import com.google.gson.JsonObject;import com.google.gson.reflect.TypeToken;import com.jucaipen.model.AccountDetail;import com.jucaipen.model.ApkInfo;import com.jucaipen.model.Ask;import com.jucaipen.model.ExpressionInfo;import com.jucaipen.model.ExpressionType;import com.jucaipen.model.FamousTeacher;import com.jucaipen.model.Fans;import com.jucaipen.model.Favorites;import com.jucaipen.model.GiftClass;import com.jucaipen.model.Gifts;import com.jucaipen.model.Guardian;import com.jucaipen.model.HotIdea;import com.jucaipen.model.InvestmentType;import com.jucaipen.model.Knowledge;import com.jucaipen.model.MyGifts;import com.jucaipen.model.MyPresent;import com.jucaipen.model.News;import com.jucaipen.model.NewsClass;import com.jucaipen.model.Comment;import com.jucaipen.model.OrderDetail;import com.jucaipen.model.Position;import com.jucaipen.model.Recommder;import com.jucaipen.model.StudioGuest;import com.jucaipen.model.TextLive;import com.jucaipen.model.User;import com.jucaipen.model.Video;import com.jucaipen.model.VideoLive;/** * @author ylf *  *         gson解析、封装json数据 */public class JsonUtil {	/**	 * @param json	 *            解析json	 */	public List<User> parseJson() {		String json = "[{'name':'张三'},{'name':'李四'}]";		Gson gson = new Gson();		List<User> user = gson.fromJson(json, new TypeToken<List<User>>() {		}.getType());		return user;	}	/**	 * @param news	 * @return 封装json数据	 */	public static String getObject(Object object) {		Gson gson = new Gson();		String json = gson.toJson(object);		return json;	}	public static String getRetMsg(int code, String msg) {		JsonObject object=new JsonObject();		object.addProperty("ret_code", code);		object.addProperty("err_msg",msg);		return object.toString();	}			/**	 * @param news	 * @return 返回新闻列表	 */	public static String getNewsList(List<News> news) {		JsonArray array = new JsonArray();		for (News ns : news) {			JsonObject object = new JsonObject();			object.addProperty("pager", ns.getPager());			object.addProperty("totlePager", ns.getTotlePager());			object.addProperty("id", ns.getId());			object.addProperty("title", ns.getTitle());			object.addProperty("comms", ns.getComments());			object.addProperty("insertDate", ns.getPublishDate());			object.addProperty("from", ns.getFrom());			array.add(object);		}		return array.toString();	}		/**	 * @param tvs	 * @return 返回视频列表	 */	public static String getVideoList(List<Video> tvs) {		JsonArray array = new JsonArray();		if(tvs!=null){			for (Video tv : tvs) {				JsonObject object = new JsonObject();				object.addProperty("id", tv.getId());				object.addProperty("title", tv.getTitle());				object.addProperty("imageUrl", tv.getImages());				object.addProperty("desc",tv.getDescript());				array.add(object);			}		}		return array.toString();	}			/**	 * @param famousTeachers	 * @return 获取推荐名师	 */	public static String getFamousTeacherList(List<FamousTeacher> famousTeachers) {		JsonArray array = new JsonArray();		for (FamousTeacher famousTeacher : famousTeachers) {			JsonObject object = new JsonObject();			object.addProperty("page", famousTeacher.getPage());			object.addProperty("totlePage", famousTeacher.getTotlePage());			object.addProperty("id", famousTeacher.getId());			object.addProperty("nickName", famousTeacher.getNickName());			object.addProperty("headFace", famousTeacher.getHeadFace());			object.addProperty("level", famousTeacher.getLevel());			object.addProperty("isV", famousTeacher.getIsV());			object.addProperty("notice", famousTeacher.getNotice());			object.addProperty("fans", famousTeacher.getFans());			array.add(object);		}		return array.toString();	}	/**	 * @param live	 * @return   视频资源URL	 */	public static String getLiveUrl(VideoLive live) {		JsonObject object=new JsonObject();		object.addProperty("liveUrl", live.getVideoUrl());		return object.toString();	}			/**	 * @param hotIdeas	 * @param teachers	 * @return 获取所有的热门观点信息	 */	public static String getAllHotIdeaList(List<HotIdea> hotIdeas,			List<FamousTeacher> teachers) {		JsonArray array = new JsonArray();		for (int i = 0; i < teachers.size(); i++) {			JsonObject object = new JsonObject();			object.addProperty("page", hotIdeas.get(i).getPage());			object.addProperty("totlePage", hotIdeas.get(i).getTotlePgae());			object.addProperty("id", hotIdeas.get(i).getId());			object.addProperty("insertDate", hotIdeas.get(i).getInsertDate());			object.addProperty("title", hotIdeas.get(i).getTitle());			object.addProperty("bodys",					StringUtil.clearHTMLCode(hotIdeas.get(i).getBodys()));			object.addProperty("hits", hotIdeas.get(i).getHits());			object.addProperty("goods", hotIdeas.get(i).getGoods());			object.addProperty("teacherId", teachers.get(i).getId());			object.addProperty("nickName", teachers.get(i).getNickName());			object.addProperty("level", teachers.get(i).getLevel());			object.addProperty("headFace", teachers.get(i).getHeadFace());			object.addProperty("isV", teachers.get(i).getIsV());			array.add(object);		}		return array.toString();	}	/**	 * @param askList	 * @param users	 * @return 获取提问列表	 */	public static String getAskList(List<Ask> askList, List<User> users) {		JsonArray array = new JsonArray();		for (int i = 0; i < askList.size(); i++) {			JsonObject object = new JsonObject();			object.addProperty("page", askList.get(i).getPage());			object.addProperty("totlePage", askList.get(i).getTotlePage());			object.addProperty("askId", askList.get(i).getId());			object.addProperty("trueName", users.get(i).getTrueName());			object.addProperty("insertDate", askList.get(i).getAskDate());			object.addProperty("askBodys", askList.get(i).getAskBody());			object.addProperty("headFace", users.get(i).getFaceImage());			// 1 回复 2 未回复			object.addProperty("isReply", askList.get(i).getIsReply());			array.add(object);		}		return array.toString();	}	/**	 * @param txtLives	 * @param teachers 	 * @return   获取文字直播列表	 */	public static String getTxtLiveList(List<TextLive> txtLives, List<FamousTeacher> teachers) {		JsonArray array=new JsonArray();		for(int i=0;i<txtLives.size();i++){			JsonObject object=new JsonObject();			object.addProperty("id", txtLives.get(i).getId());			object.addProperty("title", txtLives.get(i).getTitle());			object.addProperty("headImage", teachers.get(i).getHeadFace());			array.add(object);		}		return array.toString();	}			/**	 * @param videos	 * @param teachers	 * @return  获取视频直播列表	 */	public static String getLiveList(List<VideoLive> videos,			List<FamousTeacher> teachers) {		JsonArray array=new JsonArray();		for(int i=0;i<videos.size();i++){		  	JsonObject object=new JsonObject();		  	object.addProperty("id",videos.get(i).getId());		  	object.addProperty("title",videos.get(i).getTitle());		  	object.addProperty("headFace",teachers.get(i).getHeadFace());		  	array.add(object);		}		return array.toString();	}	/**	 * @param videos	 * @return   获取学院教学视频	 */	public static String getTeachVideList(List<Video> videos) {		JsonArray array=new JsonArray();		for(Video video : videos){			JsonObject object=new JsonObject();			object.addProperty("id",video.getId());			object.addProperty("title",video.getTitle());			object.addProperty("desc",video.getDescript());			object.addProperty("insertDate", video.getInsertDate());			object.addProperty("hits", video.getHitCount());			object.addProperty("image", video.getImages());			array.add(object);		}		return array.toString();	}	/**	 * @param askClasses	 * @return 获取咨询分类信息	 */	public static String getAskClassList(List<NewsClass> types) {		JsonArray array = new JsonArray();		for (NewsClass type : types) {			JsonObject object = new JsonObject();			object.addProperty("classId", type.getId());			object.addProperty("typeName", type.getClassName());			array.add(object);		}		return array.toString();	}		/**	 * @param news	 * @param names	 * @return   获取相关新闻信息  	 */	public static String getIndxKnownList(List<News> news) {		JsonArray array=new JsonArray();		for(News n : news){			JsonObject object=new JsonObject();			object.addProperty("id", n.getId());			object.addProperty("title", n.getTitle());			object.addProperty("from", n.getFrom());			object.addProperty("comms", n.getComments());			object.addProperty("insertDate",n.getPublishDate());			object.addProperty("image",n.getImageUrl());			array.add(object);		}		return array.toString();	}			/**	 * @param comms	 * @param users	 * @return 返回热门观点评论列表	 *//*	public static String getIdeaCommList(List<LogCommen> comms, List<User> users) {		JsonArray array = new JsonArray();		for (int i = 0; i < comms.size(); i++) {			JsonObject object = new JsonObject();			object.addProperty("page", comms.get(i).getPage());			object.addProperty("totlePage", comms.get(i).getTotlePage());			object.addProperty("commId", comms.get(i).getId());			object.addProperty("insertDate", comms.get(i).getInsertDate());			object.addProperty("commBody", comms.get(i).getBodys());			object.addProperty("goods", comms.get(i).getGoods());			object.addProperty("repCount", comms.get(i).getRepCount());			object.addProperty("trueName", users.get(i).getTrueName());			object.addProperty("faceImage", users.get(i).getFaceImage());			array.add(object);		}		return array.toString();	}*/	/**	 * @param nComments	 * @param users	 * @return 获取新闻评论信息 ()	 */	public static String getNewsCommList(List<Comment> nComments,			List<User> users) {				return null;					}		/**	 * @param user	 * @param localArea	 * @param localCity	 * @param localProvince	 * @return 返回用户信息	 */	public static String getUserInfo(User user, String localProvince,			String localCity, String localArea) {		JsonObject object = new JsonObject();		object.addProperty("userName", user.getNickName());		object.addProperty("telPhone", user.getMobileNum());		object.addProperty("sex", user.getSex());		object.addProperty("birthday", user.getBirthday());		object.addProperty("email", user.getEmail());		object.addProperty("localProvince", localProvince);		object.addProperty("localCity", localCity);		object.addProperty("localArea", localArea);		object.addProperty("localProId", user.getProvinceId());		object.addProperty("localCityId", user.getCityId());		object.addProperty("localAreaId", user.getAreaId());		object.addProperty("descript", user.getDescript());		object.addProperty("faceImage", user.getFaceImage());		object.addProperty("reginFrom", user.getRegDate());		return object.toString();	}	/**	 * @param types	 * @return 获取表情分类信息	 */	public static String getExpressionType(List<ExpressionType> types) {		JsonArray array = new JsonArray();		for (ExpressionType type : types) {			JsonObject object = new JsonObject();			object.addProperty("id", type.getId());			object.addProperty("typeName", type.getClassName());			array.add(object);		}		return array.toString();	}		/**	 * @param infos	 * @return 获取表情包下对应的表情	 */	public static String getExpressionInfo(List<ExpressionInfo> infos) {		JsonArray array = new JsonArray();		for (ExpressionInfo info : infos) {			JsonObject object = new JsonObject();			object.addProperty("id", info.getId());			object.addProperty("typeId", info.getClassId());			object.addProperty("title", info.getName());			object.addProperty("faceUrl", info.getFaceurl());			array.add(object);		}		return array.toString();	}		/**	 * @param info	 * @return 获取最新apk版本信息	 */	public static String getApkInfo(ApkInfo info) {		JsonObject object = new JsonObject();		object.addProperty("ret_code", 0);		object.addProperty("versionCode", info.getVersionCode());		object.addProperty("apkUrl", info.getApkPath());		return object.toString();	}		/**	 * @param id	 * @return 返回登录结果	 */	public static String getLoginResult(User user) {		JsonObject object = new JsonObject();		object.addProperty("ret_code", 0);		object.addProperty("userId", user.getId());		object.addProperty("isSys", user.getIsSysAdmin());		object.addProperty("isRoom", user.getIsRoomAdmin());		object.addProperty("reginDate", user.getRegDate());		object.addProperty("tureName", user.getTrueName());		object.addProperty("err_msg", "登录成功");		return object.toString();	}		/**	 * @param user	 * @return 返回用户第三方账号id	 */	public static String getOtherAccountList(User user) {		JsonObject object = new JsonObject();		object.addProperty("ret_code", 0);		object.addProperty("qqId", user.getQqId());		object.addProperty("weixinId", user.getWeiXinId());		object.addProperty("sinaId", user.getWeiBoId());		return object.toString();	}	/**	 * @param gifts	 * @return 获取礼品列表	 */	public static String getGiftList(List<Gifts> gifts) {		JsonArray array=new JsonArray();		for(Gifts g : gifts){			JsonObject object=new JsonObject();			object.addProperty("page", g.getPage());			object.addProperty("totlePage", g.getTotlePage());			object.addProperty("id",g.getId());			object.addProperty("name", g.getTitle());			object.addProperty("price",g.getPrice());			object.addProperty("thumbnail",g.getThumbnail());			array.add(object);		}		return array.toString();	}	/**	 *   返回礼品分类信息	 */	public static String getGiftClass(List<GiftClass> gcs) {		JsonArray array=new JsonArray();		for(GiftClass gc : gcs){			JsonObject object=new JsonObject();			object.addProperty("id",gc.getId());			object.addProperty("className", gc.getClassName());			array.add(object);		}		return array.toString();	}	/**	 * @param recommders	 * @param users 	 * @return  获取我的推荐列表	 */	public static String getRecommderList(List<Recommder> recommders, List<User> users) {		JsonArray array=new JsonArray();		for(int i=0;i<recommders.size();i++){			JsonObject object=new JsonObject();			object.addProperty("page", recommders.get(i).getPage());			object.addProperty("totlePage", recommders.get(i).getTotlePage());			object.addProperty("id", recommders.get(i).getId());			object.addProperty("recommderDate", recommders.get(i).getInsertDate());			object.addProperty("recommder", users.get(i).getTrueName());			object.addProperty("recommderPhone", users.get(i).getMobileNum());			object.addProperty("recommderImage", users.get(i).getFaceImage());			array.add(object);		}		return array.toString();	}	/**	 * @param presents	 * @param gifts	 * @return  获取我拥有的礼品列表	 */	public static String getMyPresentList(List<MyPresent> presents,			List<Gifts> gifts) {		JsonArray array=new JsonArray();		for(int i=0;i<presents.size();i++){			JsonObject object=new JsonObject();			object.addProperty("page", presents.get(i).getPage());			object.addProperty("totlePage", presents.get(i).getTotlePage());			object.addProperty("presentNum", presents.get(i).getPresentNum());			object.addProperty("presentName", gifts.get(i).getTitle());			object.addProperty("presentImage", gifts.get(i).getThumbnail());			array.add(object);		}		return array.toString();	}	/**	 * @param gifts	 * @param gList	 * @return 初始化我的礼品记录	 */	public static String getGiftRecoder(List<MyGifts> gifts, List<Gifts> gList) {		JsonArray array=new JsonArray();		for(int i=0;i<gifts.size();i++){			JsonObject object=new JsonObject();			object.addProperty("page", gifts.get(i).getPage());			object.addProperty("totlePage", gifts.get(i).getTotlePage());			object.addProperty("id", gifts.get(i).getId());			object.addProperty("giftNum",gifts.get(i).getGiftNum());			object.addProperty("giftTitle",gList.get(i).getTitle());			object.addProperty("giftImage", gList.get(i).getThumbnail());			array.add(object);		}		return array.toString();	}	/**	 * @param positions	 * @return  获取岗位信息	 */	public static String getPositionlist(List<Position> positions) {		JsonArray array=new JsonArray();		for(Position position : positions){			JsonObject object=new JsonObject();			object.addProperty("id",position.getId());			object.addProperty("name",position.getName());			array.add(object);		}		return array.toString();	}	/**	 * @param types	 * @return  返回投资风格信息	 */	public static String getInvestType(List<InvestmentType> types) {		JsonArray array=new JsonArray();		for(InvestmentType type :types){			JsonObject object=new JsonObject();			object.addProperty("id",type.getId());			object.addProperty("name", type.getTypeName());			array.add(object);		}		return array.toString();	}	/**	 * @param favourates	 * @param videos	 * @return  返回收藏视频信息	 */	public static String getFavourateVideos(List<Favorites> favourates,			List<Video> videos) {		JsonArray array=new JsonArray();		for(int i=0;i<favourates.size();i++){			JsonObject object=new JsonObject();			object.addProperty("id",favourates.get(i).getId());			object.addProperty("insertDate", favourates.get(i).getDate());			object.addProperty("title", videos.get(i).getTitle());			array.add(object);		}		return array.toString();	}	/**	 * @param favourates	 * @param knowledges	 * @return  返回知识信息	 */	public static String getFavourateKnowledge(List<Favorites> favourates,			List<Knowledge> knowledges) {		JsonArray array=new JsonArray();		for(int i=0;i<favourates.size();i++){			JsonObject object=new JsonObject();			object.addProperty("id",favourates.get(i).getId());			object.addProperty("insertDate", favourates.get(i).getDate());			object.addProperty("title", knowledges.get(i).getTitle());			array.add(object);		}		return array.toString();	}	/**	 * @param fans	 * @param users	 * @return  返回用户关注讲师信息	 */	public static String getUserAttention(List<Fans> fans, List<User> users) {				return null;	}	/**	 * @param fans	 * @param teachers	 * @return  返回关注我的信息（针对讲师）	 */	public static String getTeacherAttention(List<Fans> fans,			List<FamousTeacher> teachers) {		JsonArray array=new JsonArray();		for(int i=0;i<fans.size();i++){			JsonObject object=new JsonObject();			object.addProperty("page",fans.get(i).getPage());			object.addProperty("totlePage",fans.get(i).getTotlePage());			object.addProperty("id",fans.get(i).getId());			object.addProperty("teacherImage", teachers.get(i).getHeadFace());			object.addProperty("nickName",teachers.get(i).getNickName());			object.addProperty("isV", teachers.get(i).getIsV());			object.addProperty("notice",teachers.get(i).getNotice());			object.addProperty("fans", teachers.get(i).getFans());			object.addProperty("leavel", teachers.get(i).getLevel());			array.add(object);		}		return array.toString();	}	/**	 * @param guardians	 * @param users	 * @return  守护我的   (针对讲师)	 */	public static String getGuardianMy(List<Guardian> guardians,			List<User> users) {				return null;	}	/**	 * @param guardians	 * @param teachers	 * @return 我守护的	 */	public static String getMyGuardian(List<Guardian> guardians,			List<FamousTeacher> teachers) {		JsonArray array=new JsonArray();		for(int i=0;i<guardians.size();i++){			JsonObject object=new JsonObject();			object.addProperty("page",guardians.get(i).getPage());			object.addProperty("totlePage",guardians.get(i).getTotlePage());			object.addProperty("id",guardians.get(i).getId());			object.addProperty("startDate",guardians.get(i).getStartDate());			object.addProperty("endDate",guardians.get(i).getEndDate());			object.addProperty("teacherImage",teachers.get(i).getHeadFace());			object.addProperty("nickName",teachers.get(i).getNickName());			object.addProperty("leavel",teachers.get(i).getLevel());			object.addProperty("isV",teachers.get(i).getIsV());			object.addProperty("introduce",teachers.get(i).getIntroduce());			array.add(object);		}		return array.toString();	}	/**	 * @param details	 * @return 获取账单详细信息	 */	public static String getAccountDetail(List<AccountDetail> details) {		JsonArray array=new JsonArray();		for(AccountDetail detail : details){			JsonObject object=new JsonObject();			object.addProperty("page",detail.getPage());			object.addProperty("totlePage",detail.getTotlePage());			object.addProperty("id",detail.getId());			object.addProperty("insertDate",detail.getInsertDate());			object.addProperty("orderCode", detail.getOrderCode());			object.addProperty("detailMoney", detail.getDetailMoney());			array.add(object);		}		return array.toString();	}	/**	 * @param details	 * @return 获取订单详细信息	 */	public static String getOrderDetail(List<OrderDetail> details) {		JsonArray array=new JsonArray();		for(OrderDetail detail : details){			JsonObject object=new JsonObject();			object.addProperty("page",detail.getPage());			object.addProperty("totlePage",detail.getTotlePage());			object.addProperty("id",detail.getId());			object.addProperty("title",detail.getProductTitle());			object.addProperty("price",detail.getPrice());			object.addProperty("buyCount",detail.getBuyCount());			object.addProperty("type",detail.getProductType());			array.add(object);		}		return array.toString();	}	/**	 * @param guests	 * @return  获取演播室嘉宾信息	 */	public static String getGuests(List<StudioGuest> guests) {		JsonArray array=new JsonArray();		for(int i=0;i<guests.size();i++){			JsonObject object=new JsonObject();			object.addProperty("id",guests.get(i).getId());			object.addProperty("headFace",guests.get(i).getHeadFace());			object.addProperty("nickName",guests.get(i).getName());			object.addProperty("leavel",guests.get(i).getLeavl());			array.add(object);		}		return array.toString();	}	}