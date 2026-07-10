package com.will.asgard.thor.hammer.controller;

import com.will.asgard.thor.hammer.result.WebResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示控制器
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    /**
     * 健康检查接口
     */
    @GetMapping("/health")
    public WebResult<String> health() {
        return WebResult.success("Asgard Thor Hammer is running!");
    }

    /**
     * 欢迎接口
     */
    @GetMapping("/welcome")
    public WebResult<String> welcome() {
        return WebResult.success("Welcome to Asgard Thor Hammer!");
    }
}
