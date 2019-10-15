package com.attendance.dao.impl;

import com.attendance.dao.LoginDao;
import common.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * �Ñ���¼
 * 
 */
public class LoginDaoImpl implements LoginDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/**
	 * �û���¼
	 */
	@Override
	public String login(String account, String password) {
		String level = null;// ����ʻ�������������򷵻�null
		// 1����������
		try {
			// SQL��
			String sql = "select mylevel from t_user_info where account=? and password=?";
			conn = ConnectionPool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			// �ʻ�����������ȷ
			if (rs.next()) {
				level = rs.getString("mylevel");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			ConnectionPool.close(pstmt, rs, conn);
		}
		return level;
	}

}
