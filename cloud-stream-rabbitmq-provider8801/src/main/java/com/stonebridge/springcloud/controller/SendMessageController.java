package com.stonebridge.springcloud.controller;

import com.stonebridge.springcloud.service.IMessageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @RequestMapping(value = "/sendMessage")
    @ResponseBody
    public String sendMessage() {
        return messageProvider.send();
    }
}
