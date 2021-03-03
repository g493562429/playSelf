package com.gn.demo.service.impl;

import com.gn.demo.Factory.ReturnJsonFactory;
import com.gn.demo.config.RedisConfig;
import com.gn.demo.mapper.TeacherMapper;
import com.gn.demo.model.ReturnJson;
import com.gn.demo.service.RedisDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author: gn
 * @Date: 2021-3-2
 * @Description:
 */
@Service
@Slf4j
public class RedisDemoServiceImpl implements RedisDemoService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public ReturnJson selectById(String id) {
        if (this.isExist(id)) {
            log.info("{}获取缓存start...", id);
            return ReturnJsonFactory.success(redisTemplate.opsForValue().get(id));
        }
        log.info("{}获取数据库数据start...", id);
        return ReturnJsonFactory.success(teacherMapper.selectTeacherById(Integer.parseInt(id)));
    }

    private boolean isExist(String id) {
        return !StringUtils.isEmpty(redisTemplate.opsForValue().get(id));
    }
}
