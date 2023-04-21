package com.gn.demo.controller;/*
 * @Description:
 * @Author: GuiNing
 * @Date: 2023/4/14 15:14
 */

import com.gn.demo.entity.MUser;
import com.gn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gnTest")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String addUser(String name){
        return userService.addUser(name);
    }

    @GetMapping("/deleteById")
    public String deleteById(Long id){
        return userService.deleteById(id);
    }

    @PostMapping("/updateById")
    public String updateById(@RequestBody MUser mUser){
        return userService.updateById(mUser.getId(), mUser.getName());
    }
}
