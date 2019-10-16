package com.attendance.service;

import com.attendance.bean.UserBean;
import com.attendance.dao.UserDao;

public class UserService {
    public boolean register(String userId, String username, String password) {
        UserDao userDao = new UserDao();
        boolean isExist = userDao.isExist(userId);
        if (isExist) {
            return false;
        } else {
            userDao.addUser(userId, username, password);
            return true;
        }
    }

    public UserBean login(String username, String password) {
        return new UserDao().getUserByUP(username, password);
    }

    public boolean isExist(String userId) {
        return new UserDao().isExist(userId);
    }
}
