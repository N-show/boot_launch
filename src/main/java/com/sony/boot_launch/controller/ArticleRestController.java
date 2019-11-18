package com.sony.boot_launch.controller;

import com.sony.boot_launch.model.AjaxResponse;
import com.sony.boot_launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {


    //    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article) {

        log.info("saveArticle：{}", article);
        return AjaxResponse.success(article);
    }

    //    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {

        log.info("deleteArticle：{}", id);
        return AjaxResponse.success(id);
    }

    //    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);

        log.info("updateArticle：{}", article);
        return AjaxResponse.success(article);
    }

    //    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {

        Article article1 = Article.builder().id(1L).author("zimug").content("spring boot 2.深入浅出").createTime(new Date()).title("t1").build();
        return AjaxResponse.success(article1);
    }
}
