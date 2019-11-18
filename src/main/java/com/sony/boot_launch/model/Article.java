package com.sony.boot_launch.model;

import com.fasterxml.jackson.annotation.*;
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
@JsonPropertyOrder(value = {"content", "title"})    //改变json子属性的默认定义的顺序
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


    @JsonIgnore     //排除属性不做序列化操作
    private Long id;

    @JsonProperty("auther")   //为属性换一个名
    private String author;
    private String title;
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)  //排除为空的元素不做序列化反序列化
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")    //指定属性格式 日期类型需要识别 否则解析错误 不能反序列化 deserialize
    // 此处省略, 在 application.yml 中进行全局配置
    private Date createTime;
    private List<Reader> reader;

}
