package com.gn.demo.service.impl;

import com.gn.demo.sao.FeignDemo;
import com.gn.demo.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: gn
 * @Date: 2020-6-8 16:47
 * @Description:
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private FeignDemo feignDemo;

    @Override
    public String demoFeign() {
        return feignDemo.demoFeign();
    }

    @Override
    public String demoC() {
        return "测试类测试成功";
    }
}
