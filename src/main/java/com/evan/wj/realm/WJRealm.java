package com.evan.wj.realm;

import com.evan.wj.pojo.User;
import com.evan.wj.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class WJRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取授权信息方法
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        return s;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取认证信息，即根据 token 中的用户名从数据库中获取密码、盐等并返回
        String username = token.getPrincipal().toString();
        User user = userService.getUserByname(username);
        String password = user.getPassword();
        String salt = user.getSalt();
        return new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), getName());
    }
}
