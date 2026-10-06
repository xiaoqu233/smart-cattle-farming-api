package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * 生产指标对象
 */

@Data
@Builder
@TableName("norm")
public class Norm {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 生产指标类型ID
     */
    private Long normTypeId;

    /**
     * 指标code
     */
    private String normCode;

    /**
     * 指标名称
     */
    private String normName;

    /**
     * 指标值
     */
    private String normValue;

    /**
     * 关系符 （大于 小于 等于）
     */
    private String relationship;
}
