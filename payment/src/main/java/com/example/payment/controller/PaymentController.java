package com.example.payment.controller;


import com.example.feign.entity.AjaxResult;
import com.example.feign.entity.Payment;
import com.example.payment.config.PatternProperties;
import com.example.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
//@RefreshScope
public class PaymentController {

    @Resource
    private PaymentService paymentService;

//    @Value("${pattern.dateformat}")
//    private String dateformat;
    @Resource
    private PatternProperties patternProperties;

    @GetMapping("/prop")
    public PatternProperties properties(){
        return patternProperties;
    }

    @GetMapping("/now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }

    @PostMapping(value = "/payment/create")
    public AjaxResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        System.out.println("111");
        log.info("***插入结果：" + result + "******");
        if (result > 0){
            return new AjaxResult(200,"插入数据成功",result);
        }else {
            return new AjaxResult(404,"插入数据失败");
        }
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public AjaxResult<Payment> getPaymentById(@PathVariable Integer id){
        Payment result = paymentService.getPaymentById(id);
        log.info("***查询结果：" + result + "******");
        if (result !=null){
            return new AjaxResult<Payment>(200,"查询数据成功",result);
        }else {
            return new AjaxResult<Payment>(404,"没有对应记录，查询ID："+id);
        }
    }
}
