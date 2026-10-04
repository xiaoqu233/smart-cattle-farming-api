package com.jhd.scf.controller;

import com.jhd.scf.service.UserRoleService;
import com.jhd.scf.utils.Res;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "用户角色接口")
@RestController
@RequestMapping("/admin/userRole")
public class UserRoleAdminController {

    @Autowired
    private UserRoleService userRoleService;

    @Operation(summary = "查询用户角色", description = "查询用户角色")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "登录成功")})
    @GetMapping("/{userId}")
    public Res<List<Long>> userRole(@PathVariable("userId") Long userId) {
        return userRoleService.userRole(userId);
    }
}
