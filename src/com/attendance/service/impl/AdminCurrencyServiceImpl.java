package com.attendance.service.impl;

import com.attendance.service.AdminCurrencyService;
import common.service.PageInforService;

import java.util.HashMap;
import java.util.List;


public class AdminCurrencyServiceImpl extends PageInforService implements  AdminCurrencyService{



	public List getComponentPageList(int fromCount, int endCount,
			HashMap queryInforMap) {
//		 LoginDao  adminCurrencyDao = new  AdminCurrencyDaoImpl();
//		return adminCurrencyDao.getComponentPageList(fromCount, endCount, queryInforMap);
		return null;
	}


	public int getTotalRecordNumber(HashMap queryInforMap) {
//		LoginDao  adminCurrencyDao = new  AdminCurrencyDaoImpl();
//		return adminCurrencyDao.getTotalRecordNumber(queryInforMap);
		return 0;
	}
  
}
