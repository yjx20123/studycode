package com.kuang.service;

import com.kuang.dao.UserDao;
import com.kuang.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    @Override
    public void getUser() {
        userDao.getUser();
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDao=" + userDao +
                '}';
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
