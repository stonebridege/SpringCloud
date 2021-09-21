package com.stonebridge.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
public class OrderZkController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate template;

    @RequestMapping("/consumer/payment/zk")
    @ResponseBody
    public String paymentInfo() {
        return template.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
