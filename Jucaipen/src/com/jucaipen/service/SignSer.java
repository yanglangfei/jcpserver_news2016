package com.jucaipen.service;

import com.jucaipen.dao.SignDao;
import com.jucaipen.daoimp.SignImp;
import com.jucaipen.model.Sign;

public class SignSer {

	public static Sign findSignByUid(int userId) {
		SignDao dao=new SignImp();
		return dao.findSignByUid(userId);
	}

	public static int addSign(Sign sign) {
		SignDao dao=new SignImp();
		return dao.addSign(sign);
	}

}
