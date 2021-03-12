package com.will.asgard.thor.mysql.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.will.asgard.thor.model.hello.Student;
import com.will.asgard.thor.mysql.utils.SqlSessionFactoryUtil;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-12 4:01 下午
 * @Version 1.0
 */
public class StudentDAO {

    public Student getStudentById(long id) {
        // 加载mybatis的配置文件
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
        // 构建session的工厂
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(stream);
        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = ssf.openSession();
        // 映射sql的标识字符串
        return session.selectOne(
                "com.will.asgard.thor.mysql.dao.studentMapper.selectStudentById", id);
    }

    public List<Student> getStudentByName(String name) {
        SqlSession session = SqlSessionFactoryUtil.openSession(true);
        List<Student> students = session.selectList(
                "com.will.asgard.thor.mysql.dao.studentMapper.selectStudentByName", name);
        SqlSessionFactoryUtil.closeSession(session);
        return students;
    }

    public int insertStudent(Student student) {
        SqlSession session = SqlSessionFactoryUtil.openSession(true);
        int rows = session.insert("com.will.asgard.thor.mysql.dao.studentMapper.insertStudent", student);
        SqlSessionFactoryUtil.closeSession(session);
        return rows;
    }

    public int updateStudent(Student student) {
        SqlSession session = SqlSessionFactoryUtil.openSession(true);
        int rows = session.update("com.will.asgard.thor.mysql.dao.studentMapper.updateStudent", student);
        SqlSessionFactoryUtil.closeSession(session);
        return rows;
    }

    public int deleteStudent(long id) {
        SqlSession session = SqlSessionFactoryUtil.openSession(true);
        int rows = session.delete("com.will.asgard.thor.mysql.dao.studentMapper.deleteStudent", id);
        SqlSessionFactoryUtil.closeSession(session);
        return rows;
    }
}
