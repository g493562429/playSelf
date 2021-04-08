package com.gn.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gn
 * @Date: 2021-3-9
 * @Description:
 */
@RestController
@RequestMapping("logDemo")
@Slf4j
public class LogController {

    @GetMapping("log")
    public String demo(){
        log.info("demo");
        return "hello world";
    }

}
