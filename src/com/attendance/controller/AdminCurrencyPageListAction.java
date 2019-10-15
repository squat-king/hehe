package com.attendance.controller;

import com.attendance.service.impl.AdminCurrencyServiceImpl;
import common.controller.PageListBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class AdminCurrencyPageListAction extends PageListBaseServlet {
    
	
	/**
	 * 1����ʼ��PageInforBean����װ�ͻ��˴��ݵļ���������Ϣ��
	 * 2����ʼ��forward��pageInforService��
	 * listBean �� forward
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws java.io.IOException
	 */
	public void initPageInforBean(HttpServletRequest request, HttpServletResponse response) {
		//��ȡ�����л�����
		String currency_nm=request.getParameter("currency_nm"); 
		//��ȡ����״̬
		String is_valid=request.getParameter("is_valid_all");
		
		//�ж�"ȫѡ"�Ƿ�ѡ�У�ѡ�еĻ�����ƥ�����У�δѡ�еĻ����ȡ������е�ֵ
		if("ALL".equals(is_valid))
		{
			is_valid="%";  //���ݵ����ݿ��н���ģ����ѯ��ƥ������״̬	
		}else
		{
			is_valid=request.getParameter("is_valid");
		}
		//�����������ŵ�hm��
		HashMap<String ,String> hm=new HashMap<String,String>();
		hm.put("currency_nm", currency_nm);
		hm.put("is_valid",is_valid);
		super.getPageInforBean().setHm(hm);
		super.setPageInforService(new AdminCurrencyServiceImpl());
		super.setForward("/pages/component/admin/currencyMaster.jsp");
	}
  
}
