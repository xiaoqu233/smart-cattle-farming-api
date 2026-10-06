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
@Schema(description = "岗位信息")
public class PostVO {

    @Schema(description = "部门编码（添加时不用传,修改时必传）", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "岗位编码", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String postCode;

    @Schema(description = "岗位名称", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String postName;

    @Schema(description = "备注(此处用于存岗位职责)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String remark;
}