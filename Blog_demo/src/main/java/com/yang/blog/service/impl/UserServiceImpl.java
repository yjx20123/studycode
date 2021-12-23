package com.yang.blog.service.impl;

import com.yang.blog.pojo.BlogUser;
import com.yang.blog.response.ResponseResult;
import com.yang.blog.service.IUserService;
import com.yang.blog.utils.Constants;
import com.yang.blog.utils.IdWorker;
import com.yang.blog.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    public IdWorker idWorker;
    @Override
    public ResponseResult initManageAccount(BlogUser blogUser, HttpServletRequest request) {
        //检查数据
       if( TextUtils.isEmmpty(blogUser.getUsername())){
           return ResponseResult.FAILED("用户名不能为空");
       }if( TextUtils.isEmmpty(blogUser.getPassword())){
           return ResponseResult.FAILED("密码不能为空");
       }if(TextUtils.isEmmpty(blogUser.getEmail())){
           return ResponseResult.FAILED("邮箱不能为空");
        }
       //补充数据
        blogUser.setId(String.valueOf(idWorker.nextId()));
       blogUser.setRoles(Constants.User.ROLE_ADMIN);
       blogUser.setAvatar(Constants.User.DEFAULT_AVATAR);
       blogUser.setState(Constants.User.DEFAULT_STATE);

        return ResponseResult.SUCCESS("登录成功");
    }
}
