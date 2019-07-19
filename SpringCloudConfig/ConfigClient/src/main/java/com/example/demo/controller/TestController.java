package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 通过注解 @Value("${profile}")，绑定 Git 仓库配置文件中的 profile 属性。
    @Value("${profile}")
    private String profile;

    @GetMapping("/profile")
    public String hello() {
        return profile;
    }

}
