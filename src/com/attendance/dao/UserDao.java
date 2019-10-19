package com.attendance.dao;


import com.attendance.bean.UserBean;
import common.util.DBUtil;

import java.util.List;

public class UserDao {
    DBUtil dbUtil = new DBUtil();

    public UserBean isExist(UserBean userBean) {
        return dbUtil.findUserById(userBean);
    }

    public boolean add(UserBean userBean) {
        if (!(isExist(userBean) == null)) {
            return false;
        }
        return dbUtil.add(userBean);
    }

    public UserBean get(String userId) {
        return dbUtil.findUserById(userId);
    }

    public List<UserBean> list(){
        return dbUtil.listUser();
    }

    public boolean remove(String userId){
        return dbUtil.remove(userId);
    }
}
