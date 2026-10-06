package com.jhd.scf.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "角色信息")
public class RoleVO {

    @Schema(description = "角色id（添加时不用传,修改时必传）", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "角色名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String roleName;

    @Schema(description = "角色类型", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String roleType;

    @Schema(description = "菜单ids",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Long> menuIds;

    @Schema(description = "备注")
    private String remark;

}