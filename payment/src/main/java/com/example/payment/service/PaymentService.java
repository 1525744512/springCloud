package com.example.payment.service;


import com.example.feign.entity.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Integer id);
}
