package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * 生产指标类型对象
 */

@Data
@Builder
@TableName("norm_type")
public class NormType extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /**
     * 指标code
     */
    private String normCode;

    /**
     * 指标名称
     */
    private String normName;
}
