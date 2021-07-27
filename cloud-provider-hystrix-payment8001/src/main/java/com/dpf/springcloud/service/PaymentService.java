package com.dpf.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问的方法
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id){
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoOk, id:" + id + "...hahaha";
    }
//    @HystrixCommand(fallbackMethod="paymentInfoTimeoutHandle", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")
//    })
    public String paymentInfoTimeout(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoOk, id:" + id + "...timeout";
    }

    public String paymentInfoTimeoutHandle(Integer id){
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoTimeoutHandle, id:" + id;
    }

    //=============服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率超过多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("************ ID 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试";
    }
}
