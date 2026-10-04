package com.jhd.scf.feign;

import com.jhd.scf.interceptor.FeignInterceptor;
import com.jhd.scf.utils.Res;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(value = "zhyz-system", configuration = FeignInterceptor.class)
public interface SystemFeign {

    /**
     * 查询用户权限，根据角色id查询对应的权限
     *
     * @param roleIds
     * @return
     */
    @GetMapping("/api/system/admin/role/permission")
    Res userPermission(@RequestParam List<Long> roleIds);
}
