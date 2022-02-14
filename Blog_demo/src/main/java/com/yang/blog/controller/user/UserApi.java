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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
    public ResponseResult register(@RequestBody BlogUser blogUser, @RequestParam("email_code") String code, @RequestParam("captcha_code") String captchaCode
            , @RequestParam("captcha_key") String captchaKey
            , HttpServletRequest request) {
        return userService.registerUser(blogUser, code, captchaCode, captchaKey, request);
    }

    /**
     * 登录功能
     * 用户账号可以是昵称 也可以是邮箱 做了唯一处理
     * 2、密码
     * 3图灵验证码
     * 4，图灵验证码的key
     *
     * @param captcha     图灵验证码
     * @param captcha_key captcha_key
     * @param
     */
    @PostMapping("/{captcha}/{captcha_key}")
    public ResponseResult login(@RequestBody BlogUser blogUser, @PathVariable("captcha") String captcha,
                                @PathVariable("captcha_key") String captcha_key,
                                HttpServletResponse response,
                                HttpServletRequest request) throws Exception {
        return userService.doLogin(captcha, captcha_key, blogUser, response, request);
    }

    /**
     * 获取图灵验证码
     *
     * @return
     */
    @GetMapping("/captcha")
    public void getCaptcha(HttpServletResponse response, @RequestParam("captcha_key") String captchakey) throws Exception {
        try {
            userService.createCaptcha(response, captchakey);
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
    public ResponseResult senVerifyCode(@RequestParam("type") String type, @RequestParam("email") String emailAddress, HttpServletRequest request) {
        log.info("email====>" + emailAddress);
        return userService.sendEmail(request, type, emailAddress);
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
        return userService.getUserInfo(userid);
    }

    /**
     * 修改用户信息
     *
     * @return
     */
    @PutMapping("/{userId}")
    public ResponseResult updateUserInfo(HttpServletResponse response,HttpServletRequest request,@PathVariable("userId") String userId, @RequestBody BlogUser blogUser) {

        return userService.updateUserInfo(request,response,userId,blogUser);
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

    @ApiResponses(
            {
                    @ApiResponse(code = 20000, message = "当前邮箱已经注册"),
                    @ApiResponse(code = 40000, message = "当前邮箱未被注册")
            }
    )
    @GetMapping("/email")
    public ResponseResult checkEmail(@RequestParam("email") String email) {
        return userService.checkEmail(email);
    }

    @ApiResponses(
            {
                    @ApiResponse(code = 20000, message = "当前邮箱已经注册"),
                    @ApiResponse(code = 40000, message = "当前邮箱未被注册")
            }
    )
    @GetMapping("/user_name")
    public ResponseResult checkUsername(@RequestParam("username") String username) {
        return userService.checkUsername(username);
    }
}

