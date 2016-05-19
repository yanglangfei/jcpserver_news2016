package com.jucaipen.utils;import java.util.List;import com.google.gson.Gson;import com.google.gson.JsonArray;import com.google.gson.JsonObject;import com.google.gson.reflect.TypeToken;import com.jucaipen.model.ApkInfo;import com.jucaipen.model.Ask;import com.jucaipen.model.AskClass;import com.jucaipen.model.ChatRoom;import com.jucaipen.model.ExpressionInfo;import com.jucaipen.model.ExpressionType;import com.jucaipen.model.FamousTeacher;import com.jucaipen.model.HotIdea;import com.jucaipen.model.LogCommen;import com.jucaipen.model.News;import com.jucaipen.model.NewsComment;import com.jucaipen.model.TextLive;import com.jucaipen.model.User;import com.jucaipen.model.Video;/** * @author ylf *  *         gson解析、封装json数据 */public class JsonUtil {	/**	 * @param json	 *            解析json	 */	public List<User> parseJson() {		String json = "[{'name':'张三'},{'name':'李四'}]";		Gson gson = new Gson();		List<User> user = gson.fromJson(json, new TypeToken<List<User>>() {		}.getType());		return user;	}	/**	 * @param news	 * @return 封装json数据	 */	public static String getObject(Object object) {		Gson gson = new Gson();		String json = gson.toJson(object);		return json;	}	public static String getRetMsg(int code, String msg) {		JsonObject object=new JsonObject();		object.addProperty("ret_code", code);		object.addProperty("err_msg",msg);		return object.toString();	}			/**	 * @param news	 * @return 返回新闻列表	 */	public static String getNewsList(List<News> news) {		JsonArray array = new JsonArray();		for (News ns : news) {			JsonObject object = new JsonObject();			object.addProperty("pager", ns.getPager());			object.addProperty("totlePager", ns.getTotlePager());			object.addProperty("id", ns.getId());			object.addProperty("title", ns.getTitle());			object.addProperty("comms", ns.getComments());			object.addProperty("insertDate", ns.getPublishDate());			object.addProperty("from", ns.getFrom());			array.add(object);		}		return array.toString();	}		/**	 * @param tvs	 * @return 返回视频列表	 */	public static String getVideoList(List<Video> tvs) {		JsonArray array = new JsonArray();		if(tvs!=null){			for (Video tv : tvs) {				JsonObject object = new JsonObject();				object.addProperty("id", tv.getId());				object.addProperty("title", tv.getTitle());				object.addProperty("imageUrl", tv.getImages());				object.addProperty("desc",tv.getDescript());				array.add(object);			}		}		return array.toString();	}			/**	 * @param famousTeachers	 * @return 获取推荐名师	 */	public static String getFamousTeacherList(List<FamousTeacher> famousTeachers) {		JsonArray array = new JsonArray();		for (FamousTeacher famousTeacher : famousTeachers) {			JsonObject object = new JsonObject();			object.addProperty("page", famousTeacher.getPage());			object.addProperty("totlePage", famousTeacher.getTotlePage());			object.addProperty("id", famousTeacher.getId());			object.addProperty("nickName", famousTeacher.getNickName());			object.addProperty("headFace", famousTeacher.getHeadFace());			object.addProperty("level", famousTeacher.getLevel());			object.addProperty("isV", famousTeacher.getIsV());			object.addProperty("notice", famousTeacher.getNotice());			object.addProperty("fans", famousTeacher.getFans());			array.add(object);		}		return array.toString();	}	/**	 * @param live	 * @return   视频资源URL	 */	public static String getLiveUrl(ChatRoom live) {		JsonObject object=new JsonObject();		object.addProperty("liveUrl", live.getLiveUrl());		return object.toString();	}			/**	 * @param hotIdeas	 * @param teachers	 * @return 获取所有的热门观点信息	 */	public static String getAllHotIdeaList(List<HotIdea> hotIdeas,			List<FamousTeacher> teachers) {		JsonArray array = new JsonArray();		for (int i = 0; i < teachers.size(); i++) {			JsonObject object = new JsonObject();			object.addProperty("page", hotIdeas.get(i).getPage());			object.addProperty("totlePage", hotIdeas.get(i).getTotlePgae());			object.addProperty("id", hotIdeas.get(i).getId());			object.addProperty("insertDate", hotIdeas.get(i).getInsertDate());			object.addProperty("title", hotIdeas.get(i).getTitle());			object.addProperty("bodys",					StringUtil.clearHTMLCode(hotIdeas.get(i).getBodys()));			object.addProperty("hits", hotIdeas.get(i).getHits());			object.addProperty("goods", hotIdeas.get(i).getGoods());			object.addProperty("teacherId", teachers.get(i).getId());			object.addProperty("nickName", teachers.get(i).getNickName());			object.addProperty("level", teachers.get(i).getLevel());			object.addProperty("headFace", teachers.get(i).getHeadFace());			object.addProperty("isV", teachers.get(i).getIsV());			array.add(object);		}		return array.toString();	}	/**	 * @param askList	 * @param users	 * @return 获取提问列表	 */	public static String getAskList(List<Ask> askList, List<User> users) {		JsonArray array = new JsonArray();		for (int i = 0; i < askList.size(); i++) {			JsonObject object = new JsonObject();			object.addProperty("page", askList.get(i).getPage());			object.addProperty("totlePage", askList.get(i).getTotlePage());			object.addProperty("askId", askList.get(i).getId());			object.addProperty("trueName", users.get(i).getTrueName());			object.addProperty("insertDate", askList.get(i).getAskDate());			object.addProperty("askBodys", askList.get(i).getAskBody());			object.addProperty("headFace", users.get(i).getFaceImage());			// 1 回复 2 未回复			object.addProperty("isReply", askList.get(i).getIsReply());			array.add(object);		}		return array.toString();	}	/**	 * @param txtLives	 * @param teachers 	 * @return   获取文字直播列表	 */	public static String getTxtLiveList(List<TextLive> txtLives, List<FamousTeacher> teachers) {		JsonArray array=new JsonArray();		for(int i=0;i<txtLives.size();i++){			JsonObject object=new JsonObject();			object.addProperty("id", txtLives.get(i).getId());			object.addProperty("title", txtLives.get(i).getTitle());			object.addProperty("headImage", teachers.get(i).getHeadFace());			array.add(object);		}		return array.toString();	}	/**	 * @param videos	 * @return   获取学院教学视频	 */	public static String getTeachVideList(List<Video> videos) {		JsonArray array=new JsonArray();		for(Video video : videos){			JsonObject object=new JsonObject();			object.addProperty("id",video.getId());			object.addProperty("title",video.getTitle());			object.addProperty("desc",video.getDescript());			object.addProperty("insertDate", video.getInsertDate());			object.addProperty("hits", video.getHitCount());			object.addProperty("image", video.getImages());			array.add(object);		}		return array.toString();	}	/**	 * @param askClasses	 * @return 获取咨询分类信息	 */	public static String getAskClassList(List<AskClass> askClasses) {		JsonArray array = new JsonArray();		for (AskClass askType : askClasses) {			JsonObject object = new JsonObject();			object.addProperty("classId", askType.getId());			object.addProperty("typeName", askType.getClassName());			array.add(object);		}		return array.toString();	}		/**	 * @param news	 * @param names	 * @return   获取相关新闻信息  	 */	public static String getIndxKnownList(List<News> news) {		JsonArray array=new JsonArray();		for(News n : news){			JsonObject object=new JsonObject();			object.addProperty("id", n.getId());			object.addProperty("title", n.getTitle());			object.addProperty("from", n.getFrom());			object.addProperty("comms", n.getComments());			object.addProperty("insertDate",n.getPublishDate());			object.addProperty("image",n.getImageUrl());			array.add(object);		}		return array.toString();	}			/**	 * @param comms	 * @param users	 * @return 返回热门观点评论列表	 */	public static String getIdeaCommList(List<LogCommen> comms, List<User> users) {		JsonArray array = new JsonArray();		for (int i = 0; i < comms.size(); i++) {			JsonObject object = new JsonObject();			object.addProperty("page", comms.get(i).getPage());			object.addProperty("totlePage", comms.get(i).getTotlePage());			object.addProperty("commId", comms.get(i).getId());			object.addProperty("insertDate", comms.get(i).getInsertDate());			object.addProperty("commBody", comms.get(i).getBodys());			object.addProperty("goods", comms.get(i).getGoods());			object.addProperty("repCount", comms.get(i).getRepCount());			object.addProperty("trueName", users.get(i).getTrueName());			object.addProperty("faceImage", users.get(i).getFaceImage());			array.add(object);		}		return array.toString();	}	/**	 * @param nComments	 * @param users	 * @return 获取新闻评论信息 ()	 */	public static String getNewsCommList(List<NewsComment> nComments,			List<User> users) {		JsonArray array = new JsonArray();		for (int i = 0; i < nComments.size(); i++) {			JsonObject object = new JsonObject();			object.addProperty("page",nComments.get(i).getPager());			object.addProperty("totlePage", nComments.get(i).getTotlePager());			object.addProperty("id", nComments.get(i).getId());			object.addProperty("newsId", nComments.get(i).getnId());			object.addProperty("goodCount", nComments.get(i).getGoodNum());			object.addProperty("replyCount", nComments.get(i).getRepCount());			if(users.get(i)!=null){			object.addProperty("trueName", users.get(i).getTrueName());			object.addProperty("userLogo", users.get(i).getFaceImage());			}else{  				object.addProperty("userName", "");				object.addProperty("userLogo", "");			}			object.addProperty("insertDate", nComments.get(i).getInsertDate());			object.addProperty("body", nComments.get(i).getBodys());			array.add(object);		}		return array.toString();	}		/**	 * @param user	 * @param localArea	 * @param localCity	 * @param localProvince	 * @return 返回用户信息	 */	public static String getUserInfo(User user, String localProvince,			String localCity, String localArea) {		JsonObject object = new JsonObject();		object.addProperty("userName", user.getNickName());		object.addProperty("telPhone", user.getMobileNum());		object.addProperty("sex", user.getSex());		object.addProperty("birthday", user.getBirthday());		object.addProperty("email", user.getEmail());		object.addProperty("localProvince", localProvince);		object.addProperty("localCity", localCity);		object.addProperty("localArea", localArea);		object.addProperty("localProId", user.getProvinceId());		object.addProperty("localCityId", user.getCityId());		object.addProperty("localAreaId", user.getAreaId());		object.addProperty("descript", user.getDescript());		object.addProperty("faceImage", user.getFaceImage());		object.addProperty("reginFrom", user.getRegDate());		return object.toString();	}	/**	 * @param types	 * @return 获取表情分类信息	 */	public static String getExpressionType(List<ExpressionType> types) {		JsonArray array = new JsonArray();		for (ExpressionType type : types) {			JsonObject object = new JsonObject();			object.addProperty("id", type.getId());			object.addProperty("typeName", type.getClassName());			array.add(object);		}		return array.toString();	}		/**	 * @param infos	 * @return 获取表情包下对应的表情	 */	public static String getExpressionInfo(List<ExpressionInfo> infos) {		JsonArray array = new JsonArray();		for (ExpressionInfo info : infos) {			JsonObject object = new JsonObject();			object.addProperty("id", info.getId());			object.addProperty("typeId", info.getClassId());			object.addProperty("title", info.getTitle());			object.addProperty("faceUrl", info.getFaceurl());			array.add(object);		}		return array.toString();	}		/**	 * @param info	 * @return 获取最新apk版本信息	 */	public static String getApkInfo(ApkInfo info) {		JsonObject object = new JsonObject();		object.addProperty("ret_code", 0);		object.addProperty("versionCode", info.getVersionCode());		object.addProperty("apkUrl", info.getApkPath());		return object.toString();	}		/**	 * @param id	 * @return 返回登录结果	 */	public static String getLoginResult(User user) {		JsonObject object = new JsonObject();		object.addProperty("ret_code", 0);		object.addProperty("userId", user.getId());		object.addProperty("isSys", user.getIsSysAdmin());		object.addProperty("isRoom", user.getIsRoomAdmin());		object.addProperty("reginDate", user.getRegDate());		object.addProperty("tureName", user.getTrueName());		object.addProperty("err_msg", "登录成功");		return object.toString();	}		/**	 * @param user	 * @return 返回用户第三方账号id	 */	public static String getOtherAccountList(User user) {		JsonObject object = new JsonObject();		object.addProperty("ret_code", 0);		object.addProperty("qqId", user.getQqId());		object.addProperty("weixinId", user.getWeiXinId());		object.addProperty("sinaId", user.getWeiBoId());		return object.toString();	}}