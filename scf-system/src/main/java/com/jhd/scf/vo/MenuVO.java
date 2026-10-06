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
@Schema(description = "菜单VO")
public class MenuVO {

    @Schema(description = "菜单编码（添加时不用传,修改时必传）", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "菜单名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String menuName;

    @Schema(description = "菜单url路径", requiredMode = Schema.RequiredMode.REQUIRED)
    private String path;

    @Schema(description = "菜单组件路径", requiredMode = Schema.RequiredMode.REQUIRED)
    private String component;

    @Schema(description = "菜单类型(menu：菜单；button：按钮)", requiredMode = Schema.RequiredMode.REQUIRED)
    private String menuType;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.AUTO)
    private Long sort;

    @Schema(description = "菜单上级id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long parentId;

    @Schema(description = "按钮权限（只有当菜单类型为button时，此参数才需要传）", requiredMode = Schema.RequiredMode.REQUIRED)
    private String permission;

    @Schema(hidden = true)
    private List<MenuVO> children;
}