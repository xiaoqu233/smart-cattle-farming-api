package com.jhd.scf.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "数据字典项")
public class DataDictionaryItemVO {

    @Schema(description = "数据字典ID")
    private Long dataDictionaryId;

    @Schema(description = "Key")
    private String bond;

    @Schema(description = "名称")
    private String bondName;

    @Schema(description = "当前状态key的下一个状态key")
    private String nextKey;

    @Schema(description = "值1")
    private String value;

    @Schema(description = "值2")
    private String value2;

    @Schema(description = "排序")
    private Integer sort;

}