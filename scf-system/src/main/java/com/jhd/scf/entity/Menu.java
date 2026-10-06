package com.jhd.scf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 菜单对象
 */

@Data
@Builder
@TableName("menu")
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * url路径
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 菜单类型 （menu：菜单； button：按钮）
     */
    private String menuType;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 上级ID
     */
    private Long parentId;

    /**
     * 按钮权限
     */
    private String permission;

    /**
     * 子菜单 （不映射到数据库，仅数据查询时用）
     */
    @TableField(exist = false)
    private List<Menu> children;

}
