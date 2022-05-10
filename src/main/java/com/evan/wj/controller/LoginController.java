package com.evan.wj.controller;

import com.evan.wj.env.WJConstants;
import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@RestController
public class LoginController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(username);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }
    }


    @PostMapping(value = "/register")
    public Result register(@RequestBody User user) {
        String userName = user.getUsername();
        // 用户名
        userName = HtmlUtils.htmlEscape(userName);
        // DB查询用户
        User dbUser = userService.getUserByname(userName);
        if (Objects.nonNull(dbUser)) {
            // 用户名存在的场合
            return ResultFactory.buildFailResult("用户名已被占用");
        }

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 用户明文密码
        String userPassword = user.getPassword();
        // 加密后密码
        String hexEncoded = new SimpleHash(WJConstants.ALGORITHMNAME_MD5, userPassword, salt, WJConstants.HASHITERATIONS).toString();
        // 填充新用户对象
        user.setPassword(hexEncoded);
        user.setSalt(salt);
        // 将注册用户登入数据库
        userService.save(user);
        // 返回
        return ResultFactory.buildSuccessResult(user);
    }

    @GetMapping(value = "/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultFactory.buildSuccessResult("成功登出");
    }

    @GetMapping(value = "/authentication")
    public String authentication(){
        return "身份认证成功";
    }
}
