package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/set")
    public String set(@RequestParam("key") String key, @RequestParam("value") String value) {

        redisTemplate.opsForValue().set(key, value);

        return "ok";
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable("key") String key) {

        return (String) redisTemplate.opsForValue().get(key);

    }

}
