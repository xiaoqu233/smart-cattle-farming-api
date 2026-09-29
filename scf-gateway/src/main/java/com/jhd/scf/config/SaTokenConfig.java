package com.jhd.scf.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaTokenConfig {

    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截地址（拦截全部地址）
                .addInclude("/**")
                // 开放地址（以下接口地址属于接口API文档，需要放行，否则各个服务API接口不能访问）
                .addExclude(
                        "/doc.html",
                        "/webjars/**",
                        "/v3/api-docs/swagger-config",
                        "/api/auth/v3/api-docs/default",
                        "/api/user/v3/api-docs/app",
                        "/api/user/v3/api-docs/admin",
                        "/api/system/v3/api-docs/app",
                        "/api/system/v3/api-docs/admin",
                        "/api/production/v3/api-docs/app",
                        "/api/production/v3/api-docs/admin",
                        "/api/invoicing/v3/api-docs/app",
                        "/api/invoicing/v3/api-docs/admin"
                )
                // 鉴权方法
                .setAuth(obj -> {
                    // 登录校验：拦截所有路由，并排除 /user/login 用于开放登录
                    SaRouter.match("/**", "/api/auth/login", r -> StpUtil.checkLogin());
                    SaRouter.match("/**", "/api/auth/test", r -> StpUtil.checkLogin());
                })
                // 异常处理方法：每次setAuth函数出现异常时进入
                .setError(e -> {
                    return SaResult.error(e.getMessage());
                });

    }
}
