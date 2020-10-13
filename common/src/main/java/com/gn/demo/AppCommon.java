package com.gn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: gn
 * @Date: 2020-6-8 16:43
 * @Description:
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableEurekaClient
@EnableFeignClients
public class AppCommon {
    public static void main(String[] args) {
        SpringApplication.run(AppCommon.class, args);
    }
}
