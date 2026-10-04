package com.jhd.scf.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "用户登录后的信息", description = "用户登陆后的信息，包含名称、头像、凭证")
public class LoginInfoVO {

    @Schema(description = "名称")
    private String userName;

    @Schema(description = "头像地址")
    private String profilePicture;

    @Schema(description = "token")
    private String accessToken;
}
