package com.jhd.scf.service.impl;

import com.jhd.scf.mapper.UserRoleMapper;
import com.jhd.scf.service.UserRoleService;
import com.jhd.scf.utils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 添加用户角色
     *
     * @param tenantId
     * @param userId
     * @param roleIds
     * @return
     */
    @Override
    public Res save(Long tenantId, Long userId, List<Long> roleIds) {

        // 删除用户角色
        userRoleMapper.deleteByUserId(userId);

        if (!roleIds.isEmpty()) {
            // 添加用户橘色
            userRoleMapper.insertBatch(userId, roleIds);
        }

        return Res.success();
    }

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    @Override
    public Res<List<Long>> userRole(Long userId) {
        List<Long> list = userRoleMapper.selectByUserId(userId);
        return null;
    }
}
