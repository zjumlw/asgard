package com.will.asgard.thor.mysql.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.will.asgard.thor.model.hello.Student;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-12 6:18 下午
 * @Version 1.0
 */
public class StudentDAOTest {

    private StudentDAO dao;

    @Before
    public void setUp() throws Exception {
        dao = new StudentDAO();
    }

    @Test
    public void testGetById() {
        Student student = dao.getStudentById(1);
        Assert.assertNotNull(student);
    }

    @Test
    public void testGetByName() {
        List<Student> students = dao.getStudentByName("c");
        Assert.assertNotNull(students);
        Assert.assertFalse(students.isEmpty());
    }

    @Test
    public void testInsert() {
        Student student = new Student();
        student.setName("玛丽");
        student.setSex("girl");
        int rows = dao.insertStudent(student);
        Assert.assertEquals(1, rows);
    }

    @Test
    public void testUpdate() {
        Student student = dao.getStudentById(1);
        student.setName("jack");
        student.setSex("boy");
        int rows = dao.updateStudent(student);
        Assert.assertEquals(1, rows);
    }

    @Test
    public void testDelete() {
        int rows = dao.deleteStudent(2);
        Assert.assertEquals(1, rows);
    }
}