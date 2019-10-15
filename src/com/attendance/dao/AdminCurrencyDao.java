package com.attendance.dao;

import java.util.HashMap;
import java.util.List;

public interface AdminCurrencyDao {
	/**
	 * ������ʼ��¼����������¼���Լ�������������ȡ��ǰҳ�Ļ�����Ϣ�б�
	 * @param fromCount ��ʼ��¼��
	 * @param endCount ��ֹ��¼��
	 * @param queryInforMap ��������
	 * @return List ��ǰҳ�������б�
	 */
	public List getComponentPageList(int fromCount, int endCount,
                                     HashMap queryInforMap);
	/**
	 * ���ݼ�����������ȡ���������ļ�¼����
	 * @param queryInforMap
	 * @return �ܼ�¼��
	 */
	public int getTotalRecordNumber(HashMap<String, String> queryInforMap);
}
