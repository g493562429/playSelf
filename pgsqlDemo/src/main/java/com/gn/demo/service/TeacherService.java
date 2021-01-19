package com.gn.demo.service;

import com.gn.demo.dto.Teacher;
import com.gn.demo.model.ReturnJson;

/**
 * @Author: gn
 * @Date: 2020-10-26
 * @Description:
 */
public interface TeacherService {
    /**
     * 通过id查询
     * @param id 主键
     * @return ReturnJson
     */
    ReturnJson selectById(int id);

    /**
     * 插入一条数据
     * @param teacher teacher实体类
     * @return ReturnJson 成功为true,失败为false
     */
    ReturnJson add(Teacher teacher);

    /**
     * 根据id修改数据
     * @param teacher teacher实体类
     * @return ReturnJson 成功为true,失败为false
     */
    ReturnJson updateById(Teacher teacher);

    /**
     * 删除一条数据
     * @param id 主键
     * @return ReturnJson 成功为true,失败为false
     */
    ReturnJson deleteById(Integer id);

    /**
     * 根据名字查询
     * @param name 名字
     * @return ReturnJson
     */
    ReturnJson selectByName(String name);

    /**
     * 根据传来的某一条属性进行查询
     * @param teacher teacher实体类
     * @return ReturnJson
     */
    ReturnJson select(Teacher teacher);

    /**
     * 查询teacher列表方法
     * @return ReturnJson
     */
    ReturnJson selectTeachers();

    /**
     * 新增/修改
     * @param teacher teacher
     * @return ReturnJson
     */
    ReturnJson upSert(Teacher teacher);
}
