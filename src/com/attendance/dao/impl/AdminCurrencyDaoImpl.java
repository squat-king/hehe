package com.attendance.dao.impl;

import com.attendance.bean.UserInfoBean;
import com.attendance.dao.AdminCurrencyDao;
import common.util.ConnectionPool;
import common.util.FieldCheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AdminCurrencyDaoImpl implements AdminCurrencyDao {

	 Connection conn=null;
     PreparedStatement pstmt=null;
     ResultSet rs=null;
     
     public List getComponentPageList(int fromCount, int endCount,
 			HashMap queryInforMap) {
		List<UserInfoBean> currList=new ArrayList<UserInfoBean>();
		//1.��ȡ����
		conn= ConnectionPool.getConn();
		//2.����sql
		String sql="SELECT currency_cd,currency_nm,is_valid FROM (SELECT currency_cd,currency_nm,is_valid,rownum rn FROM m_currency WHERE  currency_nm like '%'||?||'%' AND is_valid like '%'||?||'%') WHERE rn>=? AND rn<?";
		
		try {
			//3.��ռλ����ֵ
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, FieldCheck.convertNullToEmpty((String)queryInforMap.get("currency_nm")));
			pstmt.setString(2, FieldCheck.convertNullToEmpty((String)queryInforMap.get("is_valid")));
			pstmt.setInt(3, fromCount);
			pstmt.setInt(4, endCount);
			//4.����ִ��sql
			rs=pstmt.executeQuery();
			//5.�ӽ������ȡ����
			while(rs.next())
			{
				UserInfoBean currency=new UserInfoBean();
//				currency.setCurrency_cd(rs.getString("currency_cd"));
//				currency.setCurrency_nm(rs.getString("currency_nm"));
//				currency.setIs_valid(rs.getString("is_valid"));
//				currList.add(currency);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionPool.close(pstmt, rs, conn);
		}
		
		return currList;
	}

    public int getTotalRecordNumber(HashMap<String,String> queryInforMap){
		int totalNum=0;
		//1.��ȡ����
		conn= ConnectionPool.getConn();
		//2.����sql
		String sql="SELECT count(*) num FROM m_currency WHERE  currency_nm like '%'||?||'%' AND is_valid like '%'||?||'%'";
		try {
			//3.��ռλ����ֵ
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, FieldCheck.convertNullToEmpty(queryInforMap.get("currency_nm")));
			pstmt.setString(2, FieldCheck.convertNullToEmpty(queryInforMap.get("is_valid")));
			
			//4.����ִ��sql
			rs=pstmt.executeQuery();
			//5.�ӽ������ȡ����
			while(rs.next())
			{
				totalNum=rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionPool.close(pstmt, rs, conn);
		}
		return totalNum;
	}

}
