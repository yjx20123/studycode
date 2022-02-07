package com.yang.blog.service.impl;

import com.yang.blog.dao.SettingsDao;
import com.yang.blog.dao.UserDao;
import com.yang.blog.pojo.BlogUser;

import com.yang.blog.pojo.Setting;

import com.yang.blog.response.ResponseResult;
import com.yang.blog.service.IUserService;
import com.yang.blog.utils.Constants;
import com.yang.blog.utils.IdWorker;
import com.yang.blog.utils.TextUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Date;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    public IdWorker idWorker;
    @Autowired
    public SettingsDao settingsDao;
    @Autowired
    public UserDao userDao;
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
}
