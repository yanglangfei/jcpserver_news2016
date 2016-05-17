package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TeacherDao;
import com.jucaipen.daoimp.TeacherImp;
import com.jucaipen.model.Teacher;

public class TeacherServer {
	/**
	 * @return 返回所有教师信息
	 */
	public static List<Teacher> getTeachers(int page) {
		TeacherDao dao = new TeacherImp();
		return dao.findAll(page);
	}

	/**
	 * @param id
	 * @return  返回某个教师信息
	 */
	public static Teacher getTeacher(int id) {
		TeacherDao dao = new TeacherImp();
		return dao.findTeacher(id);
	}

}
