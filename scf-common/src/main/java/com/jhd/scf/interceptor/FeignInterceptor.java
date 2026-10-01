package com.jhd.scf.interceptor;

import cn.dev33.satoken.same.SaSameUtil;
import cn.dev33.satoken.stp.StpUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;


/**
 * feign拦截器，在feign请求发出之前，加入一些操作
 */
@Component
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 1. 同源 Token：证明请求来自内部服务（验"路"）
        requestTemplate.header(SaSameUtil.SAME_TOKEN, SaSameUtil.getToken());
        // 2. 用户 Token：透传当前登录用户身份（验"人"）
        requestTemplate.header(StpUtil.getTokenName(), StpUtil.getTokenValue());
    }
}
