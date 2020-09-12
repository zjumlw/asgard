package com.will.asgard.thor.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.will.asgard.thor.model.hello.Student;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-13 12:13 上午
 * @Version 1.0
 */
public interface StudentMapper {

    @Select("select * from student where id=#{id}")
    Student selectStudentById(long id);

    @Select("select * from student where name like '%${name}%'")
    List<Student> selectStudentByName(String name);

    @Insert("insert into student (name, sex) values (#{name},#{sex})")
    long insertStudent(Student student);

    @Update("update student set name=#(name), sex=#{sex} where id=#{id}")
    long updateStudent(Student student);

    @Delete("delete from student where id=#{id}")
    long deleteStudent(long id);
}
