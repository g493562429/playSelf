package com.gn.demo.controller;

import com.gn.demo.model.ReturnJson;
import com.gn.demo.service.RedisDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gn
 * @Date: 2021-3-2
 * @Description:
 */
@RestController
@RequestMapping("/redisDemo")
@Slf4j
public class RedisDemoController {

    @Autowired
    private RedisDemoService redisDemoService;

    @GetMapping("/demo")
    public ReturnJson redisDemo(String id){
        log.info("id:{}", id);
        return redisDemoService.selectById(id);
    }
}
