package com.yang.blog.service;

import com.yang.blog.pojo.BlogUser;
import com.yang.blog.response.ResponseResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

public interface IUserService {
    ResponseResult initManagerAccount(BlogUser blogUser, HttpServletRequest request);

    void createCaptcha(HttpServletResponse response, String captchakey) throws Exception;
}
