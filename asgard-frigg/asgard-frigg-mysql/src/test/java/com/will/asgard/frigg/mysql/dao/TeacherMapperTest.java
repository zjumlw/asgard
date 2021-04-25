package com.will.asgard.frigg.mysql.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.will.asgard.common.util.GsonUtil;
import com.will.asgard.frigg.model.Teacher;
import com.will.asgard.frigg.mysql.utils.MyBatisUtils;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-17 下午11:02
 * @Version 1.0
 */
public class TeacherMapperTest {

    @Test
    public void testGetTeachers() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeachers();
        teachers.forEach(System.out::println);
    }

    @Test
    public void testGetTeacherById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById(1);
        System.out.println(GsonUtil.toJson(teacher));
    }

}