package common.service;

import common.bean.PageInforBean;

import java.util.HashMap;
import java.util.List;


/**
 * ��װ�˷�ҳ��ͨ��ҵ���߼�����
 * @author dell
 *
 */
public abstract class PageInforService {
	/**
	 * ������ҳ
	 * @param pageInforBean ��ҳ��Ϣbean
	 * 
	 */
	public PageInforBean getPageInitialList(PageInforBean pageInforBean)  {
		pageInforBean.setCurrentPage(1);
		return getPageListByPageNo(pageInforBean);
	}
	
	/**
	 * ����ҳ�������ҳ����
	 * @param pageInforBean ��ҳ��Ϣbean,��װ��Ҫ������ҳ���ÿҳ��ʾ�ļ�¼������Ϣ
	 */
	public PageInforBean getPageListByPageNo(PageInforBean pageInforBean)
	{
		//��������
		HashMap queryInforMap = pageInforBean.getHm();
		
		//��ȡ��ǰҳ����ʼ��¼��
		if(pageInforBean.getCurrentPage()==1)
		{
			pageInforBean.setFromCount(1);
		}else
		{
			pageInforBean.setFromCount((pageInforBean.getCurrentPage()-1)*pageInforBean.getShowCount()+1);
		}
		//���ݼ�����������ѯ�����������ܼ�¼��
		int totalNumber = getTotalRecordNumber(queryInforMap);
		int showCount = pageInforBean.getShowCount();
		//�����ܼ�¼����ÿҳ��ʾ�ļ�¼������ȡ��ҳ����
		int tmp = totalNumber% showCount;
		int tmpPageNumber = totalNumber
				/showCount;
		pageInforBean.setTotalPage(tmp == 0  ? tmpPageNumber : tmpPageNumber + 1);
		pageInforBean.setTotalNumber(totalNumber);
		int endCount = pageInforBean.getFromCount()+showCount-1;
		//������ʼ��¼����������¼���Լ�������������ȡ��ǰҳ�������б�
		pageInforBean.setList(getComponentPageList(pageInforBean.getFromCount(),endCount,queryInforMap));
		return pageInforBean;
	}
	
	/**
	 * ���ݼ�����������ȡ���������ļ�¼������ÿ��ҵ����ʵ�֣�
	 * 
	 * @param queryInforMap ��������
	 * @return int �ܼ�¼��
	 */
	public abstract int getTotalRecordNumber(HashMap queryInforMap);
	
	/**
	 * ������ʼ��¼����������¼���Լ�������������ȡ��ǰҳ�������б�ÿ��ҵ����ʵ�֣�
	 * @param fromCount ��ʼ��¼��
	 * @param endCount ��ֹ��¼��
	 * @param queryInforMap ��������
	 * @return List ��ǰҳ�������б�
	 */
	public abstract List getComponentPageList(int fromCount,int endCount,HashMap queryInforMap);
}
