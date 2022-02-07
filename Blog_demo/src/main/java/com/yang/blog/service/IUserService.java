package com.yang.blog.service;

import com.yang.blog.pojo.BlogUser;
import com.yang.blog.response.ResponseResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
    ResponseResult initManagerAccount(BlogUser blogUser, HttpServletRequest request);
}
