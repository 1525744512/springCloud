package com.example.feign.clients.fallback;

import com.example.feign.clients.orderClient;
import com.example.feign.entity.AjaxResult;
import feign.hystrix.FallbackFactory;

public class OrderClientFallbackFactory implements FallbackFactory<orderClient> {
    @Override
    public orderClient create(Throwable throwable) {
        return id -> {
            AjaxResult ajaxResult = new AjaxResult();
            ajaxResult.setCode(999);
            ajaxResult.setMsg("查询错误");
            ajaxResult.setData(null);
            return ajaxResult;
        };
    }
}
