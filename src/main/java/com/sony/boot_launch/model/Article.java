package com.sony.boot_launch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author nsh
 * @date 2019/11/17 22:19:27
 */

@Builder                //可以类名直接构建一个对象
@Data                   //所有字段的get set toString equals hashCode 方法
@NoArgsConstructor      //无参数的构造方法
@AllArgsConstructor     //此注解 lombok 插件里的, 意思是所有参数的构造函数
public class Article {


    /**
     * id : 1
     * author : nsh
     * title : 开发spring boot
     * content : big data
     * createTime :
     * reader : [{"name":"nsh","age":18},{"name":"kobe","age":37}]
     */

    /**
     * json串
     * <p>
     * {
     * "id": 1,
     * "author": "nsh",
     * "title": "开发spring boot",
     * "content": "big data",
     * "createTime": "",
     * "reader":[{"name":"nsh","age":18},{"name":"kobe","age":37}]
     * }
     */


    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private List<Reader> reader;

}
