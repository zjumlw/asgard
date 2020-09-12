package com.will.asgard.thor.mysql.dao;

import org.junit.Before;
import org.junit.Test;

import com.will.asgard.common.util.GsonUtil;
import com.will.asgard.thor.model.hello.Student;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-13 12:26 上午
 * @Version 1.0
 */
public class StudentDaoAnnoTest {

    private StudentDaoAnno dao;

    @Before
    public void setUp() throws Exception {
        dao = new StudentDaoAnno();
    }

    @Test
    public void testGetById() {
        Student student = dao.getStudentById(1);
        System.out.println(GsonUtil.toJson(student));
    }
}