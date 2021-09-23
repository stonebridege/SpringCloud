package com.stonebridge.springcloud.controller;

import com.stonebridge.springcloud.entities.CommonResult;
import com.stonebridge.springcloud.entities.Payment;
import com.stonebridge.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/payment/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("result:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort：" + serverPort, result);
        } else {
            return new CommonResult(500, "插入数据库失败,serverPort：" + serverPort, null);
        }
    }

    @RequestMapping(value = "/payment/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort：" + serverPort, payment);
        } else {
            return new CommonResult(200, "查询失败，没有对应记录,serverPort：" + serverPort, null);
        }
    }

    @RequestMapping(value = "/payment/lb")
    @ResponseBody
    public String getPaymentLB() {
        return serverPort;
    }

}
