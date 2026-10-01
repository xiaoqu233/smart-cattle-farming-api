package com.jhd.scf.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Object test() {
        return UUID.randomUUID();
    }

    /**
     * 获取Token进行测试
     *
     * @return
     */
    @GetMapping("/login")
    public Object login() {
        StpUtil.login(0);
        return StpUtil.getTokenValue();
    }

    @GetMapping("/annotation")
    @SaCheckPermission("auth:test:get")
    public Object test2() {
        return UUID.randomUUID();
    }
}
