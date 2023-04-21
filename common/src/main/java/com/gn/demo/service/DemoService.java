package com.gn.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gn.demo.entity.MUser;

/**
 * @Author: gn
 * @Date: 2020-6-8 16:46
 * @Description:
 */
public interface DemoService extends IService<MUser> {

    /**
     * 测试
     * @return String
     */
    String demoFeign();

    String demoC();

    String test1(MUser mUser);
}
