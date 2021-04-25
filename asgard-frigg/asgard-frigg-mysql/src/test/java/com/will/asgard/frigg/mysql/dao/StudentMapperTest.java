package com.will.asgard.frigg.mysql.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.will.asgard.frigg.model.Student;
import com.will.asgard.frigg.mysql.utils.MyBatisUtils;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-17 下午11:09
 * @Version 1.0
 */
public class StudentMapperTest {

    @Test
    public void testGetStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents();
        students.forEach(System.out::println);
    }

    @Test
    public void testGetStudentsV2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudentsV2();
        students.forEach(System.out::println);
    }
}