package com.will.asgard.frigg.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-13 上午12:01
 * @Version 1.0
 */
@Data
public class User implements Serializable {
    private long id;
    private String name;
    private String pwd;
}
