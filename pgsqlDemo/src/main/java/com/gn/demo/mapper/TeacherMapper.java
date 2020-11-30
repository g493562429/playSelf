package com.gn.demo.mapper;

import com.gn.demo.dto.Teacher;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: gn
 * @Date: 2020-10-26
 * @Description:
 */
@Mapper
@Repository
public interface TeacherMapper {
    Teacher selectTeacherById(int id);

    int addTeacher(Teacher teacher);

    int updateById(Teacher teacher);

    int deleteById(Integer id);

    Teacher selectTeacherByName(String name);
}
