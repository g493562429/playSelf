package com.gn.demo.boot;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author: gn
 * @Date: 2020-11-25
 * @Description: 环境监听器，必须最早获取环境配置，在日志启动之前获取到配置信息
 */
@Slf4j
public class EnvironmentRunListener implements SpringApplicationRunListener, Ordered {

    public EnvironmentRunListener(SpringApplication application, String[] args) {
        log.info("spring应用启动监听start.application:{}, args:{}", JSON.toJSONString(application), JSON.toJSONString(args));
    }

    @Override
    public void starting() {
        //默认实现spring自带的listener中开始方法
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        //默认实现spring自带的构造器
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        //默认实现spring自带上下文的构造器
        log.info("contextPrepared 启动开始。。。。。。。。。。。");
        ConfigurableEnvironment env = context.getEnvironment();
        String[] activeProfiles = env.getActiveProfiles();
//        System.setProperty("gn.activeProfile", env.getProperty("demo.gn.ceShi"));
        log.info("activeProfiles:{}, gn.activeProfile:{}", JSON.toJSONString(activeProfiles), System.getProperty("gn.activeProfile"));
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        //默认实现spring自带上下文加载方法
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        //默认实现spring自带的应用加载开始方法
        log.info("started 启动开始。。。。。。。。。。。");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        //默认实现spring自带上下文运行方法
        log.info("running 启动开始。。。。。。。。。。。");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        //默认实现spring应用启动失败方法
    }

    @Override
    public int getOrder() {
        //加载优先级
        log.info("getOrder 启动开始。。。。。。。。。。。");
        return 101;
    }
}
