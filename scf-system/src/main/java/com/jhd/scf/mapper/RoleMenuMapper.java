package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jhd.scf.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单Mapper接口
 */

@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 根据角色id删除菜单权限
     *
     * @param roleId 角色id
     */
    int deleteByRoleId(@Param("roleId") Long roleId);

    /**
     * 批量添加角色菜单
     *
     * @param roleId  角色id
     * @param menuIds 菜单id
     * @return
     */
    int insertBatch(@Param("roleId") Long roleId, @Param("menuIds") List<Long> menuIds);

    /**
     * 查询角色对应的菜单
     *
     * @param roleId
     * @return
     */
    List<String> selectByRoleId(@Param("roleId") Long roleId);

}
