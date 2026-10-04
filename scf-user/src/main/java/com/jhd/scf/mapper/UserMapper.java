package com.jhd.scf.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jhd.scf.entity.User;
import com.jhd.scf.vo.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户
     *
     * @param page 分页
     * @param query 查询条件
     * @return
     */
    IPage<User> query(Page<User> page, @Param("query") UserQuery query);

    /**
     * 根据手机号（账号）查询用户信息
     *
     * @param phone
     * @return
     */
    @InterceptorIgnore(tenantLine = "true", blockAttack = "true")
    User selectByPhone(@Param("phone") String phone);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    int deleteById(@Param("userId") Long userId);
}
