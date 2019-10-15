package common.bean;

import java.util.HashMap;
import java.util.List;

/**
 * ��װ��Ϣ��ѯҳ������صķ�ҳ��Ϣ
 * 1����ͼ�㡢���Ʋ㡢ģ�Ͳ�֮�䴫�ݷ�ҳ��Ϣ��
 * @author dell
 *
 */
public class PageInforBean {
	/**
	 * ��ǰҳ��ʾ��¼��,Ĭ��Ϊÿҳ��ʾ10��
	 */
	private int showCount = 10; 

	/**
	 * ��ǰҳ��ʼ��¼��
	 */
	private int fromCount = 0;
	/**
	 * ��¼������
	 */
	private int totalNumber = 0;
	/**
	 * ��ǰҳ���ݵ��б�
	 */
	private List list = null;
	/**
	 * ��ҳ��
	 */
	private int totalPage = 0;
	/**
	 * ��ǰҳҳ��
	 */
	private int currentPage = 0;

	/**
	 * �洢��������
	 */
	private HashMap<String,String> hm;

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public int getFromCount() {
		return fromCount;
	}

	public void setFromCount(int fromCount) {
		this.fromCount = fromCount;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public HashMap<String, String> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}

	
	
}
