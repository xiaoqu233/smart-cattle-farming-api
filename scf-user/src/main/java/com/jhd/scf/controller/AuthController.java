package com.jhd.scf.controller;

import com.jhd.scf.service.UserService;
import com.jhd.scf.utils.Res;
import com.jhd.scf.vo.AccountVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户接口")
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "app和后台管理统一登录接口")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "登录成功")})
    public Res login(@RequestBody AccountVO account) {
        return userService.login(account);
    }
}
