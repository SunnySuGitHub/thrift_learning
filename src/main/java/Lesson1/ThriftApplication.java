package Lesson1;

import Lesson1.Hello.HelloServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Description:thrift_learning
 * Created by Administrator on 2020/5/23
 */
@SpringBootApplication
public class ThriftApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThriftApplication.class, args);
    }


    /**
     * 通过注册Bean或者通过多个@Component注解的方式可以注册多个Thrift Server端
     * 每个Server端可以专注于某特定服务的提供，可以理解为某Controller提供的服务
     */
    @Bean(initMethod = "init")
    public HelloServer helloServer() {
        HelloServer server = new HelloServer();
        return server;
    }
}
