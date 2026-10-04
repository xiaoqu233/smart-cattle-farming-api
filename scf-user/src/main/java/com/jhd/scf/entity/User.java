package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 用户对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User extends BaseEntity implements Cloneable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    private Long userNo;

    /**
     * 部门编号
     */
    private Long deptId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 头像
     */
    private String profilePicture;

    /**
     * 电话
     */
    private String phone;

    /**
     * 性别（1男；0女）
     */
    private Integer sex;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date bithday;

    /**
     * 地址
     */
    private String address;

    /**
     * 在职状态（1在职；0离职）
     */
    private Integer wotkState;

    /**
     * 用户状态
     */
    private String userState;

    /**
     * 入职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date entryTime;

    /**
     * 离职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date resignationTime;

    /**
     * 推荐人
     */
    private Long referrerId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户类型(app：普通用户；admin：管理员)
     */
    private String userType;
}
