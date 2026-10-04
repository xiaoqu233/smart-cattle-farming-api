package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户岗位对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_post")
public class UserPost {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 岗位id
     */
    private Long postId;
}
