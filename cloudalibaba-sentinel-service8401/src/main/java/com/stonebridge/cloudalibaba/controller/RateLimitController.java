package com.stonebridge.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.stonebridge.cloudalibaba.myhandler.CustomerBlockHandler;
import com.stonebridge.springcloud.entities.CommonResult;
import com.stonebridge.springcloud.entities.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RateLimitController {
    @RequestMapping("/byResource")
    @ResponseBody
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @RequestMapping("/rateLimit/TestBlockHandler")
    @ResponseBody
    @SentinelResource(value = "TestBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handleException2")
    public CommonResult TestBlockHandler() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

}

