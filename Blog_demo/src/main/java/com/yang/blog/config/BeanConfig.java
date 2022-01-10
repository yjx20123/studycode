package com.yang.blog.config;

import com.yang.blog.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BeanConfig {
    @Bean
    public IdWorker getIdWorker(){
        return new IdWorker(0,0);
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
