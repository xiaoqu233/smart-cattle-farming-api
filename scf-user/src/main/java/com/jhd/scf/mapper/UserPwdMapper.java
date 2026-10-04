package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jhd.scf.entity.UserPwd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户密码mapper接口
 */

@Mapper
public interface UserPwdMapper extends BaseMapper<UserPwd> {

    /**
     * 根据用户id查询用户密码信息
     *
     * @param userId
     * @return
     */
    UserPwd selectByUserId(@Param("userId") Long userId);
}
