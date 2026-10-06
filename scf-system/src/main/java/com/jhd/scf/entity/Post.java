package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * 岗位对象
 */

@Data
@Builder
@TableName("post")
public class Post extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /**
     * 岗位编码
     */
    private String postCode;

    /**
     * 岗位名称
     */
    private String postName;

}
