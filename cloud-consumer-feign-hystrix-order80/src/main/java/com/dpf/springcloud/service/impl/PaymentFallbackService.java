package com.dpf.springcloud.service.impl;

import com.dpf.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "------- PaymentFallbackService fall paymentInfoOk";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "------- PaymentFallbackService fall paymentInfoTimeout";
    }
}
