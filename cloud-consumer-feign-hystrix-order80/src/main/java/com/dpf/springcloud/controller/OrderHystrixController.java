package com.dpf.springcloud.controller;

import com.dpf.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobal_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/consumer/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoOk(id);
        return result;
    }
    @GetMapping("/payment/consumer/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
//    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoTimeout(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙，10秒钟后再试或者自己运行出错请检查自己";
    }

    public String paymentGlobal_FallbackMethod(){
        return "Global异常处理信息，请稍后再试";
    }
}
