package com.gn.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.gn.demo.dto.Teacher;
import com.gn.demo.mapper.TeacherMapper;
import com.gn.demo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: gn
 * @Date: 2020-10-26
 * @Description:
 */
@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;


    @Override
    public Teacher selectById(int id) {
        Teacher teacher = teacherMapper.selectTeacherById(id);
        log.info("selectById.teacher:{}", JSON.toJSONString(teacher));
        return teacher;
    }

    @Override
    public Boolean add(Teacher teacher) {
        int result = teacherMapper.addTeacher(teacher);
        log.info("add.result:{}", result);
        return result != 0;
    }

    @Override
    public Boolean updateById(Teacher teacher) {
        int result = teacherMapper.updateById(teacher);
        log.info("updateById.result:{}", result);
        return result != 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        int result = teacherMapper.deleteById(id);
        log.info("deleteById.result:{}", result);
        return result != 0;
    }

    @Override
    public Teacher selectByName(String name) {
        Teacher teacher = teacherMapper.selectTeacherByName(name);
        log.info("selectByName.teacher:{}", JSON.toJSONString(teacher));
        return teacher;
    }
}
