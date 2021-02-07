package com.gn.demo.controller;

import com.alibaba.fastjson.JSON;
import com.gn.demo.dto.Teacher;
import com.gn.demo.model.ReturnJson;
import com.gn.demo.service.TeacherService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: gn
 * @Date: 2020-9-9
 * @Description:
 */
@RestController
@RequestMapping("/gg")
@Slf4j
public class DemoController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/selectById")
    @ApiModelProperty(name = "查询方法", value = "查询方法")
    public ReturnJson selectById(int id) {
        return teacherService.selectById(id);
    }

    @PostMapping("/selectByName")
    @ApiModelProperty(name = "查询方法-根据name查询", value = "查询方法-根据name查询")
    public ReturnJson selectByName(String name) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info("parameterMap:{}", JSON.toJSONString(parameterMap));
        return teacherService.selectByName(name);
    }

    @PostMapping("/selectAny")
    @ApiModelProperty(name = "查询方法-根据任一条件查询", value = "查询方法-根据任一条件查询")
    public ReturnJson selectAny(Teacher teacher) {
        return teacherService.select(teacher);
    }

    @PostMapping("/selectTeachers")
    @ApiModelProperty(name = "查询teacher列表方法", value = "查询teacher列表方法")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = ReturnJson.class)
    })
    public ReturnJson selectTeachers() {
        long start = System.currentTimeMillis();
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Cookie[] cookies = request.getCookies();
        log.info("cookies:{}", JSON.toJSONString(cookies));
        ReturnJson returnJson = teacherService.selectTeachers();
        long end = System.currentTimeMillis();
        log.info("查询耗时:{} ms", end - start);
        return returnJson;
    }

    @PostMapping("/insert")
    @ApiModelProperty(name = "添加方法", value = "添加方法")
    public ReturnJson insert(Teacher teacher) {
        return teacherService.add(teacher);
    }

    @PostMapping("/upSert")
    @ApiModelProperty(name = "添加方法", value = "添加方法")
    public ReturnJson upSert(Teacher teacher) {
        return teacherService.upSert(teacher);
    }

    @PostMapping("/updateById")
    @ApiModelProperty(name = "修改方法", value = "修改方法")
    public ReturnJson updateById(Teacher teacher) {
        long start = System.currentTimeMillis();
        ReturnJson returnJson = teacherService.updateById(teacher);
        long end = System.currentTimeMillis();
        log.info("修改耗时:{} ms", end - start);
        return returnJson;
    }

    @PostMapping("/deleteById")
    @ApiModelProperty(name = "删除方法", value = "删除方法")
    public ReturnJson deleteById(Integer id) {
        return teacherService.deleteById(id);
    }

}
