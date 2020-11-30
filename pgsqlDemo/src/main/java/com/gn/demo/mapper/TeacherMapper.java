package com.gn.demo.mapper;

import com.gn.demo.dto.Teacher;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: gn
 * @Date: 2020-10-26
 * @Description:
 */
@Mapper
@Repository
public interface TeacherMapper {
    /**
     * 通过id查询
     * @param id 主键
     * @return Teacher
     */
    Teacher selectTeacherById(int id);

    /**
     * 插入一条数据
     * @param teacher teacher实体类
     * @return 成功为1,失败为0
     */
    int addTeacher(Teacher teacher);

    /**
     * 根据id修改数据
     * @param teacher teacher实体类
     * @return 成功为1,失败为0
     */
    int updateById(Teacher teacher);

    /**
     * 删除一条数据
     * @param id 主键
     * @return 成功为1,失败为0
     */
    int deleteById(Integer id);

    /**
     * 根据名字查询
     * @param name 名字
     * @return teacher实体类
     */
    Teacher selectTeacherByName(String name);

    /**
     * 根据传来的某一条属性进行查询
     * @param teacher teacher实体类
     * @return teacher实体类
     */
    List<Teacher> select(Teacher teacher);
}
