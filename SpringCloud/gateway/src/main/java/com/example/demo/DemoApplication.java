package com.example.demo;

import com.example.demo.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy // 声明一个 Zuul 代理。
// 该代理使用 Ribbon 来定位注册在 Eureka Server 中的微服务；
// 同时，该代理还整合了 Hystrix，从而实现了容错，所有经过 Zuul 的请求都会在 Hystrix 命令中执行。
public class DemoApplication {

    @Bean
    public PreRequestLogFilter preRequestLogFilter() {
        return new PreRequestLogFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
