package com.yang.dao;

import com.yang.pojo.Users;

import java.util.List;

public interface UserDao {
     List<Users> getUserInfo();
     Users getUserINfoById(int id);

}
