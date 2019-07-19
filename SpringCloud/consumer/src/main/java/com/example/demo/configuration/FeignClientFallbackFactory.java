package com.example.demo.configuration;

import com.example.demo.pojo.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                FeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                User user = new User();
                user.setId(-1L);
                user.setName("默认用户");
                return user;
            }
        };
    }
}
