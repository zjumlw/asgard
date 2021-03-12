package com.will.asgard.thor.model.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-10 下午9:53
 * @Version 1.0
 */
@Service
public class UserServiceProxy implements UserService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    protected void log(String msg) {
        System.out.println("使用了" + msg + "方法");
    }
}
