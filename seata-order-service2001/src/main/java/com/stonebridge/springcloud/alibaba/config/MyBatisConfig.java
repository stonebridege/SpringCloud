package com.stonebridge.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.stonebridge.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
