package com.gn.demo;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.gn.demo.mapper")
public class AppPgSql {
    public static void main(String[] args) {
        SpringApplication.run(AppPgSql.class, args);
    }
}
