package com.stonebridge.cloudalibaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FlowLimitController {
    @RequestMapping("/testA")
    @ResponseBody
    public String testA() {
        return "------testA";
    }

    @RequestMapping("/testB")
    @ResponseBody
    public String testB() {
        return "------testB";
    }
}
