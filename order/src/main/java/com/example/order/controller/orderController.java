package com.example.order.controller;

import com.example.feign.clients.orderClient;
import com.example.feign.entity.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class orderController {

    @Resource
    private orderClient orderClient;

    @GetMapping("/consumer/getPaymentById/{id}")
    public AjaxResult getPaymentById(@PathVariable("id") Integer id, @RequestHeader(value = "Truth",required = false) String truth){
        System.out.println("Truth:"+truth);
        return orderClient.getPaymentById(id);
    }

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
