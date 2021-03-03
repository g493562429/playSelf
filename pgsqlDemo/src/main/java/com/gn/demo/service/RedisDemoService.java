package com.gn.demo.service;

import com.gn.demo.model.ReturnJson;

/**
 * @Author: gn
 * @Date: 2021-3-2
 * @Description:
 */
public interface RedisDemoService {
    ReturnJson selectById(String id);
}
