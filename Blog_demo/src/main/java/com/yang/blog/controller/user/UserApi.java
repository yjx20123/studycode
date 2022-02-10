package com.yang.blog.controller.user;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.yang.blog.pojo.BlogUser;
import com.yang.blog.response.ResponseResult;
import com.yang.blog.service.IUserService;
import com.yang.blog.service.impl.UserServiceImpl;
import com.yang.blog.utils.Constants;
import com.yang.blog.utils.RedisUtil;
import com.yang.blog.utils.TextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserApi {
    @Autowired
    private IUserService userService;
    @Autowired
    private Random createRandom;

    /**
     * 初始化管理员账号
     *
     * @return
     */
    @PostMapping("/admin_accout")
    public ResponseResult initManagerAccount(@RequestBody BlogUser blogUser, HttpServletRequest request) {
        return userService.initManagerAccount(blogUser, request);
    }

    /**
     * 注册
     */
    @PostMapping
    public ResponseResult register(@RequestBody BlogUser blogUser,@RequestParam("email_code") String code,@RequestParam("captcha_code") String captchaCode
    ,@RequestParam("captcha_key") String captchaKey
    ,HttpServletRequest request) {
        return userService.registerUser(blogUser,code,captchaCode,captchaKey,request);
    }

    /**
     * 登录功能
     *
     * @return
     */
    @PostMapping("/{captcha}")
    public void login(HttpServletResponse response, @RequestParam("captcha_key") String captchakey) throws Exception {

    }

    /**
     * 获取图灵验证码
     *
     * @return
     */
    @GetMapping("/captcha")
    public void getCaptcha(HttpServletResponse response, @RequestParam("captcha_key") String captchakey) throws Exception {
        try {
            userService.createCaptcha(response,captchakey);
        } catch (Exception e) {
            log.error(e.toString());
        }

    }

    /**
     * 发送邮件
     *
     * @param emailAddress
     * @return
     */
    @GetMapping("/verify_code")
    public ResponseResult senVerifyCode(@RequestParam("type") String type,@RequestParam("email") String emailAddress,HttpServletRequest request) {
        log.info("email====>" + emailAddress);
        return userService.sendEmail(request,type,emailAddress);
    }

    /**
     * 修改password
     *
     * @param blogUser
     * @return
     */
    @PutMapping("/password/{userId}")
    public ResponseResult updatePassword(@PathVariable("userId") String userId, @RequestBody BlogUser blogUser) {
        return null;
    }

    /**
     * 获取用户信息
     *
     * @param userid
     * @return
     */
    @GetMapping("{userid}")
    public ResponseResult getUserInfo(@PathVariable("userid") String userid) {
        return null;
    }

    /**
     * 修改用户信息
     *
     * @return
     */
    @PutMapping("/{userId}")
    public ResponseResult updateUserInfo(@PathVariable("userId") String userId, @RequestBody BlogUser blogUser) {

        return null;
    }

    /**
     * 获取全部用户
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listUsers(@RequestParam("page") int page, @RequestParam("size") int size) {
        return null;
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    public ResponseResult deleteUser(@PathVariable("userId") String userId) {
        return null;
    }
}

