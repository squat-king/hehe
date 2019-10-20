package common.util;

import com.attendance.bean.UserBean;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Phaser;


public class DBUtil {
    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    public static Map<String, UserBean> userMap = new HashMap<String, UserBean>();
    public static DataSource dataSource;
    public static PreparedStatement pstm;
//    static {
//        add(new UserBean("00000001", "admin", "123", "1"));
//
//    }
//
//    private static void add(UserBean user) {
//        userMap.put(user.getE_NO(), user);
//    }

    public static UserBean findUserById(UserBean userBean) {

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

    public static int getItemCount(String table) {
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

    public static Boolean add(UserBean user) {
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

    public static List<UserBean> listUser() {
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

    public static Boolean remove(String userId){
        String sql = "delete  from EMPLOYEE where E_NO = ?";
        Boolean flag = false;
        conn = ConnectionPool.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,userId);
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

    public static Connection getConnection() {

        Connection conn = tl.get();// 从当前线程上获得链接
        try {
            if (conn == null || conn.isClosed() ) {
                //从连接池中获取连接对象
                conn = dataSource.getConnection();
                // 把连接绑定到当前线程上
                tl.set(conn);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }


    public static int myExecuteUpdate(String sql, List list) throws Exception {
        //连接数据库并告诉小帮手去干嘛
        pstm = getConnection().prepareStatement(sql);
        if (list != null) {
            //用for循环遍历list集合中，sql语句中?相匹配的值
            for (int i = 0; i < list.size(); i++) {
                pstm.setObject(i + 1, list.get(i));
            }
        }
        return pstm.executeUpdate();
    }
    // 所有的查询的方法
    public static ResultSet myExecuteQuery(String sql, List list) {

        try {
            pstm = ConnectionPool.getConn().prepareStatement(sql);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    pstm.setObject(i + 1, list.get(i));
                }
            }
            return pstm.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


}