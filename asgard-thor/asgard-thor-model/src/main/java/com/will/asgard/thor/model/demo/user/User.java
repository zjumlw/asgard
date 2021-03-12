package com.will.asgard.thor.model.demo.user;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-03 下午8:41
 * @Version 1.0
 */
public class User {

    private long id;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
