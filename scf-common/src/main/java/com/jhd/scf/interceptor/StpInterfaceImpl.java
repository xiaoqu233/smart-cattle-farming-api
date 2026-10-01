package com.jhd.scf.interceptor;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // TODO 先配置为星号，拥有所有权限，后续要查询具体用户拥有的权限
        List<String> list = Arrays.asList("*");
        return list;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        return List.of();
    }
}
