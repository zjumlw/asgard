package com.will.asgard.frigg.mysql.dao;

import java.util.List;

import com.will.asgard.frigg.model.Student;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-17 下午10:57
 * @Version 1.0
 */
public interface StudentMapper {

    List<Student> getStudents();

    List<Student> getStudentsV2();
}
