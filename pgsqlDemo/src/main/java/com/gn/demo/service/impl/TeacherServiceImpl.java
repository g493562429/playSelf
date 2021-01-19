package com.gn.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.gn.demo.Factory.ReturnJsonFactory;
import com.gn.demo.dto.Teacher;
import com.gn.demo.mapper.TeacherMapper;
import com.gn.demo.model.ReturnJson;
import com.gn.demo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public ReturnJson selectById(int id) {
        Teacher teacher = teacherMapper.selectTeacherById(id);
        log.info("selectById.teacher:{}", JSON.toJSONString(teacher));
        return ReturnJsonFactory.success(teacher);
    }

    @Override
    public ReturnJson add(Teacher teacher) {
        int result = teacherMapper.addTeacher(teacher);
        log.info("add.result:{}", result);
        return ReturnJsonFactory.success(result != 0);
    }

    @Override
    public ReturnJson updateById(Teacher teacher) {
        int result = teacherMapper.updateById(teacher);
        log.info("updateById.result:{}", result);
        return ReturnJsonFactory.success(result != 0);
    }

    @Override
    public ReturnJson deleteById(Integer id) {
        int result = teacherMapper.deleteById(id);
        log.info("deleteById.result:{}", result);
        return ReturnJsonFactory.success(result != 0);
    }

    @Override
    public ReturnJson selectByName(String name) {
        Teacher teacher = teacherMapper.selectTeacherByName(name);
        log.info("selectByName.teacher:{}", JSON.toJSONString(teacher));
        return ReturnJsonFactory.success(teacher);
    }

    @Override
    public ReturnJson select(Teacher teacher) {
        List<Teacher> teachers = teacherMapper.select(teacher);
        log.info("select.teachers:{}", JSON.toJSONString(teachers));
        return ReturnJsonFactory.success(teachers);
    }

    /**
     * 查询teacher列表方法
     * @return ReturnJson
     */
    @Override
    public ReturnJson selectTeachers() {
        List<Teacher> teachers = teacherMapper.selectTeachers();
        log.info("selectTeachers:{}", JSON.toJSONString(teachers));
        return ReturnJsonFactory.success(teachers);
    }

    /**
     * 新增/修改
     * @param teacher teacher
     * @return ReturnJson
     */
    @Override
    public ReturnJson upSert(Teacher teacher) {
        int result = teacherMapper.upSert(teacher);
        log.info("upSert.result:{}", result);
        return ReturnJsonFactory.success(result != 0);
    }
}
