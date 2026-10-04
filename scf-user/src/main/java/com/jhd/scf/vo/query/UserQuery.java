package com.jhd.scf.vo.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户查询类")
public class UserQuery {

    @Schema(description = "部门id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long deptId;

    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String userName;

    @Schema(description = "手机号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String phone;

    @Schema(description = "用户类型 (app:手机用户; admin:后端管理用户)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String userType;

    @Schema(description = "页面", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private int page = 1;

    @Schema(description = "每页显示数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private int size = 10;
}
