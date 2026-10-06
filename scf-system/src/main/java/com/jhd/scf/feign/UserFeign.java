package com.jhd.scf.feign;

import com.jhd.scf.interceptor.FeignInterceptor;
import com.jhd.scf.utils.Res;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(value = "zhyz-user", configuration = FeignInterceptor.class)
public interface UserFeign {

    /**
     * 查询用户拥有的角色id
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping("/api/user/admin/userRole/{userId}")
    Res<List<Long>> userRole(@PathVariable("userId") Long userId);
}
