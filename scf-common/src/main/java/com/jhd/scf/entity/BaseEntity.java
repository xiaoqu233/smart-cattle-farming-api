package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 实体基类（父类）
 */
@Data
public class BaseEntity {

    /**
     * id
     */
    @Schema(hidden = true)
    private Long id;

    /**
     * 租户id
     */
    @Schema(hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Long tenantId;

    /**
     * 创建时间
     */
    @Schema(hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @Schema(hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 版本（乐观锁）
     */
    @Schema(hidden = true)
    @Version
    private Integer version;

    /**
     * 状态
     */
    @Schema(hidden = true)
    private Integer status;

    /**
     * 删除标识：del已删除，ok正常
     */
    @Schema(hidden = true)
    private String deleteFlag;

    /**
     * 备注
     */
    @Schema(hidden = true)
    private String remark;
}
