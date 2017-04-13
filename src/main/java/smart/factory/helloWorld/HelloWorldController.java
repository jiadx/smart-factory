package smart.factory.helloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiadx on 17-4-13.
 */
//@RestController和@RequestMapping注解是来自SpringMVC的注解，它们不是SpringBoot的特定部分。
@RestController
//@RestController：提供实现了REST API，可以服务JSON,XML或者其他。这里是以String的形式渲染出结果。
public class HelloWorldController {

    //@RequestMapping：提供路由信息，”/“路径的HTTP Request都会被映射到sayHello方法进行处理。
    @RequestMapping("/")
    public String sayHello() {
        return "hello world";
    }

}
