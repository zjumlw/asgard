package com.will.asgard.frigg.model;

import java.util.Date;

import lombok.Data;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-18 下午3:34
 * @Version 1.0
 */
@Data
public class Blog {
    private long id;
    private String title;
    private String author;
    private Date createTime;
    private long views;
}
