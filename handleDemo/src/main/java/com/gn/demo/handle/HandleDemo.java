package com.gn.demo.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gn
 * @Date: 2021-2-22
 * @Description:
 */
@RestController
@RequestMapping("/handleDemo")
@Slf4j
public class HandleDemo {

    @GetMapping("demo")
    public String demo(String methodName, String serverName){
        log.info("methodName:{}, serverName:{}", methodName, serverName);
        return "测试成功";
    }
}
