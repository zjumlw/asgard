package com.will.asgard.frigg.model;

import java.util.List;

import lombok.Data;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-17 下午10:54
 * @Version 1.0
 */
@Data
public class Teacher {
    private long id;
    private String name;
    private List<Student> students;
}
