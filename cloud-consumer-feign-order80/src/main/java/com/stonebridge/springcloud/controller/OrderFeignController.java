package com.stonebridge.springcloud.controller;

import com.stonebridge.springcloud.entities.CommonResult;
import com.stonebridge.springcloud.entities.Payment;
import com.stonebridge.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/consumer/payment/get/{id}")
    @ResponseBody
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
