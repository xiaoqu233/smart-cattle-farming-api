package com.jhd.scf.service;

import com.jhd.scf.utils.Res;

import java.util.List;

/**
 * 用户角色
 */

public interface UserRoleService {

    /**
     * 添加用户角色
     *
     * @param tenantId
     * @param userId
     * @param roleIds
     * @return
     */
    Res save(Long tenantId, Long userId, List<Long> roleIds);

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    Res<List<Long>> userRole(Long userId);
}
