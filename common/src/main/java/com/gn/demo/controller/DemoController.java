package com.gn.demo.controller;

import com.gn.demo.config.CommonConfig;
import com.gn.demo.service.DemoService;
import com.gn.demo.utils.RedisDistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: gn
 * @Date: 2020-6-8 16:44
 * @Description:
 */
@Controller
@RequestMapping("/common")
@Slf4j
public class DemoController {
    @Resource
    private DemoService demoService;

    @Resource
    private CommonConfig commonConfig;

    @Autowired
    @Qualifier("gnRedisDistributedLock")
    private RedisDistributedLock redisDistributedLock;

    @GetMapping("/ss")
    @ResponseBody
    public String demo(){
        log.info("配置获取测试：{}", commonConfig.getCeShi());
        return demoService.demoFeign();
    }
    @PostMapping("/toJson")
    @ResponseBody
    public Json toJson(@RequestBody Map<String,Object> jsonpObject){
        log.info("入参:{}",jsonpObject.toString());
        return (Json)jsonpObject;
    }
    @GetMapping("/tryLock")
    @ResponseBody
    public boolean tryLock(@RequestParam String lockName, @RequestParam long expiredTime){
        log.info("获取锁 start...");
        boolean result = redisDistributedLock.tryLock(lockName, expiredTime);
        log.info("获取锁 result:{}", result);
        return result;
    }

    @GetMapping("/unLock")
    @ResponseBody
    public boolean unLock(@RequestParam String lockName){
        log.info("释放锁 start...");
        boolean result = redisDistributedLock.unlock(lockName);
        log.info("释放锁 result:{}", result);
        return result;
    }
}
