package com.attendance.dao;


import com.attendance.bean.UserBean;
import common.util.DBUtil;

import java.util.List;

public class UserDao {
    DBUtil dbUtil = new DBUtil();

    public UserBean isExist(UserBean userBean) {
        return dbUtil.findUserById(userBean);
    }
    public boolean ifExist(UserBean userBean) {
        if (dbUtil.findUserById(userBean)==null){
            return false;
        }else{
            return true;
        }


    }
    public boolean add(UserBean userBean) {
        if (!(isExist(userBean) == null)) {
            return false;
        }
        return dbUtil.add(userBean);
    }

    public UserBean get(UserBean userBean) {
        return dbUtil.findUserById(userBean);
    }

    public List<UserBean> list(){
        return dbUtil.listUser();
    }

    public boolean remove(String userId){
        return dbUtil.remove(userId);
    }
}
