package com.gn.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @Author: gn
 * @Date: 2020-11-25
 * @Description: 获取SpringBean实例的工具类
 */
public class SpringApplicationUtil implements ApplicationContextAware, EnvironmentAware {

    private static ApplicationContext applicationContext;
    private static Environment env;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationUtil.applicationContext = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        SpringApplicationUtil.env = environment;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static String getModelAttribute(String name) {
        return applicationContext.getEnvironment().getProperty(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static Environment getEnvironment() {
        return env;
    }

    public static String getProperty(String name) {
        return env.getProperty(name);
    }
}
