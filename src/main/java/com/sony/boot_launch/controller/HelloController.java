package com.sony.boot_launch.controller;

import com.sony.boot_launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nsh
 * @date 2019/11/17 20:57:43
 */

@Slf4j              //log输出相关  省去了下面注释那句log
@RestController     //这个注解是将下面2个功能合并
//@ResponseBody       //将这个类所有的方法返回的数据直接写给浏览器 json数据
//@Controller         //能处理请求 标明Controller
public class HelloController {

//    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")       //接受来自浏览器的hello请求 localhost:8080/hello
    public Article hello() {
        Article nsh = new Article(1L, "nsh");
        Article article = new Article();
        nsh.setAuthor("zimug");

        Article haha = Article.builder().id(2L).author("haha").build();

        log.info("测试一下" + haha);

        return haha;
    }
}

