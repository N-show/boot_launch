package com.sony.boot_launch.service;

import com.sony.boot_launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author nsh
 * @date 2019/11/18 20:16:20
 */

@Slf4j
@Service
public class ArticleRestService {

    public String saveArticle(Article article) {

        log.info("saveArticle：{}", article);
        return "测试";
    }
}
