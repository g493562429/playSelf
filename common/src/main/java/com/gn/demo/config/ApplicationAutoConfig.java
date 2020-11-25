package com.gn.demo.config;

import com.gn.demo.utils.SpringApplicationUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: gn
 * @Date: 2020-11-25
 * @Description: 自动配置类
 */
@Configuration
public class ApplicationAutoConfig {
    @Bean
    public SpringApplicationUtil springContextUtil(){
        return new SpringApplicationUtil();
    }
}
