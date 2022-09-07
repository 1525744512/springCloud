package com.example.feign.config;

import com.example.feign.clients.fallback.OrderClientFallbackFactory;
import org.springframework.context.annotation.Bean;

public class FegionConfiguration {

    @Bean
    public OrderClientFallbackFactory orderClientFallbackFactory(){
        return new OrderClientFallbackFactory();
    }

}
