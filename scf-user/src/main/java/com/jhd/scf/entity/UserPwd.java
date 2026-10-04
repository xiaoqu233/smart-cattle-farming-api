package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户密码对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_pwd")
public class UserPwd {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 密码过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireDate;
}
