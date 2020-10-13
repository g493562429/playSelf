package com.gn.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: gn
 * @Date: 2020-7-25
 * @Description:
 */
@ConfigurationProperties(prefix = "demo.gn")
@Component
@Data
public class CommonConfig {
    private String ceShi;
}
