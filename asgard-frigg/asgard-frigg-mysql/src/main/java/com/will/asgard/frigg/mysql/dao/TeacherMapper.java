package com.will.asgard.frigg.mysql.dao;

import java.util.List;

import com.will.asgard.frigg.model.Teacher;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-17 下午10:57
 * @Version 1.0
 */
public interface TeacherMapper {

    List<Teacher> getTeachers();

    Teacher getTeacherById(long id);
}
