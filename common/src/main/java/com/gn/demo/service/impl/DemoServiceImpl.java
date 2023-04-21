package com.gn.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gn.demo.entity.MUser;
import com.gn.demo.mapper.UserMapper;
import com.gn.demo.sao.FeignDemo;
import com.gn.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: gn
 * @Date: 2020-6-8 16:47
 * @Description:
 */
@Service
@Slf4j
public class DemoServiceImpl extends ServiceImpl<UserMapper, MUser> implements DemoService {

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String test1(MUser mUser) {
        baseMapper.insert(MUser.builder().id(2L).age(2222).sex("0").grade("1.5").build());
        log.info("test1.s=[{}]", "111111111");
        String s = feignDemo.demoFeign2(mUser);
        log.info("test1.s=[{}]", s);
//        int a = 1 / 0;
        return s;
    }
}
