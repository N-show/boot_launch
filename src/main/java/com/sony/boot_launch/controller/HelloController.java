package com.sony.boot_launch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nsh
 * @date 2019/11/17 20:57:43
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
