package com.yang.dao;

import com.yang.pojo.Users;
import com.yang.utils.MyBaisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void getUserInfo(){
        SqlSession session = MyBaisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        List<Users> usersInfo = mapper.getUserInfo();

        // for循环遍历输出List集合
        for (Users users : usersInfo) {
            System.out.println(users);
        }
        // 关闭sqlSession
        session.close();
    }
    @Test
    public void getUserINfoById(){
        SqlSession session = MyBaisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        Users userINfoById = mapper.getUserINfoById(2);
        System.out.println(userINfoById);
    }
}
