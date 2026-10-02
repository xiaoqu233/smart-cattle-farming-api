package com.jhd.scf.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 分页查询类
 */
@Data
public class PageQuery {
    @Schema(description = "页码", requiredMode = Schema.RequiredMode.REQUIRED)
    private int page = 1;

    @Schema(description = "每页显示数量", requiredMode = Schema.RequiredMode.REQUIRED)
    private int Size = 10;
}
