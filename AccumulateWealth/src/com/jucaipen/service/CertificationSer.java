package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.CertificationDao;
import com.jucaipen.daoimp.CertificationImp;
import com.jucaipen.model.Certification;

/**
 * @author Administrator ֤����Ϣ
 */
public class CertificationSer {

	/**
	 * @return ��ȡ����֤����Ϣ
	 */
	public static List<Certification> findAllCertification() {
		CertificationDao dao = new CertificationImp();
		return dao.findAllCertification();
	}

	/**
	 * @param id
	 * @return ����id��ȡ֤����Ϣ
	 */
	public static Certification findCertificationById(int id) {
		CertificationDao dao = new CertificationImp();
		return dao.findCertificationById(id);
	}

}
