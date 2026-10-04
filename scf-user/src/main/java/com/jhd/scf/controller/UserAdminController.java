package com.jhd.scf.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.jhd.scf.service.UserService;
import com.jhd.scf.utils.Res;
import com.jhd.scf.vo.UserVO;
import com.jhd.scf.vo.query.UserQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户
 */
@Tag(name = "用户接口")
@RestController
@RequestMapping("/admin/user")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @Operation(summary = "用户查询", description = "查询所有用户")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "请求成功")})
    @SaCheckPermission("sys:users:list")
    @GetMapping("/list")
    public Res query(UserQuery query) {
        return userService.query(query);
    }

    @Operation(summary = "添加用户", description = "添加用户")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "添加成功")})
    @SaCheckPermission("sys:users:save")
    @PostMapping
    public Res save(@RequestBody UserVO data) {
        return userService.save(data);
    }

    @Operation(summary = "修改用户", description = "根据id修改用户")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "修改成功")})
    @SaCheckPermission("sys:users:update")
    @PutMapping
    public Res update(@RequestBody UserVO data) {
        return userService.update(data);
    }

    @Operation(summary = "删除用户", description = "根据id删除用户")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "删除成功")})
    @SaCheckPermission("sys:users:delete")
    @DeleteMapping("/{id}")
    public Res delete(
            @Parameter(name = "id", description = "用户id")
            @PathVariable(name = "id") Long id
            ) {
        return userService.delete(id);
    }
}
