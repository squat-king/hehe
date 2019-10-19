package common.util;

import com.attendance.bean.UserBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Phaser;


public class DBUtil {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public static Map<String, UserBean> userMap = new HashMap<String, UserBean>();

//    static {
//        add(new UserBean("00000001", "admin", "123", "1"));
//
//    }
//
//    private static void add(UserBean user) {
//        userMap.put(user.getE_NO(), user);
//    }

    public UserBean findUserById(UserBean userBean) {

        String sql = "select * from EMPLOYEE where E_NO = ? and E_PASSWD = ?";
        conn = ConnectionPool.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userBean.getE_NO());
            ps.setString(2,userBean.getE_PASSWD());
            rs = ps.executeQuery();
            if (rs.next()) {
                String userId = rs.getString("E_NO");
                String userName = rs.getString("E_NAME");
                String passwd = rs.getString("E_PASSWD");
                String dept = rs.getString("E_DEPT");
                String job = rs.getString("E_JOB");
                String registtime = rs.getString("E_REGISTTIME");
                String sex = rs.getString("E_SEX");
                String phone = rs.getString("E_PHONE");
                String birthday = rs.getString("E_BIRTHDAY");
                String email = rs.getString("E_EMAIL");
                String isAdmin = rs.getString("E_ISADMIN");
                UserBean user = new UserBean(userId, userName, passwd, dept, job, registtime, sex, phone, birthday, email
                        , isAdmin);
                return user;
            }
            ConnectionPool.close(ps, rs, conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getItemCount(String table) {
        int num = 0;
        String sql = "select count(*) from " + table;
        conn = ConnectionPool.getConn();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
            ConnectionPool.close(ps, rs, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public Boolean add(UserBean user) {
        String sql = "insert into EMPLOYEE values(?,?,?,?,?,?,?,?,?,?,0)";
        Boolean flag = false;
        conn = ConnectionPool.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getE_NO());
            ps.setString(2, user.getE_NAME());
            ps.setString(3, user.getE_PASSWD());
            ps.setString(4, user.getE_DEPT());
            ps.setString(5, user.getE_JOB());
            ps.setString(6, user.getE_REGISTTIME());
            ps.setString(7, user.getE_SEX());
            ps.setString(8, user.getE_PHONE());
            ps.setString(9, user.getE_BIRTHDAY());
            ps.setString(10, user.getE_EMAIL());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
            ;
            ConnectionPool.close(ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<UserBean> listUser() {
        List<UserBean> list = new ArrayList<UserBean>();
        String sql = "select * from EMPLOYEE";
        UserBean userBean;
        conn = ConnectionPool.getConn();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
//            int itemNum = this.getItemCount("EMPLOYEE");
//            for (int i = 0; i < itemNum; i++) {
            while(rs.next()) {
                userBean = new UserBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11));
                list.add(userBean);
//            }
            }
            ConnectionPool.close(ps, rs, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean remove(String userId){
        String sql = "delete  from EMPLOYEE where E_NO = ?";
        Boolean flag = false;
        conn = ConnectionPool.getConn();
        try {
            ps.setString(1,userId);
            ps = conn.prepareStatement(sql);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
            ;
            ConnectionPool.close(ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}