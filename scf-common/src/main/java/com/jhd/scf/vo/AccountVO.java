package com.jhd.scf.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录实体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "用户登录", description = "账号和密码")
public class AccountVO {

    @Schema(description = "账号", defaultValue = "cmh")
    private String account;

    @Schema(description = "密码", defaultValue = "123456")
    private String password;
}
