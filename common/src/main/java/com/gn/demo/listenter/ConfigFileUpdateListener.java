package com.gn.demo.listenter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: gn
 * @Date: 2020-11-25
 * @Description: 配置文件更新监听器
 */
@Component
@Slf4j
public class ConfigFileUpdateListener implements ApplicationRunner {

    /**
     * 配置文件名
     */
    private static final String APPLICATION_YML = "application.yml";

    @Override
    public void run(ApplicationArguments args){
        log.info("配置文件更新监听器创建");
    }
}
