package com.gn.demo.service;/*
 * @Description:
 * @Author: GuiNing
 * @Date: 2023/4/14 11:39
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.gn.demo.entity.MUser;

public interface UserService extends IService<MUser> {

    String addUser(String name);

    String deleteById(Long id);

    String updateById(Long id, String name);
}
