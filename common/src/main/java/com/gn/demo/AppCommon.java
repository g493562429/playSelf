package com.gn.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: gn
 * @Date: 2020-6-8 16:43
 * @Description:
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableEurekaClient
@EnableFeignClients
@MapperScan({"com.gn.demo.mapper"})
@ComponentScan({"com.gn"})
public class AppCommon {
    public static void main(String[] args) {
        SpringApplication.run(AppCommon.class, args);
    }
}
