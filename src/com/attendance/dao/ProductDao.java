package com.attendance.dao;

import com.attendance.bean.PageBean;
import com.attendance.bean.UserBean;
import common.util.ConnectionPool;
import common.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;

    //计算总行数
    public static int getAllRows(String table){
        int num=-1;
        String sql="select count(*) shu from EMPLOYEE";

        try {
            ResultSet rs=DBUtil.myExecuteQuery(sql,null);
            if(rs.next()){
                num=rs.getInt("shu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(null,null,ConnectionPool.getConn());
        }

        return num;
    }
     //分页实现
     public static void splitPage(PageBean page) {
        List list=new ArrayList();
         String sql="(select * from EMPLOYEE where rownum<?) minus ( select * from EMPLOYEE where rownum<?)";

         //创建参数集合
         List param=new ArrayList();
         param.add(page.getCurrentPage()*page.getPageSize());
         //终止值 ：每页的条数
          param.add((page.getCurrentPage()-1)*page.getPageSize());

         ResultSet rs=DBUtil.myExecuteQuery(sql,param);
         try {
             while (rs.next()) {
                 UserBean user = new UserBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                         rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
                         rs.getString(9), rs.getString(10), rs.getString(11));

                 //将商品放入集合中
                 list.add(user);

             }
         } catch (Exception e) {
             e.printStackTrace();
         }finally {
             ConnectionPool.close(null,null,ConnectionPool.getConn());
         }

         //切记切记:一定要将数据封装在page对象中
         page.setList(list);
     }


}
