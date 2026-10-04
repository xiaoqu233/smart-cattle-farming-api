package com.jhd.scf.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.jhd.scf.service.UserService;
import com.jhd.scf.utils.Res;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 */
@Tag(name = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     *
     * @return
     */
    @GetMapping("/info")
    public Res userInfo() {
        return userService.getUserInfo(StpUtil.getLoginIdAsLong());
    }

    /**
     * 查询用户权限
     *
     * @return
     */
    @GetMapping("/role")
    public Res userRole() {
        return userService.userRole(StpUtil.getLoginIdAsLong());
    }
}
