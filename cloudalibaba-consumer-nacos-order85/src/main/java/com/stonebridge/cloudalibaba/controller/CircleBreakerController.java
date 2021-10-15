package com.stonebridge.cloudalibaba.controller;

import com.stonebridge.cloudalibaba.service.PaymentService;
import com.stonebridge.springcloud.entities.CommonResult;
import com.stonebridge.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Slf4j
public class CircleBreakerController {

    @Resource
    private PaymentService paymentService;

    @RequestMapping(value = "/consumer/openfeign/{id}")
    @ResponseBody
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new RuntimeException("没有该id");
        }
        return paymentService.paymentSQL(id);
    }
}

