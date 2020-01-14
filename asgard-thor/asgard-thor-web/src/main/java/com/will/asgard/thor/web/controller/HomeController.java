package com.will.asgard.thor.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
