package com.seu.common.utils;

import com.seu.common.exception.RestException;
import com.seu.blog.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Shiro工具类
 *
 * @author liangfeihu
 * @email liangfeihu@163.com
 * @date 2016年11月12日 上午9:49:19
 */
public class ShiroUtils {

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static UserEntity getUserEntity() {
        UserEntity userEntity = (UserEntity) SecurityUtils.getSubject().getPrincipal();
        if (userEntity == null) {
            throw new RestException("您当前没有权限", 401);
        }
        return userEntity;
    }

    public static Long getUserId() {
        return getUserEntity().getId();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static String getKaptcha(String key) {
        Object kaptcha = getSessionAttribute(key);
        if (kaptcha == null) {
            throw new RestException("验证码已失效");
        }
        getSession().removeAttribute(key);
        return kaptcha.toString();
    }

}
