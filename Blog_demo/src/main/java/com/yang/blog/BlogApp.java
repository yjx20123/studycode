package com.yang.blog;

import com.google.gson.Gson;
import com.yang.blog.utils.IdWorker;
import com.yang.blog.utils.JwtUtil;
import com.yang.blog.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Random;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class BlogApp {
    public static void main(String[] args) {
        SpringApplication.run(BlogApp.class, args);
    }

    @Bean
    public IdWorker createId() {
        return new IdWorker(0, 0);
    }

    @Bean
    public BCryptPasswordEncoder cryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RedisUtil createRedis() {
        return new RedisUtil();
    }

    @Bean
    public Random createRandom() {
        return new Random();
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    @Bean
    public Gson createGson() {
        return new Gson();
    }
}
