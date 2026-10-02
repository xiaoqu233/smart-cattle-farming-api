package com.jhd.scf.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.jhd.scf.feign.TestFeign;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestFeign testFeign;

    @Operation(summary = "接口拦截测试", description = "测试sa-token是否成功")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "登录成功"))
    @GetMapping
    public Object test() {
        return UUID.randomUUID();
    }

    /**
     * 获取Token进行测试
     *
     * @return
     */
    @Operation(summary = "用户登录测试", description = "仅用于测试，用户id是0")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "登录成功"))
    @GetMapping("/login")
    public Object login() {
        StpUtil.login(0);
        return StpUtil.getTokenValue();
    }


    /**
     * 权限校验测试
     *
     * @return
     */
    @Operation(summary = "鉴权测试", description = "集成测试，测试权限注解是否生效")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "登录成功"))
    @GetMapping("/annotation")
    @SaCheckPermission("auth:test:get")
    public Object test2() {
        return UUID.randomUUID();
    }

    /**
     * 测试远程调用 （用户服务的信息测试接口）
     *
     * @return
     */
    @Operation(summary = "远程调用测试", description = "用于测试远程调用是否集成功")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "登录成功"))
    @GetMapping("/feign")
    public Object feignTest() {
        return testFeign.test();
    }
}
