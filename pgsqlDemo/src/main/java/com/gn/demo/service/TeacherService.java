package com.gn.demo.service;

import com.gn.demo.dto.Teacher;

/**
 * @Author: gn
 * @Date: 2020-10-26
 * @Description:
 */
public interface TeacherService {
    Teacher selectById(int id);

    Boolean add(Teacher teacher);

    Boolean updateById(Teacher teacher);

    Boolean deleteById(Integer id);

    Teacher selectByName(String name);
}
