package com.will.asgard.thor.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.will.asgard.thor.model.demo.user.User;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-11 上午12:30
 * @Version 1.0
 */
public interface UserMapper {

    List<User> getAllUsers();

    @Select("SELECT * FROM user WHERE id = #{userId}")
    User getUserById(@Param("userId") long userId);

    @Insert("insert into user (name, age) values (#{name}, #{age})")
    long addUser(User user);

    @Update("<script>update user " +
            "<set>" +
            " <if test=\"name != null\">name=#{name},</if>" +
            " <if test=\"age != null\">age=#{age},</if>" +
            " </set>" +
            "where id=#{id}" +
            "</script>")
    long updateUser(User user);

    int deleteUser(long userId);
}
