package com.gn.demo.controller;

import com.gn.demo.dto.Teacher;
import com.gn.demo.service.TeacherService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gn
 * @Date: 2020-9-9
 * @Description:
 */
@RestController
@RequestMapping("/gg")
public class DemoController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/selectById")
    @ApiModelProperty(name = "查询方法", value = "查询方法")
    public Teacher selectById(int id){
        return teacherService.selectById(id);
    }

    @PostMapping("/selectByName")
    @ApiModelProperty(name = "查询方法-根据name查询", value = "查询方法-根据name查询")
    public Teacher selectByName(String name){
        return teacherService.selectByName(name);
    }

    @PostMapping("/insert")
    @ApiModelProperty(name = "添加方法", value = "添加方法")
    public Boolean insert(Teacher teacher){
        return teacherService.add(teacher);
    }

    @PostMapping("/updateById")
    @ApiModelProperty(name = "修改方法", value = "修改方法")
    public Boolean updateById(Teacher teacher){
        return teacherService.updateById(teacher);
    }

    @PostMapping("/deleteById")
    @ApiModelProperty(name = "删除方法", value = "删除方法")
    public Boolean deleteById(Integer id){
        return teacherService.deleteById(id);
    }

}
