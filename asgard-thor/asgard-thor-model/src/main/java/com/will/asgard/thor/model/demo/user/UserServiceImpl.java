package com.will.asgard.thor.model.demo.user;

import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-10 下午9:10
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("增加");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }

    @Override
    public void query() {
        System.out.println("查询");
    }
}
