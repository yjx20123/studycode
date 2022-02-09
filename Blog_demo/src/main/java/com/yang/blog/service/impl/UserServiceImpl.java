package com.yang.blog.service.impl;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import com.yang.blog.dao.SettingsDao;
import com.yang.blog.dao.UserDao;
import com.yang.blog.pojo.BlogUser;

import com.yang.blog.pojo.Setting;

import com.yang.blog.response.ResponseResult;
import com.yang.blog.service.IUserService;
import com.yang.blog.utils.Constants;
import com.yang.blog.utils.IdWorker;
import com.yang.blog.utils.RedisUtil;
import com.yang.blog.utils.TextUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private SettingsDao settingsDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder cryptPasswordEncoder;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private Random createRandom;
    @Override
    public ResponseResult initManagerAccount(BlogUser blogUser, HttpServletRequest request) {
        //检查是否有初始化

        if ((settingsDao.findOneBykey(Constants.Settings.MANAGER_ACCOUNT_INIT_STATE))!=null){
            return ResponseResult.FAILED("管理员账号已经初始化");
        }
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
        String remoteAddr = request.getRemoteAddr();
        blogUser.setLogip(remoteAddr);
        blogUser.setReg_ip(remoteAddr);
        blogUser.setCreatetime(new Date());
        blogUser.setUpdatetime(new Date());
        String password = blogUser.getPassword();

        String encode = cryptPasswordEncoder.encode(password);
        blogUser.setPassword(encode);
        userDao.save(blogUser);
        //更新已经添加的标记
        Setting setting=new Setting();
        setting.setKey(Constants.Settings.MANAGER_ACCOUNT_INIT_STATE);
        setting.setId(idWorker.nextId()+"");
        setting.setCreateTime(new Date());
        setting.setValue("1");
        setting.setUpdateTime(new Date());
        settingsDao.save(setting);
        return ResponseResult.SUCCESS("管理员初始化成功");
    }

    public static final int[] captcha_Font_types = {
            Captcha.FONT_1,
            Captcha.FONT_2,
            Captcha.FONT_3,
            Captcha.FONT_4,
            Captcha.FONT_5,
            Captcha.FONT_6,
            Captcha.FONT_7,
            Captcha.FONT_8,
            Captcha.FONT_9,
            Captcha.FONT_10
    };
    @Override
    public void createCaptcha(HttpServletResponse response, String captchakey) throws Exception {
        if (TextUtils.isEmmpty(captchakey) || captchakey.length() < 13) {
            return;
        }
        long key;

        try {
            key = Long.parseLong(captchakey);
        } catch (Exception e) {
            return;
        }
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        int captchaType = createRandom.nextInt(3);
        Captcha captcha = null;
        if (captchaType == 1) {
            captcha = new GifCaptcha(200, 60);
        } else if (captchaType == 2) {
            captcha = new ChineseCaptcha(200, 60);
        } else {
            captcha = new ArithmeticCaptcha(200, 60);
            captcha.setLen(3);  // 几位数运算，默认是两位
            captcha.text();  // 获取运算的结果：5
        }
        // 三个参数分别为宽、高、位数

        int index = createRandom.nextInt(captcha_Font_types.length);
        log.info("captcha_Font_types.length index ==>" + index);
        captcha.setFont(captcha_Font_types[index]);
        String content = captcha.text().toLowerCase();
        //保存到redis中
        redisUtil.set(Constants.User.KEY_CAPTCHA_CONTENT + key, content, 10*60);
        // 输出图片流
        captcha.out(response.getOutputStream());
    }

    /**
     * 发送邮件
     * @param request
     * @param emailAddress
     * @return
     */
    @Override
    public ResponseResult sendEmail(HttpServletRequest request, String emailAddress) {
        //防止暴力发送
        String remoteAddr = request.getRemoteAddr();
        log.info("email==>ip"+remoteAddr);
        if(remoteAddr!=null){
            remoteAddr=remoteAddr.replaceAll(":","_");
        }
        log.info("constants.user.key_email_send_ip ==>"+Constants.User.KEY_EMAIL_SEND_IP+remoteAddr);
        Integer ipSendTime = (Integer) redisUtil.get(Constants.User.KEY_EMAIL_SEND_IP + remoteAddr);
        if(ipSendTime!=null&&ipSendTime>10){
            return ResponseResult.FAILED("你发送验证码也太频繁了吧!!!");
        }
        redisUtil.get(Constants.User.KEY_EMAIL_SEND_ADDRESS+remoteAddr);
        //检查邮箱地址是否正确
        //发送验证码
        return null;
    }
}
