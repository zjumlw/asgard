package com.will.asgard.frigg.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.will.asgard.frigg.model.User;

/**
 * @Description 使用注解开发
 * 引入mapper
 * <mappers>
 *  <mapper class="com.will.asgard.frigg.mysql.dao.UserMapper2"/>
 * </mappers>
 * @Author maolingwei
 * @Date 2021-03-17 下午4:29
 * @Version 1.0
 */
public interface UserMapper2 {

    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id")long id);

    @Insert("insert into user (name, pwd) values (#{name}, #{pwd})")
    long addUser(User user);

    @Update("update user set name=#{name}, pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(long id);
}
