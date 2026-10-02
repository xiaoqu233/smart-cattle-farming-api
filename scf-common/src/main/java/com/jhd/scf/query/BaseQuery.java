package com.jhd.scf.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询通用类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseQuery {

    @Schema(description = "查询名称")
    private String name;

    @Schema(description = "日期")
    private String date;

    @Schema(description = "审核状态：pendingReview待审核，pass通过，turnDown驳回")
    private String auditlStatus;

    @Schema(description = "页码")
    private Integer page = 1;

    @Schema(description = "数量")
    private Integer size = 10;
}
