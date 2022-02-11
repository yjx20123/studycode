package com.yang.blog.service;

import com.yang.blog.pojo.BlogUser;
import com.yang.blog.response.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IUserService {
    ResponseResult initManagerAccount(BlogUser blogUser, HttpServletRequest request);

    void createCaptcha(HttpServletResponse response, String captchakey) throws Exception;

    ResponseResult sendEmail(HttpServletRequest request, String type, String emailAddress);

    ResponseResult registerUser(BlogUser blogUser, String code, String captchaCode,String captchaKey,HttpServletRequest request);

    ResponseResult doLogin(String captcha, String captcha_key, BlogUser blogUser, HttpServletResponse response, HttpServletRequest request);
}
