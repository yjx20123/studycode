package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig {
    @Bean
    public User user(){
        return new User();
    }
}
