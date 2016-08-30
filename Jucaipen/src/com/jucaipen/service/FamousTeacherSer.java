package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.FamousTeacherDao;
import com.jucaipen.daoimp.FamousTeacherImp;
import com.jucaipen.model.FamousTeacher;

public class FamousTeacherSer {

	/**
	 * @return 获取所有讲师信息   分页
	 */
	public static List<FamousTeacher> findAllFamousTeacher(int page) {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findAllFamousTeacher(page);
	}
	
	public static FamousTeacher findFamousTeacherByUserId(int userId){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findFamousTeacherByUserId(userId);
	}
	
	/**
	 * @return  获取所有讲师   不分页
	 */
	public static List<FamousTeacher> findAllTeacher(){
		FamousTeacherDao dao=new FamousTeacherImp();
		return dao.findAllTeacher();
	}
	
	/**
	 * @param tId
	 * @return  获取守护讲师信息
	 */
	public static FamousTeacher findPurchInfo(int tId){
		FamousTeacherDao dao=new FamousTeacherImp();
		return dao.findPurchInfo(tId);
	}
	
	public static int updateIdeaReadNum(int id,int readNum,int xnNum){
		FamousTeacherDao dao=new FamousTeacherImp();
		return dao.updateIdeaReadNum(id, readNum, xnNum);
	}

	/**
	 * @return  获取首页统计数据  （人气    观点   回答数   粉丝数）
	 */
	public static List<FamousTeacher> findIndexData() {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findIndexData();
	}
	
	public static FamousTeacher findTeacherBaseInfo(int tId){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findTeacherBaseInfo(tId);
	}
	
	public static int updateFansNum(int fans,int id){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.updateFansNum(fans, id);
	}
	
	/**
	 * @param num
	 * @param id
	 * @return 更新提问数
	 */
	public static int updateAskNum(int num,int id){
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.updateAskNum(num, id);
	}

	/**
	 * @param count
	 * @return 获取推荐的讲师信息
	 */
	public static List<FamousTeacher> findFamousTeacherByIndex(int count) {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findFamousTeacherByIndex(count);
	}

	/**
	 * @param id
	 * @return 根据id查询讲师信息
	 */
	public static FamousTeacher findFamousTeacherById(int id) {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findFamousTeacherById(id);
	}
	
	/**
	 * @param id
	 * @return 获取最大提问数
	 */
	public static int findMaxAsk(int id){
		FamousTeacherDao dao=new FamousTeacherImp();
		return dao.findMaxAsk(id);
	}

}
