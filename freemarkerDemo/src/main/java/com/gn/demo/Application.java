package com.gn.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: gn
 * @Date: 2020-5-22 22:25
 * @Description: 启动类
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan({"com.gn.demo.mapper"})
@ComponentScan({"com.gn"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
