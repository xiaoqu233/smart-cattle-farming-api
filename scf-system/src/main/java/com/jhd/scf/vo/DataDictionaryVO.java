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
public class DataDictionaryVO {

    @Schema(description = "编号（添加时不用传,修改时必传）", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "配置类型", requiredMode = Schema.RequiredMode.REQUIRED)
    private String dictType;

    @Schema(description = "配置key", requiredMode = Schema.RequiredMode.REQUIRED)
    private String bond;

    @Schema(description = "配置名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String bondName;

    @Schema(description = "排序")
    private Integer sort;
}