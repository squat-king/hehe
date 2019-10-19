package com.attendance.service;

import com.attendance.bean.UserBean;
import com.attendance.dao.UserDao;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();
//    public boolean regist(UserBean userBean) {
//        boolean isExist = userDao.isExist(userBean);
//        if (isExist) {
//            return false;
//        } else {
//            userDao.addUser(userBean);
//            return true;
//        }
//    }

    public UserBean findUserById(String userId) {
        return userDao.get(userId);
    }

    public Boolean userAdd(UserBean userBean) {
        return userDao.add(userBean);
    }

    ;

    public List<UserBean> userList() {
        return userDao.list();
    }

    public Boolean userRemove(String userId) {
        return userDao.remove(userId);
    }

}
