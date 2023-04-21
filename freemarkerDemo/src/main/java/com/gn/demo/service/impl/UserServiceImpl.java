package com.gn.demo.service.impl;/*
 * @Description:
 * @Author: GuiNing
 * @Date: 2023/4/14 11:40
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gn.demo.entity.MUser;
import com.gn.demo.mapper.UserMapper;
import com.gn.demo.service.UserService;
import com.gn.demo.utils.IdGeneratorSnowflake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, MUser> implements UserService {

    @Override
    public String addUser(String name) {
        long id = new IdGeneratorSnowflake().snowflakeId();
        log.info("addUser.id=[{}]", id);
        MUser mUser = MUser.builder()
                .id(id)
                .age(29)
                .name(name)
                .sex("1")
                .grade("99.5")
                .build();
        baseMapper.insert(mUser);
        return "success";
    }

    @Override
    public String deleteById(Long id) {
        baseMapper.deleteById(id);
        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateById(Long id, String name) {
        deleteById(id);
        log.info("2updateById.delete.id=[{}], updateById.update.name=[{}]",id, name);
        int a = 1 / 0;
        log.info("updateById.delete.id=[{}], updateById.update.name=[{}]",id, name);
        addUser(name);
        return "success";
    }
}
