package com.stonebridge.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
@Slf4j
public class FlowLimitController {
    @RequestMapping("/testA")
    @ResponseBody
    public String testA() {
        return "------testA";
    }

    @RequestMapping("/testB")
    @ResponseBody
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "testB");
        return "------testB";
    }

    @RequestMapping("/testD")
    @ResponseBody
    public String testD() {
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------testD";
    }

    @RequestMapping("/testE")
    @ResponseBody
    public String testE() {
        System.out.println("testE 测试RT");
        int age = 10 / 0;
        return "------testE";
    }

    @RequestMapping("/testF")
    @ResponseBody
    public String testF() {
        System.out.println("testF 测试RT");
        int age = 10 / 0;
        return "------testF";
    }

    @RequestMapping("/testHotKey")
    @ResponseBody
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String dealHandler_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandler_testHotKey";
    }

}
