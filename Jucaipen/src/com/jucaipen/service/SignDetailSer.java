package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.SignDetailDao;
import com.jucaipen.daoimp.SignDetailImp;
import com.jucaipen.model.SignDetail;

public class SignDetailSer {

	public static  List<SignDetail> findSignDetailByUserId(int userId, int page) {
		SignDetailDao dao=new SignDetailImp();
		return dao.findSignDetailByUserId(userId, page);
	}

	public static int addSignDetail(SignDetail detail) {
		SignDetailDao dao=new SignDetailImp();
		return dao.addSignDetail(detail);
	}

}
