package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jhd.scf.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色Mapper接口
 */

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 查询所有角色
     *
     * @param name
     * @return
     */
    List<Role> selectAll(@Param("name") String name);

    /**
     * 查询角色是否存在
     *
     * @param roleName
     * @return
     */
    List<Role> roleExists(@Param("roleName") String roleName);

    /**
     * 删除岗位
     *
     * @param id 岗位id
     * @return
     */
    int deleteById(@Param("id") Long id);

    /**
     * 根据角色id查询对应的权限
     * @param roleIds 角色ids
     * @return
     */
    List<String> getUserPermission(@Param("roleIds") List<Long> roleIds);
}