package com.example.feign.clients;

import com.example.feign.clients.fallback.OrderClientFallbackFactory;
import com.example.feign.entity.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "paymentService",fallbackFactory = OrderClientFallbackFactory.class)
public interface orderClient {

    @GetMapping("/payment/getPaymentById/{id}")
    AjaxResult getPaymentById(@PathVariable("id") Integer id);

//    private static final String PAYMENT_URL = "http://paymentService";
//    @Resource
//    private RestTemplate restTemplate;

//    @PostMapping(value = "/consumer/payment/create")
//    public AjaxResult create(Payment payment){
//        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,AjaxResult.class);
//    }
//
//    @GetMapping(value = "/consumer/payment/getPaymentById/{id}")
//    public AjaxResult getPaymentById(@PathVariable Integer id){
//        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,AjaxResult.class);
//    }
}
