package com.stonebridge.springcloud.service;


import com.stonebridge.springcloud.config.FeignConfig;
import com.stonebridge.springcloud.entities.CommonResult;
import com.stonebridge.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",configuration = FeignConfig.class)
public interface PaymentFeignService {
    @RequestMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @RequestMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeOut();

}
