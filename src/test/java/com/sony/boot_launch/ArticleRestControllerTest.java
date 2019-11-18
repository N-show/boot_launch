package com.sony.boot_launch;

import com.sony.boot_launch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@SpringBootTest //提供了一个application的上下文环境 没有启动 Servlet 容器, 此环境下 @Resource 和 @Autowired 注解的bean为null

//mockMvc使用@Resource自动注入，删掉Before注解及setUp函数

@RunWith(SpringRunner.class)    //构造了一个的Servlet容器运行运行环境，并在此环境下测试
@AutoConfigureMockMvc
//该注解表示 MockMvc由我来构建, 省略setUp中创建的步骤 你只负责用就可以了。这种写法是为了让测试在 Servlet 容器环境下执行 可以使用 @Resource 和 @Autowired 来引用
public class ArticleRestControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Resource
    ArticleRestService articleRestService;

//    @Before
//    public void setUp() {
//
//        //mock模拟了请求和响应的部分 springboot提供了运行环境
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
//    }

    @Test
    public void saveArticle() throws Exception {

        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"nsh\",\n" +
                "    \"title\": \"开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
                "    \"reader\":[{\"name\":\"nsh\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        log.info(article);

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/article")
                        .contentType("application/json").content(article))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("nsh"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print())
                .andReturn();

        log.info(result.getResponse().getContentAsString());

    }
}

