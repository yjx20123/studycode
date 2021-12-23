package com.yang.blog.service;

import com.yang.blog.pojo.BlogUser;
import com.yang.blog.response.ResponseResult;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
    ResponseResult initManageAccount(BlogUser blogUser, HttpServletRequest request);
}
