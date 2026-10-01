package com.jhd.scf.feign;

import com.jhd.scf.fallback.TestFeignFallback;
import com.jhd.scf.interceptor.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "zhyz-user",                         // 服务名称
        configuration = FeignInterceptor.class,     // 请求拦截器
        fallbackFactory = TestFeignFallback.class   // 服务降级处理
)
@Service
public interface TestFeign {

    @GetMapping("/api/user/test/info")
    String test();
}
