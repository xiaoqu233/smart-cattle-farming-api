package com.jhd.scf.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMenuVO {
    /**
     * 菜单名称
     */
    private String name;

    /**
     * url路径
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 元信息
     */
    private MetaVO meta;

    /**
     * 子菜单
     */
    private List<UserMenuVO> children;

    /**
     * 排序
     */
    private Long sort;
}