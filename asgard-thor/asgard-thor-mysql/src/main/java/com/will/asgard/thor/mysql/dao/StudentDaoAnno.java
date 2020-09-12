package com.will.asgard.thor.mysql.dao;

import org.apache.ibatis.session.SqlSession;

import com.will.asgard.thor.model.hello.Student;
import com.will.asgard.thor.mysql.mapper.StudentMapper;
import com.will.asgard.thor.mysql.utils.SqlSessionFactoryUtil;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-13 12:25 上午
 * @Version 1.0
 */
public class StudentDaoAnno {

    public Student getStudentById(long id) {
        SqlSession session = SqlSessionFactoryUtil.openSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.selectStudentById(id);
        SqlSessionFactoryUtil.closeSession(session);
        return student;
    }
}
