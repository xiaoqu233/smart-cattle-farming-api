package com.jhd.scf.service;

import com.jhd.scf.utils.Res;
import com.jhd.scf.vo.AccountVO;
import com.jhd.scf.vo.UserVO;
import com.jhd.scf.vo.query.UserQuery;

/**
 * 用户
 */
public interface UserService {

    /**
     * 查询用户
     *
     * @param query
     * @return
     */
    Res query(UserQuery query);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Res save(UserVO user);

    /**
     * 用户修改
     *
     * @param data
     * @return
     */
    Res update(UserVO data);

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return
     */
    Res delete(Long userId);

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    Res getUserInfo(long userId);

    /**
     * 查询用户权限
     *
     * @param userId
     * @return
     */
    Res userRole(long userId);

    /**
     * 登录
     *
     * @param data
     * @return
     */
    Res login(AccountVO data);
}
