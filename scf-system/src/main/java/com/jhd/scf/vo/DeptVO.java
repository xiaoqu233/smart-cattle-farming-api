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
@Schema(description = "部门信息")
public class DeptVO implements Cloneable {

    @Schema(description = "部门编码（添加时不用传,修改时必传）", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(hidden = true)
    private Long tenantId;

    @Schema(description = "上级部门", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long parentId;

    @Schema(description = "部门编码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String deptCode;

    @Schema(description = "部门名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String deptName;

    @Schema(description = "部门负责人")
    private Long principalId;

    @Schema(description = "备注")
    private String remark;
}