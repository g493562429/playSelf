package com.gn.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.gn.demo.dto.Teacher;
import com.gn.demo.mapper.TeacherMapper;
import com.gn.demo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: gn
 * @Date: 2020-10-26
 * @Description:
 */
@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public Teacher selectById(int id) {
        Teacher teacher = teacherMapper.selectTeacherById(id);
        log.info(JSON.toJSONString(teacher));
        return teacher;
    }

    @Override
    public Boolean add(Teacher teacher) {
        int result = teacherMapper.addTeacher(teacher);
        return result != 0;
    }

    @Override
    public Boolean updateById(Teacher teacher) {
        int result = teacherMapper.updateById(teacher);
        return result != 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        int result = teacherMapper.deleteById(id);
        return result != 0;
    }
}
