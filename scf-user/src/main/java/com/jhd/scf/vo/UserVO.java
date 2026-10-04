package com.jhd.scf.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户VO")
public class UserVO {

    /**
     * id
     */
    @Schema(description = "用户id（添加时省略，修改时必须）")
    private Long id;

    /**
     * 租户id
     */
    @Schema(description = "租户id")
    private Long tenantId;

    /**
     * 部门id
     */
    @Schema(description = "部门id")
    private Long deptId;

    /**
     * 姓名
     */
    @Schema(description = "用户名")
    private String userName;

    /**
     * 电话
     */
    @Schema(description = "电话")
    private String phone;

    /**
     * 性别（1男；0女）
     */
    @Schema(description = "性别 （1男；0女）")
    private Integer sex;

    /**
     * 生日
     */
    @Schema(description = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date bithday;

    /**
     * 地址
     */
    @Schema(description = "地址")
    private String address;

    /**
     * 入职时间
     */
    @Schema(description = "入职时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime entryTime;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 用户类型(app：普通用户；admin：管理员)
     */
    @Schema(description = "用户类型 (app:普通用户; admin:管理员)")
    private String userType;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "角色id(数组), 一个账号可以拥有多个角色")
    private List<Long> roleIds;
}
