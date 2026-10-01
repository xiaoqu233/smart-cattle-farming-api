package com.jhd.scf.fallback;

import com.jhd.scf.feign.TestFeign;

public class TestFeignFallback implements TestFeign {

    @Override
    public String test() {
        return "远程调用错误";
    }
}
