package com.gn.demo.sao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: gn
 * @Date: 2020-6-8 16:48
 * @Description:
 */
@FeignClient(name = "freemarker-demo")
@Component
public interface FeignDemo {

    /**
     * 测试
     * @return String
     */
    @GetMapping("/gn/demo")
    String demoFeign();
}
