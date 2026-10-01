package com.jhd.scf.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Object login() {
        // sa-token登录方法：1是用户
        StpUtil.login(1);

        // 获取用户登录后的token
        String tokenValue = StpUtil.getTokenValue();

        return tokenValue;
    }

    /**
     * 远程调用测试接口
     *
     * @return
     */
    @GetMapping("/info")
    public String info() {
        return "user service:" + UUID.randomUUID().toString();
    }
}
