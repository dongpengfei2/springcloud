package com.dpf.springloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dpf.springcloud.entities.CommonResult;

public class CustomerHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444, "客户自定义, global handleException------1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "客户自定义, global handleException------2");
    }
}
