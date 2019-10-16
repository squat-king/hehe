package com.attendance.dao;


import com.attendance.bean.UserBean;
import common.util.DBUtil;

public class UserDao {
    public boolean isExist(String userId) {
        return DBUtil.userMap.containsKey(userId);
    }

    public boolean addUser(String userId, String username, String password) {
        if (isExist(username)) {
            return false;
        }
        UserBean u = new UserBean(userId, username, password, false);
        DBUtil.userMap.put(u.getE_NO(), u);
        return true;
    }

    public UserBean getUserByUP(String userId, String password) {
        if (isExist(userId) == false) {
            return null;
        }
        UserBean u = DBUtil.userMap.get(userId);
        if (u.getE_PASSWD().equals(password)) {
            return u;
        } else {
            return null;
        }
    }
}