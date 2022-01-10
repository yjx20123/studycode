package com.seu.shiro;

import com.seu.blog.entity.UserEntity;
import com.seu.blog.entity.UserTokenEntity;
import com.seu.blog.service.ShiroService;
import com.seu.common.constant.Base;
import com.seu.common.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 认证
 *
 * @author liangfeihu
 * @email liangfeihu@163.com
 * @date 2017-05-20 14:00
 */
@Slf4j
@Component
public class OAuth2Realm extends AuthorizingRealm {
    @Autowired
    private ShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        UserEntity user = (UserEntity) principals.getPrimaryPrincipal();
        Set<String> roles = new HashSet<String>();

        //简单处理  只有admin一个角色
        if (user.getAdmin().intValue() == 1) {
            roles.add(Base.ROLE_ADMIN);
        }
        info.setRoles(roles);

        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        //根据accessToken，查询用户信息
        UserTokenEntity tokenEntity = shiroService.queryByToken(accessToken);
        //token失效
        if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new IncorrectCredentialsException("token失效, 请重新登录");
        }

        //查询用户信息
        UserEntity user = shiroService.queryUser(tokenEntity.getUserId());
        //账号锁定
        if (Constant.UserStatus.PAUSE.getValue().equals(user.getStatus())) {
            throw new LockedAccountException("账号已被锁定, 请联系管理员");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
        log.info("[Oauth-Token登录]token={},account={}", accessToken, user.getAccount());

        return info;
    }
}
