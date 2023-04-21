package com.gn.demo.sao;

import com.gn.demo.entity.MUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    /**
     * 测试
     * @return String
     */
    @PostMapping("/gnTest/updateById")
    String demoFeign2(MUser mUser);
}
