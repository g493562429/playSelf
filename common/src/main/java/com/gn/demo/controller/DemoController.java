package com.gn.demo.controller;

import com.gn.demo.config.CommonConfig;
import com.gn.demo.entity.MUser;
import com.gn.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: gn
 * @Date: 2020-6-8 16:44
 * @Description:
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class DemoController {
    @Resource
    private DemoService demoService;

    @Resource
    private CommonConfig commonConfig;

    @GetMapping("/ss")
    public String demo(){
        log.info("配置获取测试：{}", commonConfig.getCeShi());
        return demoService.demoFeign();
    }
    @PostMapping("/toJson")
    public Json toJson(@RequestBody Map<String,Object> jsonpObject){
        log.info("入参:{}",jsonpObject.toString());
        return (Json)jsonpObject;
    }

    @PostMapping("/test1")
    public String test1(@RequestBody MUser mUser){
       return demoService.test1(mUser);
    }
}
