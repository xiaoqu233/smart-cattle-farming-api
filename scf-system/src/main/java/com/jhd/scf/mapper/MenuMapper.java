package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jhd.scf.entity.Menu;
import com.jhd.scf.vo.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单Mapper接口
 */

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询角色菜单（不包含按钮）
     *
     * @param roleIds 角色id
     * @return
     */
    List<Menu> selectByRoleIds(@Param("roleIds") List<Long> roleIds);

    /**
     *
     * @param roleIds
     * @return
     */
    List<Menu> selectUserMenuByRoleIds(@Param("roleIds") List<Long> roleIds);

    /**
     * 查询所有菜单
     *
     * @param name
     * @return
     */
    List<Menu> selectAll(@Param("name") String name);

    /**
     * 树形菜单（不包含按钮）
     *
     * @return
     */
    List<MenuVO> tree();

    /**
     * 根据id删除菜单
     *
     * @param id 菜单id
     * @return
     */
    int deleteById(@Param("id") Long id);

    /**
     * 树形菜单（包含菜单和按钮）
     * @return
     */
    List<MenuVO> all();
}
