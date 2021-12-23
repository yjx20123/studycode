package com.yang.blog.controller.user;

import com.yang.blog.pojo.BlogUser;
import com.yang.blog.response.ResponseResult;
import com.yang.blog.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserApi {
    @Autowired
    private IUserService UserService;
    /**
     * 初始化管理员账号
     *
     * @return
     */
    @PostMapping("/admin_accout")
    public ResponseResult initManagerAccount(@RequestBody BlogUser blogUser, HttpServletRequest request) {
        log.info("user name ====>" + blogUser.getUsername());
        log.info("password ====>" + blogUser.getPassword());
        log.info("Email ====>" + blogUser.getEmail());
        return UserService.initManageAccount(blogUser,request);
    }

    /**
     * 注册
     */
    @PostMapping
    public ResponseResult register(@RequestBody BlogUser blogUser) {
        return ResponseResult.SUCCESS();
    }

    /**
     * 登录功能
     *
     * @return
     */
    @PostMapping("/{captcha}")
    public ResponseResult login(@PathVariable("captcha") String captcha, @RequestBody BlogUser blogUser) {
        return null;
    }

    /**
     * 获取图灵验证码
     * @return
     */
    @GetMapping("/captcha")
    public ResponseResult getCaptcha() {
        return null;
    }

    /**
     * 发送邮件
     * @param emailAddress
     * @return
     */
    @GetMapping("/verify_code")
    public ResponseResult senVerifyCode(@RequestParam("email") String emailAddress){
    log.info("email====>"+emailAddress);
    return ResponseResult.SUCCESS();
    }

    /**
     * 修改password
     * @param blogUser
     * @return
     */
    @PutMapping("/password/{userId}")
    public ResponseResult updatePassword(@PathVariable("userId") String userId ,@RequestBody BlogUser blogUser){
        return null;
    }

    /**
     * 获取用户信息
     * @param userid
     * @return
     */
    @GetMapping("{userid}")
    public ResponseResult getUserInfo(@PathVariable("userid") String userid) {
        return null;
    }

    /**
     * 修改用户信息
     * @return
     */
    @PutMapping("/{userId}")
    public ResponseResult updateUserInfo(@PathVariable("userId") String userId,@RequestBody BlogUser blogUser){

        return null;
    }

    /**
     * 获取全部用户
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listUsers(@RequestParam("page") int page,@RequestParam("size")int size){
        return null;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    public ResponseResult deleteUser(@PathVariable("userId") String userId){
        return null;
    }
}

