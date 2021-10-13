package com.stonebridge.cloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.stonebridge.springcloud.entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handleException1(BlockException exception) {
        return new CommonResult(1234, "自定义的限流处理信息......CustomerBlockHandler");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(4567, "自定义的限流处理信息......CustomerBlockHandler");
    }
}
