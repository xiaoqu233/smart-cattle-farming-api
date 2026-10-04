package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jhd.scf.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色Mapper接口
 */

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据用户id删除角色
     *
     * @param userId
     */
    void deleteByUserId(@Param("userId") Long userId);

    /**
     * 添加用户角色
     *
     * @param userId 用户id
     * @param roleIds 角色id数组
     */
    void insertBatch(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    List<Long> selectByUserId(Long userId);
}
